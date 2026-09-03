CREATE DATABASE Art_Gallery;
USE Art_Gallery;

CREATE TABLE Art_Publisher (
    Name VARCHAR(100) PRIMARY KEY,         -- Publisher's name (Primary Key)
    Address VARCHAR(255) NOT NULL,         -- Publisher's address
    Telephone VARCHAR(20) NOT NULL         -- Publisher's telephone number
);


CREATE TABLE Art (
    Art_id INT PRIMARY KEY AUTO_INCREMENT, -- Unique Art identifier (Primary Key)
    Style VARCHAR(100) NOT NULL,           -- Art style
    Location VARCHAR(100) NOT NULL,        -- Location of the art piece
    Publisher VARCHAR(100),                -- Foreign key referencing the Publisher's Name
    FOREIGN KEY (Publisher) REFERENCES Art_Publisher(Name)
        ON DELETE SET NULL                 -- If the publisher is deleted, set the value to NULL
);


CREATE TABLE Artist (
    Art_id INT,                            
    Artist_name VARCHAR(100) NOT NULL,     
    PRIMARY KEY (Art_id),                  
    FOREIGN KEY (Art_id) REFERENCES Art(Art_id)
        ON DELETE CASCADE                  
);


CREATE TABLE `Order` (
    Order_id INT PRIMARY KEY AUTO_INCREMENT,  
    Art_id INT,                               
    Date DATE NOT NULL,                       
    Price DECIMAL(10, 2) NOT NULL,            
    FOREIGN KEY (Art_id) REFERENCES Art(Art_id)
        ON DELETE CASCADE                     
);

