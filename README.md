# API Spring Boot

![Project cover](apiConSpringBoot/img/portada.png)

## Description

This repository contains an **educational project** developed with **Java** and **Spring Boot**, focused on building a modern, functional, and well-structured **REST API** following backend development best practices.

The main goal of this project is to **demonstrate solid backend knowledge**, especially in:

- **Java**
- **Spring Boot**
- **REST API design**
- **Persistence with MySQL**
- **Using DTOs for data transfer**
- **Good coding practices**
- **Using Lombok to simplify classes**
- **Dockerizing the application**

This project represents a complete REST API implementation, showing the ability to develop backend solutions ready to run in local or containerized environments, as is the case here.

## Technologies used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Docker
- Maven
- Lombok

## Project features

- REST API developed with Spring Boot
- Layered architecture
- Separation of responsibilities between controllers, services, repositories, and DTOs
- Data persistence with MySQL
- Data transfer through **DTOs**
- Use of Lombok to reduce repetitive code and improve readability
- Structured code following development best practices
- Dockerized application to simplify deployment

## What does this project demonstrate?

This project demonstrates knowledge in:

### Backend
Ability to design and develop a robust, scalable, and well-structured API.

### Java
Command of the language to implement clear, reusable, and maintainable business logic.

### Spring Boot
Use of the Spring ecosystem to build backend services efficiently.

### MySQL database
Integration with a relational database for storing and managing information.

### DTOs
Use of data transfer objects to avoid exposing entities directly and improve code organization.

### Lombok
Use of annotations to simplify class construction, reducing repetitive code and improving maintainability.

### Best practices
Application of code cleanliness, layer separation, and maintainability principles.

### Docker
Containerization of the project, which makes it easier to run and deploy in different environments.

## General structure

The application is usually organized into layers such as:

- `controller`: exposes the API endpoints
- `service`: contains the business logic
- `repository`: handles data access
- `entity`: represents persisted models
- `dto`: handles data transfer
- `config`: contains additional configurations

Among others present in the project.

## Academic value

This project is evidence of learning and practice in backend development with Java and Spring Boot. In addition, being dockerized, it shows a more complete and realistic view of the lifecycle of an application, from build to deployment.

## Environment setup

![Secondary image](apiConSpringBoot/img/img-segundaria.png)

> **⚠️ Recommendation:**
>
> Before running the application, make sure to create the `.env` file in the project directory with the required environment variables. This will allow Docker to correctly map the variables and credentials for the database connection.

### Example MySQL configuration in `application.properties`

```properties
spring.application.name=apiSpringBoot

spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

## Project containerization

> **⚠️ Recommendation:**
>
> Review and adjust, if necessary, the `Dockerfile` and `docker-compose.yml` files.

To run and containerize this project, the **Dockerfile** and **docker-compose.yml** files present in the repository are used.

- **Dockerfile**: builds the application image.
- **docker-compose.yml**: makes it easier to orchestrate the containers needed to start the API, such as the database and its dependencies.

### Running with Docker

1. Build the project images:
```bash

docker compose build
```

2. Start the containers
```bash

docker compose up -d
```

3. Verify that the services are running correctly.

4. The API will be available according to the configuration defined in `docker-compose.yml`.

## Acknowledgements

I would like to thank **TodoCode Academy** for its valuable educational content, which contributed to my learning and the development of this educational project.

## Author

Developed by SAMU0305