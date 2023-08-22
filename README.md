# iCare: A Clinical Service System

## COMPSCI5018P MSc Development Project for IT+ (2022-23)

Student Name: `Huayu Zhang`

Student Number: `2721652z`

`University of Glasgow` - `School of Computing Science`

## Description
This is a distributed system based on Microservice architecture implemented by `Spring Cloud Framework`.

The government will own and manage a central clinic database that can be accessed by hospital (doctors) and patients.

Project aims to make a system have strong robustness and high handling capacity with low latency, and can be applied in modern clinic industry.

## Project Architecture
Main view of the project architecture (best practice design):

![Project architecture main view (best practice design)](./examples/drawio/diagrams/iCare-best-practice.drawio.png)

Current code space status of the project (development & deploy environment) 
(simplified for better debugging and saving local machine performance):

![code space status of the project](./examples/drawio/diagrams/iCare-dev-env.drawio.png)

## How to
Run:
```shell
sh run-project.sh # under project root directory
```
Test:
```shell
sh test-project.sh  # under project root directory
```
Testing result can be viewed at `testing/Jmeter/webreport/index.html `.

Prepare for Database:

Create corresponding tables for each Microservice and run SQL scripts under `examples/SQLs`.

## Documentation
JavaDoc: Rendered HTML JavaDoc is located in `Documenrations/JavaDoc`

## Requirement Capture (MoSCoW)
- [x] (Must) Microservice for patient, healthcare provider, manager, logging system (web server and databases)
- [x] (Must) Booking system and payment system.
- [x] (Must) Load balancer and reverse proxy.
- [x] (Must) Service Registry and configuration center.
- [x] (Must) Docker container and building automation.
- [ ] (Should) Message queue.
- [ ] (Should) Distributed cache.
- [ ] (Should) Microservices for database owner (e.g., government), researchers, pharmacy corporations (multi-level administration and authorization).
- [ ] (Should) Full data CRUD (Create, Retrieve, Update, Delete) (Create and Retrieve has been done) (Update and delete should develop along with frontend).
- [ ] (Could) Cross platform frontend applications for demonstration purpose (Web, Darwin, Win64, GNU/Linux, IOS, Android…).
- [ ] (Could) Newer dependencies (more advanced technology and coding style).
- [ ] (Could) Spring security, data desensitization (for researching Big data and Machine Learning Data Sets) and more cryptography.
- [ ] (Could) More feature: Pharmacy service, etc.
- [ ] (Could) High-definition image storing and support and multiple format support in database (for radioscopy, or orthodontics clinic…).
- [ ] (Could) CDN (Content Distribution Network) support.

## Environment Information:

Version Control Matrix:
(Based on [Spring Framework version](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Versions), and [Spring Cloud Documentation](https://spring.io/projects/spring-cloud)) on the day of writing (Jul 7, 2023).

| Spring           | JDK         | Spring Cloud      | Spring Boot | MyBatis-Spring-Boot-Starter |
|------------------|-------------|-------------------|-------------|-----------------------------|
| 6.1.x (Nov 2023) | null        | 2022.0            | 3.0, 3.1    | null                        |
| 6.0.x (Nov 2022) | 17+         | 2021.0 (2021.0.3) | 2.6, 2.7    | 2.3                         |
| 5.3.x            | 1.8, 11, 17 | 2020.0 (2020.0.3) | 2.4 (2.5)   | 2.3                         |
| 4.3.x    (EOL)   | 1.8         | --                | --          | --                          |
| 3.2.x    (EOL)   | 1.8         | --                | --          | --                          |

The project aiming to serve the industry, so the `EOL` (end of life) version should not be used (even most of the enterprises may still use the EOL version).

Thus, the project plan to support Spring `5.3.x` first. Because it is the most stable version of spring ecosystem and have the `best compatibility` (support all `LTS` JDK for now).

But for learning and coding style issue, temporary downgrade the spring cloud to `Hoxton.SR12`.

JDK version: `OpenJDK` 1.8 (8.0) (x86_64).

[Nacos version: 2.2.3 (May 25th, 2023)](https://github.com/alibaba/nacos/releases/tag/2.2.3)


## Technology Stack
1. `Spring Cloud Framework` ([Spring Cloud Alibaba](https://spring.io/projects/spring-cloud-alibaba)) - for integration of dependencies
2. `Ribbon` - as load balancer
3. ~~`Eureka` or~~ [Nacos](https://github.com/alibaba/nacos/) - Registration/Configuration center (implementation for `DiscoveryClient` and `ServiceRegistry` Interfaces)
4. `Nginx` - front proxy also as front load balancer for web server
5. `MySQL` as database for Nacos clusters and services' clusters.

## Demonstration for single request inside the system 

Request booking service as example:

![Request booking service](./examples/drawio/diagrams/iCare-request-bk-service.drawio.png)

### Why use `Alibaba Nacos` rather than `Eureka`?
1. More feature 
   - cluster management for remote disaster recovery/load balance/reduce latency
   - can easily control weight for load balancing
   - easy environment isolation
   - Nacos supports active surveillance use for non-temporary instance (so that if this kind of service is down, it would be deleted automatically)
   - the consumer service not only can pull information from Nacos, but also can get pushed message so the cache would clear faster on demand with low latency
2. More popular (in Chinese industry)

#### Issue building Nacos clusters:
<org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'grpcSdkServer': Invocation of init method failed; nested exception is java.io.IOException: Failed to bind to address 0.0.0.0/0.0.0.0:9992>

[Fix](https://github.com/alibaba/nacos/issues/4873): each of the instance of nacos 2.0+ will use 4 different ports:
1. server.port(default to 8848）
2. raft port: ${server.port} - 1000
3. grpc port: ${server.port} + 1000
4. grpc port for server: ${server.port} + 1001
Thus, the clusters server ports should at least have at least 2 for offset.

#### Stackholders(Roles):
1. Patients
2. Doctors
3. Hospital
   - Booking System
   - Payment System
4. Government (database owner & manager)

#### Fein Optimization:
1. set log level to `BASIC` or `NONE` in production environment
2. use `Apache HttpClient` or `OKHttp` for backend (support `connection pool`), rather than `URLConnection` (default).

## Credits
- Open source projects:
  - [Spring Project](https://github.com/spring-projects/spring-framework)
  - [Spring Cloud Alibaba](https://github.com/alibaba/spring-cloud-alibaba)
  - [Redis Project](https://redis.io/)
  - [Nginx Project](https://www.nginx.com/)
  - [Apache Tomcat](https://tomcat.apache.org/)
  - [OpenJDK](https://openjdk.org/)
- Tutorials:
  - Itcast:
    - [Spring MVC](https://www.bilibili.com/video/BV1Bo4y117zV/?spm_id_from=333.999.0.0)
    - [Spring Cloud](https://www.bilibili.com/video/BV1LQ4y127n4/?spm_id_from=333.999.0.0)
    - [Jmeter](https://www.bilibili.com/video/BV1ty4y1q72g?p=1)
