# Tromzo Spring Application

This is a sample Spring application called Tromzo. It utilizes Spring Boot along with various dependencies to provide a web-based GraphQL API.

## Prerequisites
- Java 17
- Maven

## Getting Started
To run the Tromzo application, follow these steps:

1. Clone the repository or download the source code.
2. Open a terminal or command prompt and navigate to the project's root directory.
3. Build the project using Maven:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```
5. The application will start running on the default port (usually 8080).
   You can access the GraphQL API by sending graphql requests to [http://localhost:8080/graphql](http://localhost:8080/graphql).

## Dependencies
The following dependencies are used in the Tromzo application:

- Spring Boot Starter: Provides core Spring Boot functionality.
- Spring Boot Starter Web: Enables web development with Spring MVC.
- Spring Boot Starter GraphQL: Integrates GraphQL support into the application.
- Lombok: Enhances Java classes with annotations to reduce boilerplate code.
- Spring Boot Starter Test: Provides testing support for Spring Boot applications.

## Build and Run
The application is built and run using Maven. The `spring-boot-maven-plugin` is used to package the application into an executable JAR file.

To build the application, run the following command:
```
mvn clean install
```

To run the application, execute the following command:
```
mvn spring-boot:run
```

Feel free to explore and modify the Tromzo application to meet your needs!
