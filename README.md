**HelloWorld with Docker using Spring boot**

An example of a java application running on Docker using spring boot

## Build project
```mvn package docker:build```

## Run container
```docker run -p 8080:8080 -d fabuloso/helloworld:latest```

## Run mongo
```docker run --name some-mongo -d mongo```
