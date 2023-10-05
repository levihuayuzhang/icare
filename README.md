# iCare: An Implementation of Comprehensive Clinical Service System

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


Prepare for Database:

Create corresponding tables for each Microservice and run SQL scripts under `examples/SQLs`.


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
- [x] (Could) Newer dependencies (more advanced technology and coding style).
- [ ] (Could) Spring security, data desensitization (for researching Big data and Machine Learning Data Sets) and more cryptography.
- [ ] (Could) More feature: Pharmacy service, etc.
- [ ] (Could) High-definition image storing and support and multiple format support in database (for radioscopy, or orthodontics clinic…).
- [ ] (Could) CDN (Content Distribution Network) support.

## Environment Information:
- JDK: OpenJDK `21 LTS`
- Spring Framework: `6`
- Spring Boot: `3.1`
- Spring Cloud: `2022.0.4`
- Spring Cloud Alibaba: `2022.0.0.0`
- Nacos `v2.2.3-slim`
- Elastic Stack (Elasticsearch & Hibaba for now): `8.8.2`
  - analyzer: ik `8.8.2`

## Demonstration for single request inside the system 

Request booking service as example:

![Request booking service](./examples/drawio/diagrams/iCare-request-bk-service.drawio.png)

#### Stackholders(Roles):
1. Patients
2. Doctors
3. Hospital
   - Booking System
   - Payment System
4. Government (database owner & manager)
5. Researchers in academia and 3rd party enterprises