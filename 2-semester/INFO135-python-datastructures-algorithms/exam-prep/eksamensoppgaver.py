"""Implement a Python program according to the following description:
(1) implement a class called Car that has the following methods:
a constructor that receives as parameters the model, company name, registration ID, and
the production year of a Car and sets them as instance variables. The constructor has a
boolean variable called is_available which is initially set to True.
a method called get_brand() that returns the company name of the Car.
a method called get_prod_year() that returns the year the car was produced.

(2) Now, implement a new class called CarSharing that has a class variable called
total_num_cars to store the total number of Car instances. The initial value of the variable is set
to 0. The CarSharing class should have the following methods:

a constructor that creates an empty list called shared_cars that will store all the instances
of Cars in the car sharing service.

a method add_car() that receives as parameter the model, company, registration ID, and
the production year of a Car and creates an instance of Car and adds (appends) it to the
shared_cars. Then, the method increments the class variable total_num_cars by 1.

a class method called print_total_num_cars() that prints the stored value of class variable
total_num_cars.
Note: you can write more methods if needed."""

class Car:
    def __init__(self, model, company, reg_id, prod_year):
        self.model = model
        self.company = company
        self.reg_id = reg_id
        self.prod_year = prod_year
        self.is_available = True

    def get_brand(self):
        return self.company

    def get_prod_year(self):
        return self.prod_year
    
class CarSharing:
    