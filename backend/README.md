# Backend - Prueba Técnica Fullstack

Este proyecto representa el backend de una aplicación web desarrollada como parte de una prueba técnica fullstack, en la cual se implementa un CRUD de personas utilizando Java 8, Spring Boot, JPA y MySQL.

---

## Descripción del proyecto

Se implementó un backend RESTful que permite crear, consultar, actualizar y eliminar registros de personas. Cada registro contiene:

- Nombre
- Apellido
- Fecha de nacimiento
- Puesto
- Sueldo

La aplicación está estructurada siguiendo buenas prácticas de diseño, principios SOLID y una arquitectura en capas.

---

## Modelo utilizado

El modelo implementado fue una arquitectura en capas MVC (Model-View-Controller) desacoplada, estructurada de la siguiente manera:

```bash
src/main/java/co/com/walmart/stefanini/prueba/PruebaWalmart/
├── controller/              # Manejo de peticiones HTTP
├── service/                 # Lógica de negocio
│   └── impl/                # Implementación de la lógica
├── repository/              # Acceso a base de datos (JPA)
├── entity/                  # Entidades de base de datos
├── dto/                     # Estructura de respuestas estándar
├── exception/               # Manejo global de errores
└── PruebaWalmartApplication.java 
```

## Cómo levantar y ejecutar el proyecto backend

Este backend está construido con Java 8 y Spring Boot, utilizando Maven como herramienta de construcción. A continuación se detallan los pasos necesarios para ejecutar el proyecto localmente.

---

### 1. Requisitos previos

Asegúrate de tener instalado en tu equipo:

- **Java 8 (JDK 1.8)**
- **Maven**
- **Git**
- Un editor o IDE como **Visual Studio Code** o **IntelliJ IDEA**

---

### 2. Clonar el repositorio

Desde la terminal, ejecuta los siguientes comandos:

```bash
git clone https://github.com/EdwinGordillo/tesffullstack
cd tesffullstack
git checkout gordillo_backend
```

### 3. Ejecutar el proyecto en una terminal

## Linux
```
./mvnw spring-boot:run
```

## Windows
```
mvnw.cmd spring-boot:run
```

## IDE
También puedes abrir el proyecto en tu IDE y ejecutar la clase principal PruebaWalmartApplication.java, ubicada en:
```
src/main/java/co/com/walmart/stefanini/prueba/PruebaWalmart/
```

### 4. Acceder a los endpoints
```
http://localhost:8080
```

| Método | Ruta                 | Descripción                      |
| ------ | -------------------- | -------------------------------- |
| GET    | `/api/personas`      | Listar todas las personas        |
| GET    | `/api/personas/{id}` | Obtener una persona por ID       |
| POST   | `/api/personas`      | Crear una nueva persona          |
| PUT    | `/api/personas/{id}` | Actualizar una persona existente |
| DELETE | `/api/personas/{id}` | Eliminar una persona por ID      |