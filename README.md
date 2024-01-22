# Spring Microservices Patient Management

This repository contains a patient management application built with Spring Boot and Spring Cloud, following the microservices architecture. The project focuses on efficient management of doctors, patients, and appointments, providing a scalable and flexible solution.

## Features

**Microservices:**
- **Doctors:** Add, modify, and delete doctor profiles.
- **Patients:** Add, modify, and delete patient information.
- **Appointments:** Schedule, modify, and cancel appointments.
  
**Eureka Integration:**
- Utilizes Eureka for dynamic microservices discovery.
- Automatic registration of microservices with the Eureka server.

## Implementation
### Microservices Responsibilities:

1. Doctors Management:
- Responsible for complete management of doctor information.
- Creation, updating, and deletion of doctor profiles.
  
2. Patients Management:
- Focuses on the management of patient data.
- Addition, modification, and deletion of patient information.
  
3. Appointments Management:
- Facilitates scheduling and management of appointments.
- Offers features for adding, modifying, and canceling appointments.

### Workflow:
**Adding a Doctor:**
- User initiates a request via the UI.
- Doctors management microservice processes the request and adds the doctor.
  
**Adding a Patient:**
- User generates a request to add a new patient.
- Patients management microservice handles the request and integrates the new patient.
  
**Scheduling an Appointment:**
- User schedules an appointment.
- Appointments management microservice coordinates the operation and records the appointment.
  
**Modifying Patient Information:**
- Request to modify patient information is generated.
- Patients management microservice updates the information.
  
**Canceling an Appointment:**
- User requests the cancellation of an appointment.
- Appointments management microservice removes the appointment.

## Architecture and Observability
### Global Architecture:

**Frameworks:**
- Built with Spring Boot and Spring Cloud for a modular and distributed approach.
- Uses Java, Maven, and IntelliJ for development.
  
**Communication:**

- Spring Cloud and Eureka for microservices architecture.
- Feign Client for declarative communication.
- RESTful API at the core.
  
**Data Management:**

- Spring Data for data access abstraction.
- H2 database for efficient data management during development.
  
### Observability:

**Logging:**
Integrated logs pattern for significant event recording.

**Metrics:**
Implemented metrics pattern for quantitative performance measurement.

**Traces:**
Integrated traces pattern for tracking transaction paths.

### Tools:
- Insomnia: Used for effective API testing and validation.
- Grafana: Provides customized visualization of collected metrics and logs.
- Loki: Manages distributed logs, crucial for issue tracking.
- Prometheus: Collects and stores essential metrics for in-depth performance analysis.
- Tempo: Integrated for distributed tracing, providing insights into microservices behavior.


## Contact :busts_in_silhouette:
Feel free to reach out to us if you have any questions or suggestions:

**Chaimae BOUYARMANE**

 <a href="https://linkedin.com/in/chaimae-bouyarmane-14882622b" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="chaimae bouyarmane" height="30" width="40" /></a>
<a href="https://github.com/chaimaebouyarmane" target="_blank">
  <img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/github.svg" alt="Votre nom" height="30" width="40" />
</a> 
