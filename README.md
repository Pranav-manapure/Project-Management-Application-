## 📝 Overview
The **Project Management System** is a user-friendly web application designed to manage projects, tasks, and resources efficiently. Built with **Spring Boot**, **Hibernate**, and **Thymeleaf**, it offers full **CRUD functionality** and ensures resources are not over-allocated (max **2 tasks per project**).

---

## ✨ Features
- 🔧 **CRUD Operations**: Manage projects, tasks, and resources.
- 📊 **Resource Allocation Management**: Avoid over-allocation of resources.
- ✅ **Validation**: Ensure resources are assigned to a maximum of 2 tasks per project.
- 🎨 **Beautiful UI**: Designed with Thymeleaf and Bootstrap.
- 🗄️ **Database Persistence**: Powered by PostgreSQL.

---

## 💻 Tech Stack
| **Component**     | **Technology**       |
|--------------------|----------------------|
| **Backend**        | Spring Boot, Hibernate |
| **Frontend**       | Thymeleaf, Bootstrap  |
| **Database**       | PostgreSQL            |
| **Validation**     | Custom Validation Logic |

---
## Directory Structure

```plaintext
project-management-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── projectmanagement/
│   │   │               ├── controller/
│   │   │               │   ├── ProjectController.java
│   │   │               │   ├── TaskController.java
│   │   │               │   └── ResourceController.java
│   │   │               ├── model/
│   │   │               │   ├── Project.java
│   │   │               │   ├── Task.java
│   │   │               │   └── Resource.java
│   │   │               ├── repository/
│   │   │               │   ├── ProjectRepository.java
│   │   │               │   ├── TaskRepository.java
│   │   │               │   └── ResourceRepository.java
│   │   │               ├── service/
│   │   │               │   ├── ProjectService.java
│   │   │               │   ├── TaskService.java
│   │   │               │   └── ResourceService.java
│   │   │               ├── validation/
│   │   │               │   └── TaskAssignmentValidator.java
│   │   │               └── ProjectManagementSystemApplication.java
│   │   ├── resources/
│   │   │   ├── static/
│   │   │   │   ├── css/
│   │   │   │   │   └── bootstrap.min.css
│   │   │   ├── templates/
│   │   │   │   ├── projects/
│   │   │   │   │   ├── list.html
│   │   │   │   │   ├── create.html
│   │   │   │   │   └── update.html
│   │   │   │   ├── tasks/
│   │   │   │   │   ├── list.html
│   │   │   │   │   ├── create.html
│   │   │   │   │   └── update.html
│   │   │   │   └── resources/
│   │   │   │       ├── list.html
│   │   │   │       ├── create.html
│   │   │   │       └── update.html
│   │   │   └── application.properties
│   ├── test/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── projectmanagement/
│       │               └── ProjectManagementSystemApplicationTests.java
├── pom.xml
```

---

## 🚀 Installation and Setup

### ✅ Prerequisites
- Java 17+
- Maven
- PostgreSQL
- Git

### 🛠️ Steps
1. **Clone the Repository**:
   ```bash
   git clone <repository_url>
   cd project-management-system


2. Configure the PostgreSQL database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/project_management_system
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   ```

3. Build and run the project:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. Access the application at `http://localhost:8080`.

---

## 🌐 Endpoints
### 📁 Projects
- **GET** `/projects`: List all projects.
- **GET** `/projects/create`: View the project creation form.
- **POST** `/projects`: Create a new project.
- **GET** `/projects/edit/{id}`: View the edit form for a project.
- **POST** `/projects/update`: Update an existing project.
- **GET** `/projects/delete/{id}`: Delete a project.

### 📋 Tasks
- **GET** `/tasks`: List all tasks.
- **GET** `/tasks/create`: View the task creation form.
- **POST** `/tasks`: Create a new task (with validation for resource allocation).
- **GET** `/tasks/edit/{id}`: View the edit form for a task.
- **POST** `/tasks/update`: Update an existing task.
- **GET** `/tasks/delete/{id}`: Delete a task.

### 👤 Resources
- **GET** `/resources`: List all resources.
- **GET** `/resources/create`: View the resource creation form.
- **POST** `/resources`: Create a new resource.
- **GET** `/resources/edit/{id}`: View the edit form for a resource.
- **POST** `/resources/update`: Update an existing resource.
- **GET** `/resources/delete/{id}`: Delete a resource.

---

## 📸 Screenshots
### 🖥️ Database Tables Schema

   ![image](https://github.com/user-attachments/assets/a2e23b09-37b4-4abc-be09-4c3d42549f8c)

### 📂 Project List
- Project List
   ![image](https://github.com/user-attachments/assets/a18b1b99-4265-4912-bb8e-f98749824977)

- Project Create
   ![image](https://github.com/user-attachments/assets/4208d994-6310-492e-9a9a-4adc31f72944)

### 👥 Resource List
- Resource List
   ![image](https://github.com/user-attachments/assets/4826782a-3525-41a0-90c1-1fc68c3d426c)

- Resource Create
   ![image](https://github.com/user-attachments/assets/37b4dda0-4719-4c24-8942-e7edf0eda5cf)

### 📝 Task Creation Form
- Task List
   ![image](https://github.com/user-attachments/assets/56b20ae4-f089-4932-8b9d-701ebb309f28)
  
- Task Create
   ![image](https://github.com/user-attachments/assets/5ad4e28e-80c3-47cc-b2ba-2af0ffc54f55)

---

## 🔒 Constraints
- Each resource can be allocated to a maximum of **2 tasks per project**.
- Only resources with a status of **Available** can be assigned to new tasks.

---

## 🔍 Validation Logic
- Implemented in `TaskAssignmentValidator.java`.
- Validates the number of tasks assigned to a resource within the same project.
- Displays an error message on the task creation page if the limit is exceeded.

---

### 👨‍💻 Author
   Pranav Sanjay Manapure
   - **✉️ Email:** manapurepranav03@gmail.com
   - **🌐 LinkedIn:** www.linkedin.com/in/pranav-manapure

---


