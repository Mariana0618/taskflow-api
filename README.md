# Taskflow API — README (English)

## Overview

Taskflow is a simple RESTful API for managing tasks, built with **Java 17 + Spring Boot**. This repository contains a minimal CRUD implementation (in-memory) and interactive API documentation via **OpenAPI / Swagger UI**.

---

## Technologies

* Java 17
* Spring Boot
* Maven
* springdoc-openapi (Swagger UI)

---

## Quick Start

### 1) Add OpenAPI dependency to `pom.xml`

Add the following dependency inside `<dependencies>`:

```xml
<!-- OpenAPI / Swagger UI -->
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.5.0</version>
</dependency>
```

Then run:

```bash
mvn clean install
```

### 2) Create OpenAPI configuration class

Create file: `src/main/java/com/taskflow/config/OpenApiConfig.java`

```java
package com.taskflow.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Taskflow API")
                        .version("1.0.0")
                        .description("A simple Taskflow API (CRUD) built with Spring Boot. Includes OpenAPI/Swagger documentation.")
                );
    }
}
```

### 3) Run the application

```bash
mvn spring-boot:run
```

Open Swagger UI in your browser:

```
http://localhost:8080/swagger-ui.html
```

You should see automatically generated documentation for your controllers and endpoints (e.g. `/health`, `/tasks`).

---

## API Endpoints (examples)

### Health

```
GET /health
```

Example curl:

```bash
curl -s http://localhost:8080/health
```

### List tasks

```
GET /tasks
```

Example curl:

```bash
curl -s http://localhost:8080/tasks
```

### Create task

```
POST /tasks
Content-Type: application/json
```

Body example:

```json
{
  "title": "Check email",
  "completed": false
}
```

Curl example:

```bash
curl -s -X POST -H "Content-Type: application/json" -d '{"title":"Check email","completed":false}' http://localhost:8080/tasks
```

### Update task

```
PUT /tasks/{id}
Content-Type: application/json
```

Body example:

```json
{
  "title": "Check email and replies",
  "completed": true
}
```

Curl example:

```bash
curl -s -X PUT -H "Content-Type: application/json" -d '{"title":"Check email and replies","completed":true}' http://localhost:8080/tasks/1
```

### Delete task

```
DELETE /tasks/{id}
```

Curl example:

```bash
curl -s -X DELETE http://localhost:8080/tasks/1
```

---

## Project structure (recommended)

```
src/main/java/com/taskflow/
 ┣ TaskflowApiApplication.java   # Spring Boot main class
 ┣ Task.java                     # POJO model
 ┣ TasksController.java          # REST controller
 ┗ config/
   ┗ OpenApiConfig.java          # OpenAPI (Swagger) configuration
```

---

## Commit & Push example

After adding the dependency and `OpenApiConfig.java`:

```bash
git add pom.xml src/main/java/com/taskflow/config/OpenApiConfig.java
git commit -m "Add OpenAPI (Swagger) documentation and configuration"
git push origin dev
```

---

## Notes & Troubleshooting

* If `swagger-ui.html` does not load, try: `http://localhost:8080/swagger-ui/index.html`.
* Make sure your controllers are in a package scanned by Spring (e.g. `com.taskflow`).
* If using a different Spring configuration (WebFlux, etc.), use the matching `springdoc` starter artifact.

---

## Author

Mariana Cervantes — Taskflow API

---


Use the "README.md" section above (this document) as your repository README. Replace/add any project-specific details you prefer (your name, links, extra endpoints, database notes).
