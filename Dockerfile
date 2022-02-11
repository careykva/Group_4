FROM openjdk:latest
COPY release 0.1.0.2
WORKDIR /tmp
ENTRYPOINT ["release 0.1.0.2 (0.1-alpha-2)"]
