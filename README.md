# Taskflow API

A simple task management REST API built with **Spring Boot**.

## 🚀 Getting Started

### Prerequisites

* Java 17+
* Maven 3+

### Run locally

```bash
mvn spring-boot:run
```

Then open: [http://localhost:8080](http://localhost:8080)

---

## 📚 API Endpoints

### Get all tasks

```http
GET /tasks
```

### Create a new task

```http
POST /tasks
Content-Type: application/json

{
  "title": "My first task",
  "description": "Details about the task"
}
```

### Update a task

```http
PUT /tasks/{id}
Content-Type: application/json

{
  "title": "Updated task",
  "description": "Updated description"
}
```

### Delete a task

```http
DELETE /tasks/{id}
```

---

## 📖 API Documentation (Swagger)

When running locally, Swagger UI is available at:

```
http://localhost:8080/swagger-ui.html
```

---

## 🛠️ Technologies

* Spring Boot
* Spring Web
* Spring Data JPA
* H2 Database (for development)
* Swagger / OpenAPI

## Author

Mariana Cervantes — Taskflow API

---


Use the "README.md" section above (this document) as your repository README. Replace/add any project-specific details you prefer (your name, links, extra endpoints, database notes).
