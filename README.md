# hci-jyuichi-full-stack
The REST API connected with the `sohan-deshar/hci-jyouichi` frontend
---
## Requirements
- Functioning `docker` installation with `docker-compose` in order to create mongodb and mongo-express containers for data persistence in backend.
- `java-17` as some `java-17` api's have been used in the project.
- Because the docker binds `27017` port to the mongodb container and `8081` port on the host to mongo-express port, please make sure that these ports are free
to ensure operation without much issue.
___
**NOTE**
The docker-compose config persists the data saved in the container and the data isn't reset on restarting the mongo-container. The `mongo-express`
provides a simple GUI interface in browser at `localhost:8081` URL to view the state of persisted data. This is optional image downloaded by default,
which can be disabled by removing the `mongo-express` service in `docker-compose.yaml` file.
___
## How to run ?
### Preparation step
- run `docker-compose -f <location to docker-compose.yaml file after you've cloned repo> -d up` -> this downloads the mongodb and mongo-express images and creates containers for each and runs them in detached mode.


There should already be a .jar file inside the target directory in the repo which can be used to run the application.
If not present, you could use  `mvn clean install` to generate the .jar file. Once .jar file is generated you can follow the steps **running from .jar file**
### Running from jar file.
- run `java -jar <path-to-generated-jar or jar-inside-target-folder>`
- the above command should create the application on URL `localhost:8080`
### Running directly via maven
- run `mvn spring-boot:run` inside the project directory
- this should also hosts the application on URL `localhost:8080`, or some URL which is shown somewhere around the end of the command output.
