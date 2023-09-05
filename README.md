# Expense Tracker Web Application
An intuitive web-based application for tracking and managing personal expenses, developed using the MVC architecture in Spring Boot. 

## Objective
The main goal of this project is to create a web-based expense tracker that enables users to easily manage and track their day-to-day expenses. The application provides a user-friendly interface for expense creation, updation, tracking, categorization, and detailed reporting.

## Features Implemented
- **User-specific Login**: Enables users to have their personal profile with their expenses. The profile is secured using login and register function.
- **Authentication**: Authentication is provided using spring security. The user is allowed to create a new account and track the expense. The password will be stored in the database in encrypted format. An option is provided to logout of his account in every page.
- **User-friendly Dashboard**: Enables users to get an overview of their expenses at a glance.
- **Expense Tracking**: Seamlessly add, edit, or remove expenses.
- **Categorization**: Classify your expenses into various categories for better finance management.
- **Detailed Reporting**: Generate detailed reports to understand and analyze your spending habits.

## Technologies Used
- **Backend**: Java, Maven, Spring Boot 1.5.1, Spring Data JPA, Spring Security
- **Frontend**: HTML, CSS, Thymeleaf, chart.js.
- **Database**: Currently the application is using Oracle database, all the credentails can be changed in application properties. No need to create database or tables, everything will be created for you, all you have to do is change the credentails.
- **Testing**: JUnit.
- **IDE**: Visual Studio Code.
- **Server**: tomcat 8.0 or higher versions.

## Installation & Setup
### Prerequisites:
- Java JDK
- Maven 
- MySQL Server
- Tomcat Server
- VS COde IDE
### Steps:
1. Clone the Repository
```
git clone [URL_TO_GIT_REPOSITORY]
```
2. Go to the project directory
```
cd ExpenseTracker
```
3. Create Database
```
CREATE DATABASE ExpenseTracker
```
4. Start the Application
- Open the project in VS Code.
- Right-click on the project > Run As > Spring Boot App.
- The server will start on default port 1001.
or use the below command directly
```
  mvn spring-boot:run
```
5. Access the Web App
Open your web browser and navigate to http://localhost:1001.

## Project Screenshots
