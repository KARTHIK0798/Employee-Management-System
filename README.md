# Employee Management System

A Spring Boot REST API application for managing employee records.

## Project Overview

The Employee Management System is a backend REST API developed using Java and Spring Boot.

The application allows users to create, view, update, and delete employee records. It also includes DTOs, input validation, global exception handling, custom JPA queries, pagination, sorting, and Swagger/OpenAPI documentation.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API
- Swagger / OpenAPI
- Postman

## Project Architecture

The application follows a layered architecture:

Client / Postman / Swagger
          ↓
      Controller
          ↓
        Service
          ↓
      Repository
          ↓
    JPA / Hibernate
          ↓
        MySQL


### Layers

- **Controller** – Handles HTTP requests and responses.

- **Service** – Contains business logic.

- **Repository** – Communicates with the database using Spring Data JPA.

- **Entity** – Represents the database table.

- **DTO** – Controls the data transferred between the client and application.

- **Exception Handler** – Handles application exceptions globally.

## Project Structure

src
├── main
│   ├── java
│   │   └── com.example.employeemanagement
│   │       ├── EmployeeManagementApplication.java
│   │       │
│   │       ├── controller
│   │       │   └── EmployeeController.java
│   │       │
│   │       ├── dto
│   │       │   └── EmployeeDTO.java
│   │       │
│   │       ├── service
│   │       │   └── EmployeeService.java
│   │       │
│   │       ├── repository
│   │       │   └── EmployeeRepository.java
│   │       │
│   │       ├── entity
│   │       │   └── Employee.java
│   │       │
│   │       └── exception
│   │           └── GlobalExceptionHandler.java
│   │
│   └── resources
│       └── application.properties
│
└── test


## Features

- Create employee
- Get all employees
- Get employee by ID
- Update employee
- Delete employee
- DTO-based request and response
- Input validation using `@Valid`
- Global exception handling
- Custom JPA queries
- Employee search and filtering
- Pagination
- Sorting
- Swagger/OpenAPI documentation
- REST API testing using Postman

## Database

The application uses MySQL.

Database name:-

-->> employee_db


The application connects to MySQL using Spring Data JPA and Hibernate.

## Database Configuration

Database credentials should not be hard-coded or committed to GitHub.

Use environment variables:

### Windows PowerShell

```powershell

$env:DB_URL = "jdbc:mysql://localhost:3306/employee_db"
$env:DB_USERNAME = "your-database-user_name"
$env:DB_PASSWORD = "your-database-password"

```

Then start the application:

```powershell

.\mvnw.cmd spring-boot:run

```

**Do not commit actual database passwords to GitHub.**

## Running the Application

### Windows

From the project root:

```powershell
.\mvnw.cmd spring-boot:run

```

### Linux / macOS

```bash
./mvnw spring-boot:run

```

The application runs on:

```text
http://localhost:8080

```

## Maven Commands

### Run the application

```powershell
.\mvnw.cmd spring-boot:run

```

### Clean the project

```powershell
.\mvnw.cmd clean

```

### Build the project

```powershell
.\mvnw.cmd clean package

```

### Run tests

```powershell
.\mvnw.cmd test

```

### Build without running tests

```powershell
.\mvnw.cmd clean package -DskipTests

```

## REST API Endpoints

### Create Employee

```text
POST /employees
```

Example request:

json:-

{
  "name": "Karthik",
  "email": "karthik@gmail.com",
  "salary": 60000,
  "department": "IT"
}


### Get All Employees

```text
GET /employees
```

### Get Employee By ID

```text
GET /employees/id/{id}
```

Example:

```text
GET /employees/id/3
```

### Update Employee

```text
PUT /employees/{id}
```

### Delete Employee

```text
DELETE /employees/{id}
```

## Pagination and Sorting

The application supports pagination and sorting on the `/employees` endpoint.

Example:

```text
GET /employees?page=0&size=2&sortBy=salary&direction=desc
```

The `page` value is zero-based.

The `sortBy` parameter is the employee field to sort by, and `direction` can be:

```text
asc
desc
```

The salary filter accepts a minimum salary:

```text
GET /employees/salary?salary=50000
```

## Custom JPA Queries

Custom JPA queries are used to search and filter employee records based on specific requirements.

Examples include:

- Search employees by name
- Find employees by department
- Find employees based on salary
- Filter employee records using custom query methods

## Validation

The application uses Jakarta Bean Validation with `@Valid` to validate incoming request data.

Validation helps prevent invalid employee information from being stored in the database.

Example:

java:-

@PostMapping
public EmployeeDTO addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
    return employeeService.addEmployee(employeeDTO);
}


## Global Exception Handling

The application uses global exception handling to provide proper error responses.

For example, when an employee does not exist:

{
Employee not found
}

Global exception handling prevents raw Java/database exceptions from being directly exposed to the client.

## DTO

`EmployeeDTO` is used to transfer employee data between the client and application.

Using DTOs helps separate API data from the database entity and provides better control over the data exposed through the REST API.

## Swagger / OpenAPI

Swagger is used for API documentation and testing.

Swagger UI:-

http://localhost:8080/swagger-ui/index.html


OpenAPI JSON:-

http://localhost:8080/v3/api-docs


After starting the application, open Swagger UI in the browser to view and test the available APIs.

## Postman Testing

The REST APIs were tested using Postman.

The following operations were tested:

POST   → Create Employee
GET    → Get Employees
GET    → Get Employee By ID
PUT    → Update Employee
DELETE → Delete Employee

## Complete Application Flow

Client
  │
  ├── Postman
  └── Swagger
        │
        ↓
   EmployeeController
        │
        ↓
    EmployeeService
        │
        ↓
  EmployeeRepository
        │
        ↓
   Spring Data JPA
        │
        ↓
      Hibernate
        │
        ↓
       MySQL

## Error Handling Flow

Client Request
      ↓
   Controller
      ↓
    Service
      ↓
   Exception
      ↓
GlobalExceptionHandler
      ↓
 Proper Error Response

## Project Learning Outcomes

Through this project, I gained practical experience in:

- Java backend development
- Spring Boot
- REST API development
- Spring Data JPA
- Hibernate
- MySQL database integration
- Layered architecture
- DTO implementation
- Input validation
- Exception handling
- Custom JPA queries
- Pagination and sorting
- API testing
- Swagger/OpenAPI
- Maven project management

## Project Status

Project Status: Completed

The core Employee Management REST API has been implemented and tested.

## Future Enhancements

Possible future improvements include:

- JWT authentication
- Role-based authorization
- Frontend integration
- Cloud deployment
- Docker containerization
- Automated testing
- CI/CD integration

## Security Note

Never commit the following to GitHub:

Database passwords
API keys
Access tokens
Secret keys

Use environment variables or other secure configuration methods instead.

## Author

**Karthik**

Java | Spring Boot | REST API | MySQL