FROM openjdk:17-oracle
LABEL maintainer="Luna Felipe <lunafelipe1997@gmail.com>"
EXPOSE 8081
ARG JAR_FILE=target/*.jar
ENV MONGODB_URI=${MONGO_DB_URI}
COPY target/*.jar app.jar
CMD ["java", "-jar", "/app.jar"]