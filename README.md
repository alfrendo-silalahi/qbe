# QBE (Query by Example) Project

This is a demo project for Spring Boot that demonstrates the use of Query by Example (QBE) with Spring Data JPA.

## Technologies Used

- Java 21
- Spring Boot 3.4.2
- Spring Data JPA
- PostgreSQL
- Maven

## Getting Started

### Prerequisites

- Java 21
- Maven
- PostgreSQL

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/alfrendo-silalahi/qbe.git
    cd qbe
    ```

2. Configure the PostgreSQL database:
    - Create a database named `qbe`.
    - Set the environment variables `POSTGRES_USERNAME` and `POSTGRES_PASSWORD` with your PostgreSQL credentials.

3. Update the `application.properties` file if necessary:
    ```ini
    spring.datasource.url=jdbc:postgresql://localhost:5432/qbe
    spring.datasource.username=${POSTGRES_USERNAME}
    spring.datasource.password=${POSTGRES_PASSWORD}
    ```

4. Build the project:
    ```sh
    mvn clean install
    ```

5. Run the application:
    ```sh
    mvn spring-boot:run
    ```

## API Endpoints

### Find All Employees by Example

- **URL:** `/api/employees`
- **Method:** `POST`
- **Request Body:** JSON representation of the `Employee` object
- **Response:** List of employees matching the example

### Find All Employees by First Name and Department

- **URL:** `/api/employees`
- **Method:** `GET`
- **Query Parameters:**
    - `firstName` (String)
    - `department` (String)
- **Response:** List of employees matching the first name and department

## License

This project is licensed under the MIT License.