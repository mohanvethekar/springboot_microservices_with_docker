# Spring Boot Microservices Project with Docker & MongoDB

A **Spring Boot Microservices** application demonstrating a clean architecture using **REST APIs**, **Docker**, and **MongoDB**.  
This project shows how multiple microservices communicate with each other in a containerized environment.

## Features

-Built using **Spring Boot 3+**  
-Follows **Microservices Architecture**  
-Containerized with **Docker & Docker Compose**  
-Uses **MongoDB** for data storage  
-RESTful APIs for CRUD operations  
-Simple, modular, and easy-to-extend design

## Project Architecture

microservicesproject/
│
├── product-service/ → Handles product CRUD operations
│ ├── src/
│ ├── pom.xml
│ └── Dockerfile
│
├── order-service/ → Manages orders (example extension)
│ ├── src/
│ ├── pom.xml
│ └── Dockerfile
│
├── api-gateway/ → Central gateway for routing requests
│ ├── src/
│ ├── pom.xml
│ └── Dockerfile
│
├── discovery-server/ → Eureka service discovery
│ ├── src/
│ ├── pom.xml
│ └── Dockerfile
│
├── docker-compose.yml → Multi-container orchestration file
├── README.md
└── pom.xml → Parent Maven configuration
