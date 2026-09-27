FROM amazoncorretto:17
COPY ./target/classes/org /tmp/org
WORKDIR /tmp
ENTRYPOINT ["java", "org.example.App"]
