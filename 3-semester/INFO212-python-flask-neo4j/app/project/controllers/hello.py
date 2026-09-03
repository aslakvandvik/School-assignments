from project import app
from flask import request, jsonify
import project.models.User as user

# Endpoint to order a car
@app.route('/order-car', methods=['POST'])
def order_car():
    car_id = request.form["car_id"]
    customer_id = request.form["customer_id"]
    
    # Check if the customer has booked another car and order if possible
    result, message = user.order_car(car_id, customer_id)
    
    if result:
        return jsonify({"message": message, "data": result}), 200
    else:
        return jsonify({"error": message}), 400

# Endpoint to cancel an order
@app.route('/cancel-order-car', methods=['POST'])
def cancel_order_car():
    car_id = request.form["car_id"]
    customer_id = request.form["customer_id"]
    
    # Check if the customer has booked the car and cancel if possible
    result, message = user.cancel_order_car(car_id, customer_id)
    
    if result:
        return jsonify({"message": message, "data": result}), 200
    else:
        return jsonify({"error": message}), 400

# Endpoint to rent a car
@app.route('/rent-car', methods=['POST'])
def rent_car():
    car_id = request.form["car_id"]
    customer_id = request.form["customer_id"]
    
    # Check if the customer has a booking for the car and rent if possible
    result, message = user.rent_car(car_id, customer_id)
    
    if result:
        return jsonify({"message": message, "data": result}), 200
    else:
        return jsonify({"error": message}), 400

# Endpoint to return a car
@app.route('/return-car', methods=['POST'])
def return_car():
    car_id = request.form["car_id"]
    customer_id = request.form["customer_id"]
    car_status = request.form["status"]
    
    # Check if the customer has rented the car and update status accordingly
    result, message = user.return_car(car_id, customer_id, car_status)
    
    if result:
        return jsonify({"message": message, "data": result}), 200
    else:
        return jsonify({"error": message}), 400
