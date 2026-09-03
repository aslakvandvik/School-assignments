# Car Rental Management System

## Description

This project is a web-based application for managing a car rental service. It enables users to create, read, update, and delete (CRUD) data entries related to employees, cars, and customers, and leverages a Neo4j database for data storage. The application is built using Flask for the web interface, allowing user interaction via forms and routes, and Neo4j for graph-based data management.

## Features

1. **User Interaction**: Accepts user input to retrieve specific user data.
2. **Database Management**: Supports creating, reading, updating, and deleting records for employees, cars, and customers.
3. **Neo4j Integration**: Establishes and manages a connection to a Neo4j database for persistent data storage.

## Project Structure

- **hello.py**: Handles the main Flask route, rendering an index page to display user data or errors based on input.
- **User.py**: Contains the classes and functions necessary for interacting with Neo4j, including:
  - `Employee`, `Car`, and `Customer` classes for representing entities.
  - Database CRUD operations for each entity.
  - Database connection logic with Neo4j.

## Setup and Installation

### Prerequisites

- Python 3.x
- Flask
- Neo4j
- Neo4j Python Driver

### Installation

1. **Clone the Repository**:
   ```bash
   git clone <repository_url>
   ```
2. **Install Required Packages**:
   ```bash
   pip install -r requirements.txt
   ```
   Ensure you add Flask and Neo4j packages in `requirements.txt` if not already included.

3. **Neo4j Database Setup**:
   - Set up a Neo4j database instance.
   - Replace `URI` and `AUTH` credentials in `User.py` with your own database details.

4. **Run the Flask Application**:
   ```bash
   export FLASK_APP=hello.py
   flask run
   ```

## Usage

1. Navigate to the homepage at `http://localhost:5000`.
2. Enter a username in the form to retrieve user data or interact with the application.

## Code Overview

### hello.py
- **Routes**: Manages the `/` route for GET and POST requests.
- **Data Retrieval**: Calls functions to fetch user data based on the input username.

### User.py
- **Classes**: 
  - `Employee`: Represents an employee and includes methods for database operations.
  - `Car`: Represents a car and includes methods for database operations.
  - `Customer`: Represents a customer and includes methods for database operations.
- **Functions**:
  - `create_employee`, `save_car`, `create_customer`: Functions for adding new entries to the Neo4j database.
  - Database CRUD functions for each entity type, e.g., `read_employee`, `update_employee`.

