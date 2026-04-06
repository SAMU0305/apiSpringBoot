FROM eclipse-temurin:17-jdk
ARG JAR_FILE=target/apiConSpringBoot-0.0.1.jar
COPY ${JAR_FILE} apiSpringBoot.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","apiSpringBoot.jar"]