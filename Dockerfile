FROM amazoncorretto:17

COPY ./target/First_Projectt-1.0-SNAPSHOT.jar /tmp/app.jar
COPY ./target/dependency /tmp/dependency

WORKDIR /tmp

ENTRYPOINT ["java", "-cp", "app.jar:dependency/*", "org.example.App"]