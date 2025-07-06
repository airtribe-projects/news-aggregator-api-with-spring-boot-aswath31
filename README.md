# News Aggregator API with Spring Boot + JWT

A secure Spring Boot application that allows users to register, log in with JWT authentication, set their news preferences, and fetch real-time news articles using the GNews API.

---

## Features

-  User Registration with email verification token
-  JWT-based Authentication & Authorization
-  User Preferences (topics like politics, sports, etc.)
-  Fetch Latest News based on preferences
-  Search News Articles by Keyword
-  Integration with [GNews API](https://gnews.io/)
-  Tested with Postman

---

##  Tech Stack

- Java 17
- Spring Boot 3
- Spring Security + JWT
- MySQL (or H2 optional)
- WebClient (Reactive HTTP)
- Maven

---

##  Project Structure
src/
└── main/
└── java/com/airtribe/projects/News/Aggregator/
├── controller/ # REST controllers
├── entity/ # JPA entities
├── repository/ # Spring Data repositories
├── service/ # Business logic
└── util/ # JWT utility

---

##  Setup Instructions

 1. Clone the Repository

git clone https://github.com/YOUR_USERNAME/news-aggregator-api.git
cd news-aggregator-api

2. Configure Environment
Edit src/main/resources/application.properties:

properties
Copy
Edit
# Server and DB
server.port=4001
spring.datasource.url=jdbc:mysql://localhost:3306/LearnerSystemDB
spring.datasource.username=root
spring.datasource.password=your_db_password

# GNews API Key
newsapi.key=your_gnews_api_key_here
Get your free GNews API key here: https://gnews.io/register

3. Run the Application
bash
Copy
Edit
./mvnw spring-boot:run
Server runs at: http://localhost:4001

Authentication Flow
POST /register – Register a new user

POST /verifyRegistration?token=... – Activate account

POST /signin – Get JWT token

Use JWT token in headers for authenticated requests:

makefile
Copy
Edit
Authorization: Bearer <your-token>

