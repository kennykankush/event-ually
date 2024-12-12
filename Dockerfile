FROM maven:3.9.9-eclipse-temurin-23

LABEL name="event-ually"

ARG APP_DIR=/app

COPY mvnw .
COPY pom.xml .
COPY .mvn .mvn
COPY src src

RUN mvn package -Dmaven.test.skip=true

ENV SERVER_PORT=8080

EXPOSE ${SERVER_PORT}

ENTRYPOINT java -jar target/event-ually-0.0.1-SNAPSHOT.jar

# FROM maven:3.9.9-eclipse-temurin-23 AS builder

# WORKDIR /app

# COPY . .

# RUN mvn package -Dmaven.test.skip=true

# FROM maven:3.9.9-eclipse-temurin-23

# WORKDIR /app

# COPY --from=builder /app/target/*.jar app.jar

# ENV PORT=8080

# EXPOSE ${PORT}

# ENTRYPOINT SERVER_PORT=${PORT} java -jar /app/app.jar -Dserver.port=${PORT}

# -------------------------------------



# FROM maven:3.9.9-eclipse-temurin-23

# LABEL name="event-ually"

# ARG APP_DIR=/app

# COPY mvnw .
# COPY pom.xml .
# COPY .mvn .mvn
# COPY src src

# RUN mvn package -Dmaven.test.skip=true

# ENV SERVER_PORT=8080

# EXPOSE ${SERVER_PORT}

# ENTRYPOINT java -jar target/event-ually-0.0.1-SNAPSHOT.jar

# # FROM maven:3.9.9-eclipse-temurin-23

# # ARG DEPLOY_DIR=/app
    
# # WORKDIR ${DEPLOY_DIR}
# # COPY --from=compiler target/event-ually-0.0.1-SNAPSHOT.jar target/event-ually-0.0.1-SNAPSHOT.jar
    
# # ENV SERVER_PORT=8080

# # EXPOSE ${SERVER_PORT}

# # ENTRYPOINT java -jar target/event-ually-0.0.1-SNAPSHOT.jar