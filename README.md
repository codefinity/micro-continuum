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

  * [Features](#features)
      * [Released](#released)
      * [Completed](#completed)
      * [Currently In Development](#currently-in-development)
      * [In Development Pipeline](#in-development-pipeline)
  * [Getting Started](#getting-started)
      * [Setup](#setup)
      * [Configuration](#configuration)
      * [Console](#console)
      * [Initial Tests](#initial-tests)
  * [API Definition](#api-definition)
  * [Usage](#usage)
  * [Sponsor](#sponsor)
  * [Contributing](#contributing)
  * [Development](#development)
    * [Developer Guidelines](#developer-guidelines)
    * [Development Methodologies Used](#development-methodologies-used)
    * [Design Document](#design-document)
  * [License](#license)
  * [Sponsor](#sponsor)  
  * [Special Thanks](#special-thanks)



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
* Profiles
* Ribbon load balancing

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

##### Emailing Microservice

* Setting Templates

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

##### Chat Microservice

##### Search Microservice

##### Geography Microservice

##### Notification Microservice

##### Management Microservice

##### Audit Microservice

#### Planned For Future

##### Social Networking Microservice

## Getting Started

### Setup

### Configuration

### Console

### Initial Tests

## API Definition

API Documentation can be found [here](https://codefinity.gitbooks.io/micro-continuum/content/)

## Usage

## Sponsor

Kindly support the Developers of the project who spend considerable time, effort and money in

  * Designing.
  * Documenting.
  * Reading the articles on the web abd identifying best practices.
  * Buying and reading books to find best techniques to Architect the project.
  * Writing maintainable code.
  * Keeping the project up to date with latest tachnologies.

Please Donate

Credits will be given in Special Thanks section.

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
