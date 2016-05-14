#HelloWorld with Docker using Spring boot

An example of a java application running on Docker using spring boot

## Build project
```mvn package docker:build```

## Run mongo
```docker run --name some-mongo -d mongo```

## Run container with link to mongo
```docker run -p 8080:8080 --link mongo -d fabuloso/helloworld:latest```

