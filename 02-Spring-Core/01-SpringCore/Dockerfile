FROM amazoncorretto:21-alpine3.19
RUN mkdir /opt/app
COPY ./target/01-SpringCore-0.0.1-SNAPSHOT.jar /opt/app/app.jar
CMD ["java", "-jar", "/opt/app/app.jar"]