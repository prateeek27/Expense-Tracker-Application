FROM openjdk:17
LABEL authors="prateeek27"
ADD target/Expense-Tracker-0.0.1-SNAPSHOT.jar Expense-Tracker-0.0.1-SNAPSHOT.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Expense-Tracker-0.0.1-SNAPSHOT.jar"]