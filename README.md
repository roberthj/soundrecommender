# Sound Recommender

The Sound Recommender is service where users can create sounds and playlist.

Users can also get sounds recommended based on a provided playlist.

On a high level the project uses:
 - **Java 21** with **Spring Boot** framework
 - **Maven** for build and dependency management
 - **Hibernate/JPA** for interacting with the database
 - **Junit5** and **Test Containers** for testing
 - **Postgres** database
 - **Docker Compose** to spin up local database
 - **FlyWay** for database migrations

# How to run locally

## Prerequisites

### Java 17

If needed, install Java 21 (earlier versions may also work)

If you need to install Java the easiest way may be to use **Homebrew** to install. If you prefer to install manually instead, have a look [here](https://www.codejava.net/java-se/setup-openjdk-21-on-macos)

**Homebrew** can be found [here](https://brew.sh/)

Run this command in your terminal to install Java
```console 
brew install openjdk@21
```
Set the **JAVA_HOME** environment variable
```console 
export JAVA_HOME=/usr/local/opt/openjdk@21
```
Run the following command to apply the changes

```console 
source ~/.bash_profile   # or source ~/.zshrc if using Zsh
```
Verify the installation
```console 
java -version
```


### Docker desktop
Ensure that Docker is installed on your laptop. 
You can download and install it from the official Docker website: https://www.docker.com/products/docker-desktop

### Build the project
Run this **Maven** command in your terminal in the project root folder.
```console 
mvn clean install
```



If you need to install Maven the easiest way may be to use **Homebrew** to install by following [this guide](https://mkyong.com/maven/install-maven-on-mac-osx/)

Other options for installing **Maven** can be found [here](https://www.baeldung.com/install-maven-on-windows-linux-mac)


### Start the local postgres database

Run this terminal command from the **project root**
```console 
docker-compose up -d
```


### Start the service

Open the project in your favourite IDE.

Configure the IDE to use Java 17 for this project.

The entrypoint for the application is the file 
```src/main/java/com/roberthj/soundrecommender/Application.java```

Start the service by running the file directly from your IDE

OR

from the terminal by going to the folder

```soundrecommender/target```

and running the command
```console 
java -jar soundrecommender-0.0.1-SNAPSHOT.jar
```

On startup a sql migration script will run and generate the database tables in the local **postgres** database


## Endpoints

### Create sound
Call this endpoint to create new sounds.

Endpoint: http://localhost:8080/admin/sounds

Method: Post

Payload:
``` json
{
    "data": [
        {
        "title": "New song",
        "bpm": 120,
        "genres": ["pop"],
        "duration_in_seconds": 120,
        "credits": [
            {
                "name": "King Sis",
                "role": "VOCALIST"
            },
            {
                "name": "Ooyy",
                "role": "PRODUCER"
            }
        ]
        }
    ]
}
```
Response:
``` json
{
    "data": [
        {
            "id": "01274cb7-a0ca-4997-a571-2f5b6d8be4af",
            "title": "New song",
            "bpm": 120,
            "genres": [
                "pop"
            ],
            "duration_in_seconds": 120,
            "credits": [
                {
                    "name": "King Sis",
                    "role": "VOCALIST"
                },
                {
                    "name": "Ooyy",
                    "role": "PRODUCER"
                }
            ]
        }
    ]
}
```

### Get sounds
Call this endpoint to fetch all existing sounds from the database.

Endpoint: http://localhost:8080/sounds

Method: GET

Response:
``` json
{
    "data": [
        {
            "id": "01274cb7-a0ca-4997-a571-2f5b6d8be4af",
            "title": "New song",
            "bpm": 120,
            "genres": [
                "pop"
            ],
            "duration_in_seconds": 120,
            "credits": [
                {
                    "name": "King Sis",
                    "role": "VOCALIST"
                },
                {
                    "name": "Ooyy",
                    "role": "PRODUCER"
                }
            ]
        }
    ]
}
```

### Get sounds by artist (Extra from assignment spec)

By adding a request parameter to the souns endpoint you can fetch sound from a specific artist

Endpoint: http://localhost:8080/sounds/artist=Ooyya

Method: GET

Response:
``` json
{
    "data": [
        {
            "id": "01274cb7-a0ca-4997-a571-2f5b6d8be4af",
            "title": "New song",
            "bpm": 120,
            "genres": [
                "pop"
            ],
            "duration_in_seconds": 120,
            "credits": [
                {
                    "name": "King Sis",
                    "role": "VOCALIST"
                },
                {
                    "name": "Ooyy",
                    "role": "PRODUCER"
                }
            ]
        }
    ]
}
```


### Create playlist
Call this endpoint to create a playlist of existing sounds

Endpoint: http://localhost:8080/playlists

Method: POST

Payload:
``` json
{
    "data":
    [
        {
            "title": "MyPlaylist",
            "sounds": ["01274cb7-a0ca-4997-a571-2f5b6d8be4af"]
        }
    ]
}
```
Response:
``` json
{
    "data": [
        {
            "id": "15573f9a-10db-48b6-85eb-89c70ed9c215",
            "title": "MyPlaylist",
            "sounds": [
                "01274cb7-a0ca-4997-a571-2f5b6d8be4af"
            ]
        }
    ]
}
```

### Get recommended sounds
Call this endpoint to get recommended sounds based on a provided playlist.
This will return other sounds from the same artists that appear in the playlist.

Endpoint: http://localhost:8080/sounds/recommended?playlistId={{playlistId}}

Method: GET

Response:
``` json
{
    "data": [
        {
            "id": "5874dab9-99fb-422c-860b-a5ffd1674cb8"",
            "title": "Another song",
            "bpm": 120,
            "genres": [
                "pop"
            ],
            "duration_in_seconds": 120,
            "credits": [
                {
                    "name": "King Sis",
                    "role": "VOCALIST"
                },
                {
                    "name": "Ooyy",
                    "role": "PRODUCER"
                }
            ]
        }
    ]
}
```



## If I had more time I would have

These are some things that I would focus if I had more time on to make this production ready.

**A more complex data model**
 - Introduce separate tables for **Genre** and **Artists** and include two more mapping tables.

**More complete test coverage**
 - I now wrote one or a couple examples of tests for each class, but added information about what more I would have tested with more time.

**Add versioning to the API**
 - I did not do this because I did not want to risk breaking the postman test suite.

**Exception handling**
  - I would put more thought into this

**Logging**
 - Use a logging library instead of using System.out.println()
 - Put more thought into what I would need to log

