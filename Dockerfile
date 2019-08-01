FROM maven:3.3-jdk-8 AS buildcontainer
ADD . /src/java-client
WORKDIR /src/java-client
RUN mvn clean package

#FROM java:8
#WORKDIR /usr/local/bin/
#COPY --from=0 /src/java-client/target/java-client-5.0.0.jar app.jar
ENTRYPOINT ["java",  "-jar", "/src/java-client/target/java-client-5.0.0.jar"]