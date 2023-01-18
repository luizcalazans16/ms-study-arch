FROM gradle:7.6-jdk17 as builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle -g $BUILD_CACHE_PATH clean build -x test

FROM azul/zulu-openjdk-alpine:17
COPY --from=builder /home/gradle/src/application/build/libs/ms-study-loan.jar ms-study-loan.jar
EXPOSE 8080
CMD ["java", "-jar", "ms-study-loan.jar"]