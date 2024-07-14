###Banking App
This is a Spring Boot application for a banking system. It provides functionalities to manage accounts, including creating, updating, and retrieving account details.

##Table of Contents

Getting Started
Prerequisites
Installation
Running the Application
API Endpoints
Technologies Used
Contributing


##Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

##Prerequisites
Java 11 or higher
Maven 3.6.0 or higher
Spring Boot 2.5.0 or higher
MySQL

##Installation

Clone the repository:

    ```bash
    git clone https://github.com/your-username/banking_app.git

 Navigate to the project directory:

    ```bash
    cd banking_app
    Install the dependencies:

    ```bash
    mvn clean install
    Running the Application

Configure the database settings in application.properties file:
properties

    ```bash
    spring.datasource.url=jdbc:postgresql://localhost:5432/bankingdb
    spring.datasource.username=yourUsername
    spring.datasource.password=yourPassword
    spring.jpa.hibernate.ddl-auto=update

##Run the application:

    ```bash
    mvn spring-boot:run
    The application will start on http://localhost:8080.

##API Endpoints

Account Endpoints

##Add Account

    ```bash
    URL: http://localhost:8080/api/accounts
Method: POST
Request Body:

    ```bash
    json
    {
      "accountHolderName": "John Doe",
      "balance": 1000.0
    }

Response:

    ```bash
    json
    {  
      "id": 1,
      "accountHolderName": "John Doe",
      "balance": 1000.0
    }


##Deposit

    ```bash
    URL: http://localhost:8080/api/accounts
Method: PUT
Request Body:

    json
    {
      "amount": 500.0
    }
Response:

    json
    {
      "id": 1,
      "accountHolderName": "John Doe",
      "balance": 1500.0
    }

##Withdraw

    ```bash
    URL: http://localhost:8080/api/accounts/1/withdraw
Method: PUT
Request Body:

    json
    {
      "amount": 200.0
    }

Response:

    json
    {
      "id": 1,
      "accountHolderName": "John Doe",
      "balance": 800.0
    }

##Get All Accounts

    ```bash
    URL: http://localhost:8080/api/accounts
Method: GET

Response:

    json
    [
      {
        "id": 1,
        "accountHolderName": "John Doe",
        "balance": 1000.0
      },
      {
        "id": 2,
        "accountHolderName": "Jane Smith",
        "balance": 2000.0
      }
    ]

##Delete Account

    ```bash
    URL: http://localhost:8080/api/accounts/1
Method: DELETE

Response:

    json
    {
      "message": "Account deleted successfully!"
    }


##Technologies Used
Java
Spring Boot
Spring Data JPA
PostgreSQL
Maven

##Contributing
Contributions are welcome! Please feel free to submit a Pull Request.
