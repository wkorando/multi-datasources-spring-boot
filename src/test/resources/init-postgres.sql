DROP TABLE IF EXISTS DOCTORS;

CREATE TABLE DOCTORS (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	specialization VARCHAR(100)
);

INSERT INTO DOCTORS (first_name, last_name, specialization) VALUES ('Perry','Cox','Chief Surgeon');
INSERT INTO DOCTORS (first_name, last_name, specialization) VALUES ('Bob','Kelso','Chief of Medicine');