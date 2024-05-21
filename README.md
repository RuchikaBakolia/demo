# GitHub Status to New Relic Events

## Overview

This project is a Spring Boot application designed to fetch the current status of GitHub from the GitHub Status API and send this data to New Relic as custom events at regular intervals. This application demonstrates how to integrate third-party service statuses into New Relic for enhanced observability and monitoring.

## Features

- **Fetch GitHub Status**: Periodically fetches the status of GitHub from the GitHub Status API.
- **Send Data to New Relic**: Sends the fetched status data to New Relic as custom events.
- **Scheduled Execution**: Uses Spring's scheduling capabilities to execute tasks at regular intervals.
- **Object Mapping with Jackson**: Maps JSON responses from the API to Java objects using Jackson.
- **Simplified Data Handling with Lombok**: Uses Lombok to reduce boilerplate code in data model classes.

## Technologies Used

- **Spring Boot**: Framework for building Java applications.
- **New Relic Telemetry SDK**: Library for sending custom metrics and events to New Relic.
- **Jackson**: Library for JSON parsing.
- **Lombok**: Library to reduce boilerplate code.

## Usage
### Prerequisites
- Java 11 or higher
- Gradle
- New Relic Account

## Setup the application in local

### 1. Clone the Repository

- `git clone https://github.com/yourusername/github-status-newrelic.git`
- `cd github-status-newrelic'`

### 2. Configure New Relic API Key
--  Add your New Relic API key to the application.yml file:
- `newrelic.key=YOUR_NEW_RELIC_API_KEY`

### 3. Build the Project
- `./gradlew clean build`

### 4. Run the Application
- `./gradlew bootRum`
