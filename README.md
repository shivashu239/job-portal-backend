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
```

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
```

## 📌 API Endpoints

### Authentication

| Method | Endpoint | Description |
|---|---|---|
| POST | `/auth/register` | Register a new user |
| POST | `/auth/login` | Login and receive JWT token |

### Jobs

| Method | Endpoint | Access |
|---|---|---|
| GET | `/jobs` | USER / ADMIN |
| GET | `/jobs/{id}` | Authenticated users |
| POST | `/jobs` | ADMIN |
| PUT | `/jobs/{id}` | ADMIN |
| DELETE | `/jobs/{id}` | ADMIN |

### Job Search

| Method | Endpoint | Description |
|---|---|---|
| GET | `/jobs/search?title=Java` | Search by title |
| GET | `/jobs/search/location?location=Noida` | Search by location |
| GET | `/jobs/search/advanced?title=Java&location=Noida` | Search by title and location |

### Applications

| Method | Endpoint | Description |
|---|---|---|
| GET | `/applications` | Get all applications |
| GET | `/applications/{id}` | Get application by ID |
| POST | `/applications` | Submit application |
| PUT | `/applications/{id}` | Update application |
| DELETE | `/applications/{id}` | Delete application |
| GET | `/applications/job/{jobId}` | Get applications for a job |
| GET | `/applications/applicant?email=user@example.com` | Get applications by applicant |

## 🗄️ Database

The project uses MySQL with Spring Data JPA and Hibernate.

### Main Entities

- **User**
- **Job**
- **JobApplication**

The database schema is automatically managed by Hibernate using:

```properties
spring.jpa.hibernate.ddl-auto=update
```

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/shivashu239/job-portal-backend.git
```

### 2. Open the project

Open the project in VS Code, IntelliJ IDEA, or another Java IDE.

### 3. Configure MySQL

Create the database:

```sql
CREATE DATABASE job_portal;
```

Configure your database credentials using environment variables:

```text
DB_PASSWORD=your_mysql_password
JWT_SECRET=your_jwt_secret
```

### 4. Run the application

Using Maven Wrapper:

```powershell
.\mvnw.cmd spring-boot:run
```

The application runs on:

```text
http://localhost:8080
```

## 📚 Swagger API Documentation

Swagger UI is available at:

```text
http://localhost:8080/swagger-ui/index.html
```

Swagger can be used to view and test the available REST APIs.

## 🧪 API Testing

The APIs were tested using Postman.

Testing includes:

- User registration
- User login
- JWT authentication
- Role-based authorization
- Job CRUD operations
- Job search
- Job application management
- Validation errors
- Not-found error handling

## 📁 Project Structure

```text
src
└── main
    ├── java
    │   └── com.example.demo
    │       ├── DemoApplication.java
    │       ├── Job.java
    │       ├── JobRepository.java
    │       ├── JobService.java
    │       ├── JobController.java
    │       ├── JobApplication.java
    │       ├── JobApplicationRepository.java
    │       ├── JobApplicationService.java
    │       ├── JobApplicationController.java
    │       ├── User.java
    │       ├── UserRepository.java
    │       ├── UserService.java
    │       ├── AuthController.java
    │       ├── AuthService.java
    │       ├── CustomUserDetailsService.java
    │       ├── JwtService.java
    │       ├── JwtAuthenticationFilter.java
    │       ├── SecurityConfig.java
    │       └── GlobalExceptionHandler.java
    │
    └── resources
        └── application.properties
```

## 🛡️ Security

The application implements:

- Spring Security
- JWT authentication
- BCrypt password encryption
- Role-based authorization
- Protected REST APIs
- Stateless session management

Passwords are not stored in plain text.

## 🔮 Future Enhancements

- Job categories
- Company profiles
- Resume upload
- Advanced job filtering
- Pagination and sorting
- Email notifications
- Admin dashboard
- Deployment to cloud platforms

## 👨‍💻 Author

**Shivanshu Batwal**

B.Tech – Computer Science & Engineering  

### GitHub

https://github.com/shivashu239