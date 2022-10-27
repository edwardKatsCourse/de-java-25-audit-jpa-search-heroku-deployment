FROM openjdk:17-alpine

ADD /target/accounts.jar accounts.jar

EXPOSE ${PORT}

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=cloud", "accounts.jar"]

# java -jar -Dspring.profiles.active=cloud accounts.jar