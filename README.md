REST API for Online Plant Nursery Management
We have developed this REST API for a Online Plant Nursery Management system Application. This API performs all the fundamental CRUD operations of any Plant Nursery Application platform with user validation at every step.
This project is developed by me during project week in Masai School.

Tech Stack:
Java
Spring Framework
Spring Boot
Spring Data JPA
Hibernate
MySQL
Spring-Security
Spring Validation
Razorpay Payment Gateway
Rest-API
Javascript
CSS
HTML
Lombook
swagger-ui

Modules
Login, Logout Module
Admin Module
Plants Module
Planters Module
Seeds Module

Features
Admin ca signup using token only.
Real-time-payment using Razorpay-Payment Gateway.
User and Admin authentication & validation with session uuid.

Admin Features:
Administrator Role of the entire application
Only admins can add/update/delete plants, planters, seeds from main database
Admin can access the details of different users and orders.

User Features:
Registering themselves with application, and logging in to get the valid session token
Viewing list of available plants, planters, seeds and order items of them.
Only logged in user can access his orders, profile updation and other features.

Installation & Run
Before running the API server, you should update the database config inside the application.properties file.

Update the port number, username and password as per your local database config. server.port=8890

spring.datasource.url=jdbc:mysql://localhost:3307/plantstorage spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver spring.datasource.username=root spring.datasource.password=1234

API Root Endpoint https://localhost:8890/

Generate Token for Admin signup
Rest-API:  http://localhost:8890/token
POST -  "username": "Cbyadav",
        "password": "Cbyadav"

http://localhost:8890/swagger-ui/
