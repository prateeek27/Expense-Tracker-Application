FROM openjdk:17
LABEL authors="prateeek27"

VOLUME /tmp
ADD target/Expense-Tracker-0.0.1-SNAPSHOT.jar Expense-Tracker-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "Expense-Tracker-0.0.1-SNAPSHOT.jar"]
