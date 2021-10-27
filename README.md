# Gregg-Travis-Project-1
This a Flight Kiosk web application built by Gregg Friedman and Travis Hood for Project 1 assignment.
# Project 1

## Description

This project utilizes previous concepts from project 0, as well as adding the following topics:
 - HTML
 - CSS & Bootstrap
 - JavaScript
 - Hibernate
 - DevOps
 - AWS (Elastic  Beanstalk and S3 Buckets)
This follows the client/server architecture for the entire application, and is a full stack project incorporating frontend and backend technologies. 
The backend server exposes an API, and the front end client connects to the same API for sending & receiving JSON data.
The backend is written in Java 8, and the frontend is written in HTML, CSS/Bootstrap, and JavaScript. 

This project was done with a 2 member team - Gregg Friedman and Travis Hood. Though we were assigned when we began, we have become great teammates and learned to cooporate and communicate effectively what our goals and challenges were throughout the course of building the project. We learned through hands-on training that we were capable of generating just about anything that we could imagine. In utilizing the aforementioned technologies, we have vastly contributed every requirement and been able to deploy our application easily and scalably, while abstracting away from an end-user underlying technologies and services.

### Requirements
1. Proper use of OOP principles
2. Output is presented to user on a web page, and input is accepted from a web form
3. Webapp(backend) and UI(frontend) are served from AWS and are publically available
4. CRUD operations are supported for one or more domain objects via the web application's API endpoints and invoked from the frontend
5. Communication is done with JSON in HTTP request and response bodies.
6. Abstract all JDBC away with Hibernate
7. Documentation (all classes and methods have adequate Javadoc comments)
8. All Exceptions are caught and logged to a file
9. 80%+ Unit test coverage for service-layer classes/methods

 Bonus Features
1. DevOps CI/CD pipeline (AWS) to build and deploy project
2. Bootstrap v5


## Airline Ticketing Kiosk App
These are user stories to describe the airline ticketing kiosk app. If you are not building this app for your project you will need to discuss with your trainer to establish proper user stories.

### Minimum Viable Product
- [x] As a user, I can see all available flights from a city to a city.		
- [x] As a user, I can purchase one or more tickets on a flight.		
- [x] As a user, I can check in for my flight.				
- [x] As a user, I can cancel my ticket. 				
- [x] As an administrator, I can schedule a new flight.			
- [x] As an administrator, I can cancel a flight.			
- [x] As an administrator, I can see all users with tickets for a flight.

### Bonus Stories
- [x] As an administrator, I can cancel a ticket on any flight.
- [ ] As an pilot, I can initiate takeoff of a flight. (No more new tickets or cancellations)

## Tech Stack
The application should be properly employing the following technologies:
 - [x] Java 8
 - [x] JavaScript
 - [x] HTML & CSS
 - [x] Apache Maven for dependencies and project management
 - [x] Git & Github for version control
 - [x] MariaDB deployed on AWS RDS for data persistence
 - [x] Hibernate to abstract away JDBC code
 - [x] AWS EC2, ElasticBeanstalk, S3, CodeBuild, CodePipeline

## Deadline & Presentation
 - Finalized version of the project must be pushed to your team's p1 repository within the training originzation by 9:00 AM Central time on the date of the presentation showcase. Commits after that time will not be considered. The most recent commit submitted before that time will be the version of the project that is graded.
   - Presentation Showcase (Due Date): Thursday, October 28th 2021, 9:00 AM CDT.
 - Must give a brief (10-15 minute) presentation of your project. Be prepared to answer questions about your work from the QC team.
 - All work **MUST BELONG TO THE ASSIGNED TEAM**. Collaboration was allowed and encouraged, but at the end of the project (Gregg and Travis) must have an excellent understanding of every line of code in the project AND BE ABLE TO ANSWER QUESTIONS ABOUT ANY PART OF IT.
