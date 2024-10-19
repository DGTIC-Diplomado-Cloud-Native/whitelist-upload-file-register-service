FROM openjdk:17-oracle
LABEL maintainer="Luna Felipe <lunafelipe1997@gmail.com>"
EXPOSE 8082
ARG JAR_FILE=target/*.jar
COPY target/*.jar app.jar
ARG MONGODB_URI=mongodb://localhost:27017/files
ENV SPRING_DATA_MONGODB_URI=${MONGODB_URI}
CMD ["java", "-jar", "/app.jar"]
