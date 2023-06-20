# IT Project

Student Name: Huayu Zhang

Student Number: 2721652z

## Description
This is a distributed system based on Microservice architecture implemented by Spring Cloud Framework


## Environment Information:

JDK version: OpenJDK 20.0.1


## Technology Stack
1. Spring Cloud Framework ([Spring Cloud Alibaba](https://spring.io/projects/spring-cloud-alibaba)) - for integration of dependencies
2. Ribbon - as load balancer
3. Eureka or [Nacos](https://github.com/alibaba/nacos/) - Registration/Configuration center (implementation for `DiscoveryClient` and `ServiceRegistry` Interfaces)
4. Nginx - front proxy also as front load balancer for web server
5. 