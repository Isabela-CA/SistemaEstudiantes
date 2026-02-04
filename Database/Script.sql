create database estudiantes_db;

use estudiantes_db;

create table estudiante (
	id_estudiante int auto_increment,
	nombre varchar(45),
	apellido varchar(45),
	telefono varchar(45),
	email varchar(45)
)auto_increment = 1;

--  --------- Datos -----------

INSERT INTO estudiante (nombre, apellido, telefono, email) VALUES 
('Juan', 'Pérez', '5550101', 'juan.perez@email.com'),
('María', 'García', '5550102', 'maria.garcia@email.com'),
('Carlos', 'López', '5550103', 'carlos.lopez@email.com'),
('Ana', 'Martínez', '5550104', 'ana.martinez@email.com'),
('Luis', 'Rodríguez', '5550105', 'luis.rodriguez@email.com'),
('Elena', 'Sánchez', '5550106', 'elena.sanchez@email.com'),
('Diego', 'Ramírez', '5550107', 'diego.ramirez@email.com'),
('Sofía', 'Torres', '5550108', 'sofia.torres@email.com'),
('Javier', 'Gómez', '5550109', 'javier.gomez@email.com'),
('Lucía', 'Díaz', '5550110', 'lucia.diaz@email.com');