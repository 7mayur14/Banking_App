Banking App
This is a Spring Boot application for a banking system. It provides functionalities to manage accounts, including creating, updating, and retrieving account details.

#Table of Contents
Getting Started
Prerequisites
Installation
Running the Application
API Endpoints
Technologies Used
Contributing
License
Getting Started
Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites
Java 11 or higher
Maven 3.6.0 or higher
Spring Boot 2.5.0 or higher
PostgreSQL (or any other preferred database)
Installation

##Clone the repository:

sh
git clone https://github.com/your-username/banking_app.git
Navigate to the project directory:

sh
cd banking_app
Install the dependencies:

sh
mvn clean install
Running the Application

##Configure the database settings in application.properties file:
properties

spring.datasource.url=jdbc:postgresql://localhost:5432/bankingdb
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword
spring.jpa.hibernate.ddl-auto=update

Run the application:

sh
mvn spring-boot:run
The application will start on http://localhost:8080.

API Endpoints
Account Endpoints

##Add Account

URL: /api/accounts
Method: POST
Request Body:

json
{
  "accountHolderName": "John Doe",
  "balance": 1000.0
}

Response:

json
{
  "id": 1,
  "accountHolderName": "John Doe",
  "balance": 1000.0
}

##Get Account by ID

URL: /api/accounts/{id}
Method: GET
Response:

json
{
  "id": 1,
  "accountHolderName": "John Doe",
  "balance": 1000.0
}

##Deposit

URL: /api/accounts/{id}/deposit
Method: PUT
Request Body:
json
Copy code
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

URL: /api/accounts/{id}/withdraw
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

Get All Accounts

URL: /api/accounts
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

Delete Account

URL: /api/accounts/{id}
Method: DELETE

Response:

json
{
  "message": "Account deleted successfully!"
}
