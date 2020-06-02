# java-microservices
Java Microservices: Spring Boot, Spring Cloud, Spring Cloud Netflix, Eureka, Service Discovery, RabbitMQ, MongoDB

## Run rabbitmq docker image:
docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672  -p 5672:5672 rabbitmq:3-management

#### This will get the official image with management console added. It will also expose ports 15672 – for the management console and 5672 – for the connection to the RabbitMQ. That means you can inspect the management console going to http://localhost:15672, the default password and username being guest/guest. Once you go to that URL and you login, you should see:


## Run mongodb docker image:
docker run -d --name mongodb -p 27017:27017 -d mongo


## Producer Request
```
curl --location --request POST 'http://localhost:8084/requestorder' --header 'Content-Type: application/json' --header 'Content-Type: text/plain' --data-raw '{
    "customerOrder": "client1",
    "phone": "11111111",
    "email": "client1@guimasoftware.com",
    "status": "PAGO",
    "itemId": 111
}'
```




