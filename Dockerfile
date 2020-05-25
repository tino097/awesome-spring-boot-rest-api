FROM gradle:5.4

RUN git clone https://github.com/tino097/awesome-spring-boot-rest-api.git && \
        cd awesome-spring-boot-rest-api && \
        ./gradlew clean build

ARG JAR_FILE=build/libs/app-0.1.0.jar

WORKDIR /opt/app
COPY ${JAR_FILE} app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]