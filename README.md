# IT Project

## Project Name: `iCare` Hospital Service System

Student Name: Huayu Zhang

Student Number: 2721652z

## Description
This is a distributed system based on Microservice architecture implemented by Spring Cloud Framework.

The government will own and manage a central clinic database that can be accessed by hospital(doctors) and patients.

I aim to make this system have strong robustness and high handling capacity with low latency, and can be applied in the industry.


## Environment Information:

Version Control Matrix:
(Based on [Spring Framework version](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Versions), and [Spring Cloud Documentation](https://spring.io/projects/spring-cloud))


JDK version: `OpenJDK` 17.0.7(LTS)

[Nacos version: 2.2.3 (May 25th, 2023)](https://github.com/alibaba/nacos/releases/tag/2.2.3)


## Technology Stack
1. `Spring Cloud Framework` ([Spring Cloud Alibaba](https://spring.io/projects/spring-cloud-alibaba)) - for integration of dependencies
2. `Ribbon` - as load balancer
3. ~~`Eureka` or~~[Nacos](https://github.com/alibaba/nacos/) - Registration/Configuration center (implementation for `DiscoveryClient` and `ServiceRegistry` Interfaces)
4. `Nginx` - front proxy also as front load balancer for web server

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

Stackholders(Roles):
1. Patients
2. Doctors
3. Hospital
   - Booking System
   - Payment System
4. Government (database owner & manager)