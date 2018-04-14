<h1 align="center">Micro-Continuum</h1> 

<p align="center">
  <strong>Micro-Continuum</strong> is an initiative to create a pre-assembled, configurable, set of reusable components for Microservices that will enable companies to setup their Microservices with minimum effort by mostly concentrating on their business functionalities.
</p>
<br />
<div align="center">
<a href="https://gitter.im/micro-continuum/Lobby"><img src="https://img.shields.io/gitter/room/nwjs/nw.js.svg"></a>  
<a href="https://codefinity.gitbooks.io/micro-continuum/content/"><img src="https://img.shields.io/badge/GitBook-Enabled-yellow.svg"></a>  <a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/license-MIT-blue.svg"></a>

</div>


## Table of Contents

* [Getting Started](#getting-started)
    * [Installations](#installations)
    * [Setup](#setup)
    * [Initial Tests](#initial-tests)
* [User Guide](#user-guide)    
* [Features](#features)
    * [Released](#released)
    * [Completed](#completed)
    * [Currently In Development](#currently-in-development)
    * [In Development Pipeline](#in-development-pipeline)
* [API Definition](#api-definition)
* [Sponsor](#sponsor)
* [Contributing](#contributing)
* [Development](#development)
  * [Developer Guidelines](#developer-guidelines)
  * [Development Methodologies Used](#development-methodologies-used)
  * [Design Document](#design-document)
* [License](#license)
* [Sponsor](#sponsor)  
* [Special Thanks](#special-thanks)

## Getting Started

### Installations

Install Docker:
```
https://docs.docker.com/install/linux/docker-ce/ubuntu/

```

Install Docker Compose:
```
https://docs.docker.com/compose/install/

```

### Setup

```
git https://github.com/codefinity/micro-continuum.git

cd micro-continuum

docker-compose -f ./docker-compose.development.yml up
```

### Initial Tests

These URLs should return messages

```
http://localhost:8095/x-microservice/hello

http://localhost:8095/y-microservice/hello

http://localhost:8095/z-microservice/hello
```

## User Guide

## Features

#### Released

#### Completed

##### Infrastructure

* Config Server and Clients
* Eureka Service Registry
* Zuul Gateway
* Zuul Filter
* Feign Clients
* Communication between Microservices using Spring Cloud Streams (RabbitMQ)
* Hystrix Circuit Breaker integration with Zuul
* Hystrix Dashboard Integration
* Turbine Integration
* Profiles - Development, Testing and Production
* Ribbon load balancing
* Integrating Zipkin Server

##### Logging

* Logging Management using ELK Stack
* Spring Cloud Sleuth integration - Feign and RabbitMQ

##### Other

* Microservice Events

#### Currently In Development

##### Docker

* Dockerizing the microservices
* Deploying using docker compose file

##### Security

* Authentication using OAuth/JWT/OpenId Connect
* Authorization
* Inter Microservices Security
* Social Logins - Google, Facebook, Twitter

##### Infrastructure

#### In Development Pipeline

##### Infrastructure

* Kubernetes Integration

##### Logging and Log Analysis

* Storing logs using Lambda Architecture
* Real time log analysis using Apache Storm
* Real time notification in case of failures

##### API Documentation

* Integrating Swagger

##### Devops

* Building Jenkins CI Pipeline

##### Caching

* Caching using etags
* Caching using Redis
* Hystrix Caching Fallback

##### Communication

* Spring protocol conversion using Spring Integration

##### Automation

* Self Healing Capabilities

##### User Management Microservice

* Multi-Tenant capabilities - Can be used to serve multiple clients and their uses.
* Basic User operations - Get, Add, Update, Delete, Change Password, Forgot Password
* Log User Statistics.
* Manage roles and permissions.
* Serverless Capabilities
* Basic User Management Console in React
* Serverless Capabilities
* Events Subscription
* Custom User Rules
* Create plugins for customizations
* Autoscalable
* Single Sign On
* Integration with messaging systems

##### EMail Microservice

* Setting Templates

##### Chat Microservice

* Used for live conninication between users
* Quickly setting up chat rooms

##### Search Microservice

* Uses Elastisearch for searching

##### Geography Microservice

* Geoserver Integration
* Reactive services to store user location

##### Notification Microservice

* Generates push notifications for mobile and web

##### Management Microservice

* Microservices Control Dashboard
* Sheduling test routines
* Setting Infracture Paramaters
* 
* Setting Alarms for Failure - SMS, Push Notifications and EMail

##### Audit Microservice

#### Planned For Future

##### Social Networking Microservice

##### Chatbot Microservice

##### IOT Microservice Using Spring Reactive Flux

## API Definition

API Documentation can be found [here](https://codefinity.gitbooks.io/micro-continuum/content/)

## Sponsor

## Contributing
You may contribute in several ways like creating new features, testing, fixing bugs, improving documentation, and examples. [Find out more](https://github.com/codefinity/micro-continuum/wiki/Contributing).

## Development

### Developer Guidelines

Anybody is welcome to contribute to this project as long as they make themselves conversant with [these](https://github.com/codefinity/micro-continuum/wiki/Developer-Guidelines) guidelines.

### Development Methodologies Used
* DDD (Domain Driven Design)
* BDD (Behaviour Driven Design)
* CQRS (Command Query Responsibility Segregation)
* TDD (Test-driven Development)
* SOLID
* Reactive 
* 12 Factor Apps
* GOF Design Patterns
  
### Design Document

You can find the design document <a href="https://docs.google.com/document/d/1wvP54ux3oxZCB2isZbwMjo3kQ1b-efL1p2AYQ4UU0l4" target="_blank">here</a>.


## License

The code is licenced under [MIT](LICENSE)

## Special Thanks
