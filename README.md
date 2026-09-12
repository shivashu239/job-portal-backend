# Job Portal Backend API

A backend REST API for a Job Portal application built using Java and Spring Boot.

The project provides job management, job applications, user authentication, JWT-based security, and role-based authorization.

## 🚀 Features

- Job CRUD operations
- Search jobs by title
- Search jobs by location
- Search jobs by title and location
- Job application management
- User registration and login
- JWT-based authentication
- Role-based authorization
- USER and ADMIN roles
- Input validation
- Global exception handling
- MySQL database integration
- Spring Data JPA / Hibernate
- Swagger API documentation
- Postman API testing

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Spring Security
- JWT
- MySQL
- Maven
- Swagger / OpenAPI
- Postman
- Git & GitHub

## 🏗️ Architecture

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
MySQL Database


## 🔐 Authentication & Authorization

The application uses JWT-based authentication.

### Roles

- **USER** – Can view jobs and manage job applications.
- **ADMIN** – Can create, update, and delete jobs.

### Authentication Flow

```text
Register
   ↓
Login
   ↓
JWT Token
   ↓
Authorization Header
   ↓
Protected API