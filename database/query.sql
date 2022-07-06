CREATE TABLE etudient(
   id SERIAL PRIMARY KEY,
   filiere INT,
   name VARCHAR(25) ,
   prenom VARCHAR(25),
   date_entree DATE,
   age INT
);