# Quiz Application Project

This is a fully functional and optimized Quiz Application project. This README file provides a comprehensive guide for setting up, running, and testing the project, including instructions for Postman API testing.

## Features
- Start a quiz session for a user.
- Submit answers to questions.
- View progress of the quiz session.
- Complete a quiz session and calculate the score.

---

## 1. Prerequisites

Before running the project, ensure you have the following installed on your system:

### Backend Requirements
- Java Development Kit (JDK) 17+
- Maven 3.6+
- Spring Boot 3.1+
- H2 Database

### Tools
- IDE (e.g., IntelliJ IDEA, Eclipse, or Visual Studio Code)
- Postman for API testing
- Git (optional, for cloning the project)

---

## 2. Project Setup

### Clone the Project
If you have Git installed, clone the repository:
bash
git clone https://github.com/yashaylani7/Quiz_App.git

Otherwise, download the ZIP file and extract it.

### Navigate to the Project Directory
bash
cd quiz-app


### Set Up Database
The project uses H2 (in-memory database), and the schema is auto-created. No manual setup is required for the database.

You can view the database console after starting the application:
- URL: http://localhost:8080/h2-console
- Default Credentials:
  - JDBC URL: jdbc:h2:mem:quizdb
  - Username: sa
  - Password: (leave blank)

---

## 3. Build and Run the Application

### Build the Project
Use Maven to build the project:
bash
mvn clean install


### Run the Application
Start the Spring Boot application:
bash
mvn spring-boot:run


The application will start on http://localhost:8080.

---

## 4. Project Structure
- *src/main/java/com/quizapp*: Contains the source code.
  - controller: REST API controllers.
  - service: Business logic.
  - repository: Database interaction.
  - model: Entity classes and data models.
- *src/main/resources*: Configuration and static resources.
  - application.properties: Contains H2 database configuration.

---

## 5. Database Schema

### Tables:
- *quiz_session*: Stores quiz session details.
- *question*: Stores questions and options.

### Sample Data:
The question table is prepopulated with the following data:

| ID | Question                              | Option A | Option B | Option C | Option D | Correct Answer |
|----|---------------------------------------|----------|----------|----------|----------|----------------|
| 1  | What is the capital of France?       | Paris    | London   | Berlin   | Madrid   | A              |
| 2  | What is 2 + 2?                       | 3        | 4        | 5        | 6        | B              |
| 3  | Which language is used for Android?  | Python   | Kotlin   | C++      | Ruby     | B              |

---

## 6. Testing with Postman

### 1. Start a New Quiz Session
- Method: POST
- URL: http://localhost:8080/quiz/start
- Headers:
  - Content-Type: application/json
- Body:
  json
  {
      "userName": "JohnDoe"
  }
  
- Response:
  json
  {
      "id": 1,
      "userName": "JohnDoe",
      "correctAnswers": 0,
      "incorrectAnswers": 0,
      "totalQuestions": 3,
      "questions": [
          {
              "id": 1,
              "questionText": "What is the capital of France?",
              "optionA": "Paris",
              "optionB": "London",
              "optionC": "Berlin",
              "optionD": "Madrid",
              "correctAnswer": "A"
          },
          ...
      ]
  }
  

### 2. Submit Answers for Questions
- Method: POST
- URL: http://localhost:8080/quiz/submit
- Headers:
  - Content-Type: application/json
- Body:
  json
  {
      "sessionId": 1,
      "questionId": 1,
      "answer": "A"
  }
  
- Response:
  json
  {
      "id": 1,
      "userName": "JohnDoe",
      "correctAnswers": 1,
      "incorrectAnswers": 0,
      "totalQuestions": 3
  }
  

### 3. Check Quiz Session Progress
- Method: GET
- URL: http://localhost:8080/quiz/session/{sessionId}
- Response:
  json
  {
      "id": 1,
      "userName": "JohnDoe",
      "correctAnswers": 1,
      "incorrectAnswers": 0,
      "totalQuestions": 3
  }
  

### 4. Complete the Quiz Session
- Method: POST
- URL: http://localhost:8080/quiz/complete
- Headers:
  - Content-Type: application/json
- Body:
  json
  {
      "sessionId": 1
  }
  
- Response:
  
  Quiz Completed! You answered 2 out of 3 questions correctly.
  

---

## 7. Application Configuration

### H2 Database Console:
- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:quizdb
- Username: sa
- Password: (leave blank)

### Change Server Port:
If you want to run the application on a different port, modify the application.properties file:
properties
server.port=8081


---

## 8. Known Issues and Fixes

### Issue: Table Columns Not Found
If the question or quiz_session table is empty, ensure the SQL scripts in data.sql are loaded correctly.

### Fix:
- Verify data.sql is in the src/main/resources directory.
- Ensure the spring.datasource.initialize=true property is set in application.properties.

---

## 9. Future Enhancements
- Add authentication for users.
- Implement pagination for questions.
- Enhance the front-end UI.

---

## 10. License
This project is licensed under the MIT License.

---

Congratulations! You have successfully set up, run, and tested the Quiz Application project. Let me know if you need further assistance!
