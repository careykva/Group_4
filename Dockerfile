FROM openjdk:latest
COPY ./target/seMethods-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seMethods-0.1.0.2-jar-with-dependencies.jar"]

FROM mysql
WORKDIR /tmp
COPY test_db/*.sql /tmp
COPY test_db/*.dump /tmp/
COPY test_db/employees.sql /docker-entrypoint-initdb.d
ENV MYSQL_ROOT_PASSWORD example