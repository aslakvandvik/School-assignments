-- Oppgave 1 a) 

CREATE TABLE Customer (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(50),
    ContactName VARCHAR(50),
    Address VARCHAR(50),
    City VARCHAR(50),
    PostalCode VARCHAR(10),
    Country VARCHAR(50)
);

-- b) 
INSERT INTO Customer (CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES (1, 'Alfreds Futterkiste', 'Maria Anders', 'Obere Str. 57', 'Berlin', '12209', 'Germany');
