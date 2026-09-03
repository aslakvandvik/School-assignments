from neo4j import GraphDatabase, Driver
import random

URI = "neo4j+ssc://b41618ba.databases.neo4j.io"
AUTH = ("neo4j", "kXhTM8agdagzrvztaIDVKYRFdA6KEohr77HM8UUZLRo")

def _get_connection() -> Driver:
    driver = GraphDatabase.driver(URI, auth=AUTH)
    driver.verify_connectivity()
    return driver

driver = _get_connection()

def extract_node_data(records, label):
    # Helper function to extract and format data for consistency
    data = []
    for record in records:
        node = record.get(label)
        if node:
            data.append(dict(node))
    return data

# Order-related functions

def order_car(car_id, customer_id):
    with driver.session() as session:
        try:
            car_id = int(car_id)
            customer_id = int(customer_id)
        except ValueError:
            return None, "Invalid car_id or customer_id format; must be integers."
        
        # Ensure customer hasn't booked another car
        existing_order = session.run(
            "MATCH (cu:Customer {id: $customer_id})-[:ORDERED]->(c:Car) RETURN c",
            customer_id=customer_id
        )
        
        if existing_order.single():
            return None, "Customer has already booked another car."
        
        # Check if car is available and set to booked
        car_status = session.run("MATCH (c:Car {id: $id}) RETURN c.status AS status", id=car_id).single()
        if car_status and car_status["status"] == "available":
            order = session.run(
                "MATCH (c:Car {id: $car_id}), (cu:Customer {id: $customer_id}) "
                "MERGE (cu)-[:ORDERED]->(c) "
                "SET c.status = 'booked' "
                "RETURN c",
                car_id=car_id, customer_id=customer_id
            )
            return extract_node_data(list(order), "c"), "Car ordered successfully"
        else:
            return None, "Car is not available"

def cancel_order_car(car_id, customer_id):
    with driver.session() as session:
        try:
            car_id = int(car_id)
            customer_id = int(customer_id)
        except ValueError:
            return None, "Invalid car_id or customer_id format; must be integers."

        cancel_order = session.run(
            "MATCH (cu:Customer {id: $customer_id})-[r:ORDERED]->(c:Car {id: $car_id}) "
            "DELETE r "
            "SET c.status = 'available' "
            "RETURN c",
            car_id=car_id, customer_id=customer_id
        )
        return extract_node_data(list(cancel_order), "c"), "Order canceled and car set to available"

def rent_car(car_id, customer_id):
    with driver.session() as session:
        try:
            car_id = int(car_id)
            customer_id = int(customer_id)
        except ValueError:
            return None, "Invalid car_id or customer_id format; must be integers."

        rental = session.run(
            "MATCH (cu:Customer {id: $customer_id})-[r:ORDERED]->(c:Car {id: $car_id}) "
            "DELETE r "
            "SET c.status = 'rented' "
            "MERGE (cu)-[:RENTED]->(c) "
            "RETURN c",
            car_id=car_id, customer_id=customer_id
        )
        return extract_node_data(list(rental), "c"), "Car rented successfully"

def return_car(car_id, customer_id, car_status):
    with driver.session() as session:
        try:
            car_id = int(car_id)
            customer_id = int(customer_id)
        except ValueError:
            return None, "Invalid car_id or customer_id format; must be integers."

        return_car = session.run(
            "MATCH (cu:Customer {id: $customer_id})-[r:RENTED]->(c:Car {id: $car_id}) "
            "DELETE r "
            "SET c.status = $car_status "
            "RETURN c",
            car_id=car_id, customer_id=customer_id, car_status=car_status
        )
        return extract_node_data(list(return_car), "c"), f"Car returned and set to {car_status}"

# --- CAR CRUD FUNCTIONS ---

def create_car(brand, model, year, location):
    with driver.session() as session:
        car_id = random.randint(999, 9999)
        car = session.run(
            "CREATE (c:Car {brand: $brand, model: $model, year: $year, location: $location, id: $id, status: 'available'}) RETURN c",
            brand=brand, model=model, year=year, location=location, id=car_id
        )
        car_data_raw = list(car)
        print("Raw Data Returned by Neo4j (Car):", car_data_raw)
        return extract_node_data(car_data_raw, "c"), "Car added to database"

def read_car(car_id):
    with driver.session() as session:
        try:
            car_id = int(car_id)
        except ValueError:
            return None, "Invalid car_id format; must be an integer."

        car = session.run("MATCH (c:Car {id: $id}) RETURN c", id=car_id)
        car_data_raw = list(car)
        print("Raw Data Returned by Neo4j (Car):", car_data_raw)
        return extract_node_data(car_data_raw, "c"), "Car found in database"

def update_car(car_id, brand, model, year, location, status):
    with driver.session() as session:
        try:
            car_id = int(car_id)
        except ValueError:
            return None, "Invalid car_id format; must be an integer."

        car = session.run(
            "MATCH (c:Car {id: $id}) "
            "SET c.brand = $brand, c.model = $model, c.year = $year, c.location = $location, c.status = $status "
            "RETURN c",
            id=car_id, brand=brand, model=model, year=year, location=location, status=status
        )
        car_data_raw = list(car)
        print("Raw Data Returned by Neo4j (Updated Car):", car_data_raw)
        return extract_node_data(car_data_raw, "c"), "Car updated in database"

def delete_car(car_id):
    with driver.session() as session:
        try:
            car_id = int(car_id)
        except ValueError:
            return None, "Invalid car_id format; must be an integer."

        result = session.run("MATCH (c:Car {id: $id}) DELETE c RETURN COUNT(c) AS deleted_count", id=car_id)
        deleted_count = result.single().get("deleted_count", 0)
        return None, "Car deleted from database" if deleted_count > 0 else "Car not found or delete failed"

# --- CUSTOMER CRUD FUNCTIONS ---

def create_customer(name, age, address):
    with driver.session() as session:
        customer_id = random.randint(999, 9999)
        customer = session.run(
            "CREATE (c:Customer {name: $name, age: $age, address: $address, id: $id}) RETURN c",
            name=name, age=age, address=address, id=customer_id
        )
        customer_data_raw = list(customer)
        print("Raw Data Returned by Neo4j (Customer):", customer_data_raw)
        return extract_node_data(customer_data_raw, "c"), "Customer added to database"

def read_customer(customer_id):
    with driver.session() as session:
        try:
            customer_id = int(customer_id)
        except ValueError:
            return None, "Invalid customer_id format; must be an integer."

        customer = session.run("MATCH (c:Customer {id: $id}) RETURN c", id=customer_id)
        customer_data_raw = list(customer)
        print("Raw Data Returned by Neo4j (Customer):", customer_data_raw)
        return extract_node_data(customer_data_raw, "c"), "Customer found in database"

def update_customer(customer_id, name, age, address):
    with driver.session() as session:
        try:
            customer_id = int(customer_id)
        except ValueError:
            return None, "Invalid customer_id format; must be an integer."

        customer = session.run(
            "MATCH (c:Customer {id: $id}) "
            "SET c.name = $name, c.age = $age, c.address = $address "
            "RETURN c",
            id=customer_id, name=name, age=age, address=address
        )
        customer_data_raw = list(customer)
        print("Raw Data Returned by Neo4j (Updated Customer):", customer_data_raw)
        return extract_node_data(customer_data_raw, "c"), "Customer updated in database"

def delete_customer(customer_id):
    with driver.session() as session:
        try:
            customer_id = int(customer_id)
        except ValueError:
            return None, "Invalid customer_id format; must be an integer."

        result = session.run("MATCH (c:Customer {id: $id}) DELETE c RETURN COUNT(c) AS deleted_count", id=customer_id)
        deleted_count = result.single().get("deleted_count", 0)
        return None, "Customer deleted from database" if deleted_count > 0 else "Customer not found or delete failed"

# --- EMPLOYEE CRUD FUNCTIONS ---

def create_employee(name, address, branch):
    with driver.session() as session:
        employee_id = random.randint(999, 9999)
        employee = session.run(
            "CREATE (e:Employee {name: $name, address: $address, branch: $branch, id: $id}) RETURN e",
            name=name, address=address, branch=branch, id=employee_id
        )
        employee_data_raw = list(employee)
        print("Raw Data Returned by Neo4j (Employee):", employee_data_raw)
        return extract_node_data(employee_data_raw, "e"), "Employee added to database"

def read_employee(employee_id):
    with driver.session() as session:
        try:
            employee_id = int(employee_id)
        except ValueError:
            return None, "Invalid employee_id format; must be an integer."

        employee = session.run("MATCH (e:Employee {id: $id}) RETURN e", id=employee_id)
        employee_data_raw = list(employee)
        print("Raw Data Returned by Neo4j (Employee):", employee_data_raw)
        return extract_node_data(employee_data_raw, "e"), "Employee found in database"

def update_employee(employee_id, name, address, branch):
    with driver.session() as session:
        try:
            employee_id = int(employee_id)
        except ValueError:
            return None, "Invalid employee_id format; must be an integer."

        employee = session.run(
            "MATCH (e:Employee {id: $id}) "
            "SET e.name = $name, e.address = $address, e.branch = $branch "
            "RETURN e",
            id=employee_id, name=name, address=address, branch=branch
        )
        employee_data_raw = list(employee)
        print("Raw Data Returned by Neo4j (Updated Employee):", employee_data_raw)
        return extract_node_data(employee_data_raw, "e"), "Employee updated in database"

def delete_employee(employee_id):
    with driver.session() as session:
        try:
            employee_id = int(employee_id)
        except ValueError:
            return None, "Invalid employee_id format; must be an integer."

        result = session.run("MATCH (e:Employee {id: $id}) DELETE e RETURN COUNT(e) AS deleted_count", id=employee_id)
        deleted_count = result.single().get("deleted_count", 0)
        return None, "Employee deleted from database" if deleted_count > 0 else "Employee not found or delete failed"

driver.close()
