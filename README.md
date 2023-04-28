# Dashboarder Spring MVC API
`The purpose of this project is to interact a little bit with Java Spring MVC`
## The UI (User Interface)
![Screenshot from 2023-04-28 18-47-13](https://user-images.githubusercontent.com/95311883/235217933-e8dba9ca-681b-4568-8b61-f57148b45362.png)

### Link to the UI repo: [User Interface](https://github.com/tati2002med/youtube-dashboarder-service)
- For the purpose of building the Frontend I have used the framework Angular.

## Hosting
- The FrontEnd is hosted on a GitHub Page.
- The Spring MVC API is deployed on Azure as an App Service.
- The Backend MySQL Database also hosted on Azure.

## Description
The repository `dashboarder-spring-mvc-api` on GitHub contains source code for a Java Spring MVC web application that serves as an API for a dashboarding application. The application allows users to create a dashboards by adding the `URL` and the API will fetch the data from `Youtube API`.


- The code in the repository is organized into several packages, including `config`, `controller`, `service`, `model`, and `dao`. 
  - The controller package contains Java classes that handle incoming HTTP requests and map them to `/api/data`. 
  - The service package contains classes that implement business logic and interact with data access objects (DAOs) in the dao package. 
  - The model package contains class that represent a table `youtubeData` which store the data coming from `Youtube API`. 
  - The dao package contains interface that define save method for interacting with a database.

- Also, there is the package `utils` that contains the class that handle the Youtube API.


- The repository contains several subdirectories, including <b>resources (which contains configuration file db.properties)</b>.

Overall, the repository provides a starting point for building a Spring MVC-based API for a dashboarding application.

#### Repository Architecture
``` bash
.
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── tati
│   │   │           ├── config
│   │   │           │   ├── AppConfig.java
│   │   │           │   ├── WebAppInitializer.java
│   │   │           │   └── WebConfig.java
│   │   │           ├── controller
│   │   │           │   └── YoutubeAPIController.java
│   │   │           ├── dao
│   │   │           │   ├── YoutubeDAOImpl.java
│   │   │           │   └── YoutubeDAO.java
│   │   │           ├── model
│   │   │           │   └── YoutubeData.java
│   │   │           ├── service
│   │   │           │   ├── YoutubeServiceImpl.java
│   │   │           │   └── YoutubeService.java
│   │   │           └── utils
│   │   │               └── YoutubeAPI.java
│   │   ├── resources
│   │   │   └── db.properties
│   │   └── webapp
│   │       └── WEB-INF
│   │           └── web.xml
│   └── test/*
└── target/*

34 directories, 28 files

```

