FROM adoptopenjdk/openjdk11:latest

COPY ./target/notifications.jar /usr/app/

WORKDIR /usr/app


ENTRYPOINT ["java","-jar","/usr/app/notifications.jar"]
