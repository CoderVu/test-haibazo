
FROM maven:3.9.8-amazoncorretto-17 AS build

WORKDIR /app
COPY pom.xml .
COPY src src
RUN mvn clean package -DskipTests

FROM amazoncorretto:17
VOLUME /tmp
ARG JAR_FILE=target/Test-0.0.1-SNAPSHOT.jar
COPY --from=build /app/${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]