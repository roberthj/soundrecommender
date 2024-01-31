# Sound Recommender

Explain what this is

# How to run locally

## Prerequisites

### Java 17
Explain how to install and how to configure IntelliJ

Install Java 17 and configure thi project to use it

### Docker desktop
Ensure that Docker is installed on your laptop. 
You can download and install it from the official Docker website: https://www.docker.com/products/docker-desktop

### Build the project
https://brew.sh/
brew install maven (https://mkyong.com/maven/install-maven-on-mac-osx/)

Run 'mvn clean install' in the project root folder

### Start the local postgres database

Terminal command from the project root: docker-compose up -d

### Start the service

By running command ??

Or by running the Application.java file from your IDE.
Path: src/main/java/com/roberthj/soundrecommender/Application.java

OR

terminal: cd soundrecommender/target
terminal: java -jar soundrecommender-0.0.1-SNAPSHOT.jar

A sql migration script will run and generate the database tables on this first run


## Endpoints

### Create sound
Endpoint: http://localhost:8080/v1/admin/sounds

Method: Post

Payload:
Response:

### Get sounds
Endpoint: http://localhost:8080/v1/sounds

Method: Get

Response:

### Create playlist
Endpoint: http://localhost:8080/v1/playlists

Method: Post

Payload:
Response:

### Get recommended sounds
Endpoint: http://localhost:8080/v1/sounds/recommended?playlistId={{playlistId}}

Method: Get

Response: Will return a list of sounds from the same artists that are in the provided playlist


## If I had more time I would have

Created a more complex data model
 - Have separate tables for Genre and Artists

More complete test coverage
 - I now did one or more examples of tests for each class, but added information about what more I would have tested with more time.

Exception handling
  - I would put more thought into this

Logging
 - Use a logging library instead of System.out.println()
