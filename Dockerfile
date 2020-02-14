FROM gradle:6.1.1-jdk13 AS GRADLE_BUILD

EXPOSE 8080

COPY build.gradle .
COPY settings.gradle .
COPY /src/ ./src/

RUN gradle clean build

RUN mv src/main/resources /app/
RUN mv build/libs/marvel-api-0.0.1-SNAPSHOT.jar /app/

WORKDIR /app

ENTRYPOINT ["java", "-jar", "marvel-api-0.0.1-SNAPSHOT.jar"]