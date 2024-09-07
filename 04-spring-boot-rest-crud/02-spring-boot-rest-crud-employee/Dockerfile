FROM amazoncorretto:21-alpine3.19
RUN mkdir /opt/app
COPY ./target/*.jar /opt/app/app.jar
CMD ["java","-jar","/opt/app/app.jar"]
# CMD ["sh", "-c", "sleep 30 && java -jar /opt/app/app.jar"]