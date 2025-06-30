# Configuración de Base de Datos - Examen Fullstack

Este repositorio contiene el script necesario para crear la base de datos utilizada en la prueba técnica para desarrollador Fullstack.

## Estructura de la Base de Datos

- **Nombre de la base de datos:** `bd_gordillo`
- **Tabla principal:** `person`

### Definición de la tabla `person`

| Campo           | Tipo           | Descripción                         |
|----------------|----------------|-------------------------------------|
| `id`           | INT            | Clave primaria, autoincremental     |
| `nombre`       | VARCHAR(50)    | Nombre de la persona                |
| `apellido`     | VARCHAR(50)    | Apellido de la persona              |
| `fecha_nacimiento` | DATE        | Fecha de nacimiento                 |
| `puesto`       | VARCHAR(100)   | Puesto que ocupa la persona         |
| `sueldo`       | DECIMAL(10,2)  | Sueldo mensual                      |

---

## Usuario de Conexión

Se creó un usuario MySQL con el siguiente detalle:

- **Usuario:** `conexion`
- **Contraseña:** `W@lmDev_2025#Ok!`
- **Permisos:** Todos los privilegios sobre la base de datos `bd_gordillo`

---

## Uso del script

### 1. Abrir phpMyAdmin o consola MySQL

### 2. Ejecutar el script
