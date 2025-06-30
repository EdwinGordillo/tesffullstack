-- 1. Crear base de datos
CREATE DATABASE IF NOT EXISTS bd_gordillo;
USE bd_gordillo;

-- 2. Crear tabla person
CREATE TABLE IF NOT EXISTS person (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fechaNacimiento DATE NOT NULL,
    puesto VARCHAR(100) NOT NULL,
    sueldo DECIMAL(10, 2) NOT NULL
);

-- 3. Crear usuario (ejecutar con cuenta con privilegios suficientes)
CREATE USER IF NOT EXISTS 'conexion'@'localhost' IDENTIFIED BY 'W@lmDev_2025#Ok!';

-- 4. Otorgar permisos
GRANT ALL PRIVILEGES ON bd_gordillo.* TO 'conexion'@'localhost';
FLUSH PRIVILEGES;