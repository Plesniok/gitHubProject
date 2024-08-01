# Spring boot web API example

## Overview
I would like to present some of my skills in writing REST API using Spring Boot tchnology.
This project implements fetching data from Github API about user repositories.

## Dependencies
Before you begin, ensure you have met the following requirements:
- Java 21 or later
-  Maven 3.9.6 or later

## Configuration
All project environment variables are placed in file `src/main/resources/application.properties`

    server.port=3001
    spring.application.name=products

	env.github.url=https://api.github.com    


## Build and Run the Application

Navigate to your project directory in the terminal. You can then build and run the application using Maven:

Bash

```
mvn clean install

```

This command will download any dependencies required by the project and then package it into a runnable JAR file. Once the build is successful, you can start the application using the following command:

Bash

```
mvn spring-boot:run
```
## API documentation
### Swagger UI

You can access the API documentation at `http://<your-host>:<port>/swagger-ui.html`.
