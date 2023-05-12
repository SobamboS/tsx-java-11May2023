
# Github API and Webhook Integration using Spring Boot

This is a Spring Boot application that integrates with the Github API and implements webhooks to track changes in a Github account.


- **Requirements:**
    - Java 8 or above
    - Spring Boot
    - Gradle building script
    - Github API

## Getting Started

To run the application, you will need to have Java 8 or above installed on your machine.

Clone the repository:

git clone https://github.com/SobamboS/tsx-java-11May2023.git


The application should now be running on port 8080.

## Webhooks

To set up webhooks, you will need to use NGROK to create a tunnel to your local machine. Follow the instructions in this video: https://www.youtube.com/watch?v=DCxt9SAnkyc

Once you have NGROK running, you can create a webhook in your Github account that points to the NGROK URL. The webhook should be set up to track push, pull, and merge events.

## Logging

The application uses logback for logging. The log level is set to INFO by default, but you can change this in the `log4j2.xml` file and the logs are saved in a application.log file

## Conclusion

You should now have a fully functional Spring Boot application that integrates with the Github API.

