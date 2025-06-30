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

### Cómo levantar y ejecutar el proyecto backend

Este backend está construido con Java 8 y Spring Boot, utilizando Maven como herramienta de construcción. A continuación se detallan los pasos necesarios para ejecutar el proyecto localmente.

---

## 1. Requisitos previos

Asegúrate de tener instalado en tu equipo:

- **Java 8 (JDK 1.8)**
- **Maven**
- **Git**
- Un editor o IDE como **Visual Studio Code** o **IntelliJ IDEA**

---

## 2. Clonar el repositorio

Desde la terminal, ejecuta los siguientes comandos:

```bash
git clone https://github.com/EdwinGordillo/tesffullstack
cd tesffullstack
git checkout gordillo_backend
```

## 3. Ejecutar el proyecto en una terminal

# Linux
```
./mvnw spring-boot:run
```

# Windows
```
mvn spring-boot:run
```

# IDE
También puedes abrir el proyecto en tu IDE y ejecutar la clase principal PruebaWalmartApplication.java, ubicada en:
```
src/main/java/co/com/walmart/stefanini/prueba/PruebaWalmart/
```

## 4. Acceder a los endpoints
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

### Pruebas Unitarias - PersonController

Este proyecto incluye una serie de pruebas unitarias automatizadas para verificar el correcto funcionamiento de los endpoints del controlador `PersonController`, que forma parte del sistema de gestión de personas.

## Tecnología utilizada

- **Spring Boot**
- **Spring Test + MockMvc**
- **JUnit 5**
- **Jackson (ObjectMapper)** para manipular JSON

## Ubicación de las pruebas

Las pruebas se encuentran en el archivo:
```
src/test/java/co/com/walmart/stefanini/prueba/PruebaWalmart/controller/PersonControllerTest.java
```
## Qué cubren las pruebas

Las pruebas automatizadas cubren los siguientes casos de uso del API REST:

| Prueba | Descripción |
|--------|-------------|
| `testCreatePerson()` | Verifica que se pueda crear una persona correctamente mediante el endpoint POST `/api/personas`. |
| `testGetById()` | Asegura que una persona específica pueda ser recuperada por su ID usando GET `/api/personas/{id}`. |
| `testUpdatePerson()` | Verifica que se pueda actualizar una persona usando PUT `/api/personas/{id}`. |
| `testDeletePerson()` | Confirma que una persona puede eliminarse exitosamente mediante DELETE `/api/personas/{id}`. |
| `testGetAll()` | Valida que el endpoint GET `/api/personas` devuelva una lista de todas las personas existentes. |

## Flujo de ejecución de pruebas

Cada prueba:
1. Llama internamente a `createPerson()` para registrar una nueva persona usando el endpoint real.
2. Usa el ID generado para ejecutar las operaciones necesarias (`GET`, `PUT`, `DELETE`, etc.).
3. Verifica que la respuesta sea exitosa y que los valores retornados sean correctos (por ejemplo, nombre actualizado, lista no vacía, etc.).

> Nota: las pruebas son completamente integradas, interactúan con la base de datos MySQL configurada en el entorno, sin mocks.

## Cómo ejecutar las pruebas

Puedes ejecutar las pruebas con cualquiera de estas opciones:

### Desde línea de comandos

```bash
mvn test
```