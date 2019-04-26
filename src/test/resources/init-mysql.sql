DROP TABLE IF EXISTS Clinics;

CREATE TABLE Clinics (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
	city VARCHAR(255) NOT NULL,
	street_address VARCHAR(255) NOT NULL
);

INSERT INTO Clinics (name, city, street_address) VALUES ('County General Hospital', 'Chicago', '123 Hospital Lane');