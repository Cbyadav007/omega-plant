
# REST API for Online Plant Nursery Management

- I have developed this REST API for a Plant Nursery Management system Application. This API performs all the fundamental CRUD operations of any Plant Nursery Application platform with user validation at every step.
- This project is developed by me during project week in Masai School.

## Tech Stack

- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- **Spring-Security**
- **Spring Validation**
- **Razorpay Payment Gateway**
- Rest-API
- Javascript
- CSS
- HTML
- Lombook
- swagger-ui


## Modules
- Login, Logout Module
- Admin Module
- Plants Module
- Planters Module
- Seeds Module


## Features
- Admin can signup using token only.
- Real-time-payment using Razorpay-Payment Gateway.
- User and Admin authentication & validation with session uuid.
### Admin Features
- Administrator Role of the entire application
- Only admins can add/update/delete plants, planters, seeds from main database
- Admin can access the details of different users and orders.
### Customer Features
- Registering themselves with application, and logging in to get the valid session token
- Viewing list of available plants, planters, seeds and order items of them.
- Only logged in user can access his orders, profile updation and other features.


## Installation & Run
- Before running the API server, you should update the database config inside the application.properties file.

- Update the port number, username and password as per your local database config. server.port=8890

- spring.datasource.url=jdbc:mysql://localhost:3307/plantstorage spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver spring.datasource.username=root spring.datasource.password=1234
## API Reference

#### Generate token for Admin signup

```http
  POST  http://localhost:8890/token
```

| Parameter | Type     | Value                |
| :-------- | :------- | :------------------------- |
| `username` | `string` | "Cbyadav"|
| `password` | `string` | "Cbyadav"|




## API End-Point

 - API Root Endpoint [https://localhost:8890/](https://localhost:8890/)
 - Swagger-ui [http://localhost:8890/swagger-ui/](http://localhost:8886/swagger-ui/)
 


## ER DIAGRAM OF PLANT NURSERY MANAGEMENT APPLICATION
![Logo](https://user-images.githubusercontent.com/101380040/193456250-c8fea983-dd1c-4888-a967-94ebfad02748.jpeg)

