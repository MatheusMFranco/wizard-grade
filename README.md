<div align="center">

# Wizard Grade

![](https://img.shields.io/badge/Framework-springboot-brightgreen)

</div>

This API retrieves the name of the Hogwarts house in Portuguese and provides information about each student from that house.

## Index
- [Stack](#stack)
- [Prerequisites](#prerequisites)
- [Environment](#setting-up-the-environment)
- [Build](#build-the-project)
- [Running](#running-the-application)
- [Test](#tests)
- [Endpoints](#endpoints)

## Stack
- Flywaydb
- JPA
- Mysql 9
- Redis
- Junit 5
- Mockk
- Rest
- Coroutines
- Circuit Breaker
- Retrofit

## Prerequisites
- Java 21
- Maven
- Docker

## Setting Up the Environment

You need to run Docker containers for Redis and MySQL. Follow the instructions below to run each container.

**Run MySQL Container**

To start a MySQL container, run the following command:

```bash
docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=wizard -p 3306:3306 -d mysql:9
```

**Run Redis Container**

To start a Redis container, run the following command:

```bash
docker run --name redis -p 6379:6379 -d redis:latest
```

## Build the Project

To build the project, run the following Maven command:

```bash
./mvnw clean install
```

## Running the Application

To run the Spring Boot application, use the following command:

```bash
./mvnw spring-boot:run
```

## Tests

To run tests, you must use Maven as well. To execute all unit tests, run:
```bash
./mvnw test
```

## Endpoints
The base URL for all endpoints is:
```bash
http://localhost:8080/
```

### 1. Find Wizards by House

- **URL**: `/wizards/house/{house}`
- **Method**: `GET`
- **Description**: Retrieve all wizards belonging to a specific house. The house name should be provided in Portuguese.

- **Path Parameters**:
    - `house`: The name of the house in Portuguese. Possible values include:
        - `grifinoria` for Gryffindor
        - `lufalufa` for Hufflepuff
        - `corvinal` for Ravenclaw
        - `sonserina` for Slytherin

- **Response**: Returns a list of wizards from the specified house.

**Example Request**:

```http
GET /wizards/house/grifinoria
```

### 2. By database
It's possible to create your own wizard database.

**Save**:
```http
POST /wizards
```
**Update**:
```http
PUT /wizards/id
```
**Find By Id**:
```http
GET /wizards/id
```
**Find All**:
```http
GET /wizards
```

## House Name Mapping

| English Name   | Portuguese Name |
|----------------|------------------|
| Gryffindor     | Grifinória       |
| Hufflepuff     | Lufa-Lufa        |
| Ravenclaw      | Corvinal         |
| Slytherin      | Sonserina        |


<img width="200" src="https://media4.giphy.com/media/TJO5x5QQM72Q0weWXN/200w.gif?cid=6c09b952mcnzyc64fyn2owi9uzeg861asbym45rn9nb2bx3p&ep=v1_gifs_search&rid=200w.gif&ct=g" />