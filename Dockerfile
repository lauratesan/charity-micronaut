FROM openjdk:8u171-alpine3.7
RUN apk --no-cache add curl
COPY target/charity-micronaut*.jar charity-micronaut.jar
CMD java ${JAVA_OPTS} -jar charity-micronaut.jar