USAGE MANUAL
------------

> Preconditions: Application **chrisblog-be-springboot** working on port **8081**

1. In the comman line **start application** with `mvn spring-boot:run` 
1. In the browser visit `http://localhost:8080`


USAGE DOCKER
------------

> Preconditions: Application **chrisblog-be-springboot** working on port **8081**

1. Start **Docker** tool
1. In the comman line **build Docker image** with `docker build -t wisniewskikr/chrisblog-fe-thymeleaf .`
1. In the comman line **run Docker container** with `docker run -d -p 8080:8080 wisniewskikr/chrisblog-fe-thymeleaf`
1. In the browser visit `http://localhost:8080`