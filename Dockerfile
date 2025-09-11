# Etapa 1: Build con Maven (Amazon Corretto 8)
FROM maven:3.9.11-amazoncorretto-17-alpine AS build

WORKDIR /app

# Copiar pom.xml para cachear dependencias
COPY pom.xml .

RUN mvn dependency:go-offline

# Copiar el código fuente
COPY src ./src

# Compilar y empaquetar el proyecto
RUN mvn clean package -DskipTests

# Etapa 2: Runtime con Java 17 Alpine
FROM openjdk:17-alpine

WORKDIR /app

# Copiar el JAR compilado desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

