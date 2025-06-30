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

### Pruebas Unitarias y Base de Datos

Este proyecto incluye pruebas unitarias para validar el comportamiento de los endpoints del controlador (`PersonController`), utilizando el enfoque de pruebas con `@WebMvcTest` y `MockMvc`.

---

## Comando a escribir
```
mvn -Dtest=PersonControllerTest test
```

---

## ¿Qué se prueba?

Las pruebas cubren:

- **GET /api/personas** → Lista completa de personas
- **GET /api/personas/{id}** → Consulta individual
- **POST /api/personas** → Creación con retorno del ID
- **PUT /api/personas/{id}** → Actualización con nuevos valores
- **DELETE /api/personas/{id}** → Eliminación exitosa

Cada prueba asegura que:

- La respuesta tenga la estructura esperada (`status`, `msg`, `data`)
- Todos los campos de la entidad `Person` estén correctamente representados en el JSON

---

## Uso de base de datos embebida (H2)

Aunque el proyecto principal utiliza MySQL, para las pruebas unitarias no es necesario conectarse a la base de datos real y por ello se da el uso de una base de datos embebida H2 en memoria para las pruebas automatizadas. Esto permite:

- Ejecutar pruebas sin depender de un servidor de base de datos activo
- Mayor velocidad y portabilidad
- Evitar modificaciones no deseadas en datos reales

Para lograrlo, basta con crear un archivo `application-test.properties` con la siguiente configuración:

```properties
# src/test/resources/application-test.properties

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true
```