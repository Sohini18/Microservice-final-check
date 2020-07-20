FROM java:8
LABEL maintainer="sarishbiswas@gmail.com"
VOLUME /tmp
EXPOSE 8083
ADD target/zuul-gateway-service-0.0.1-SNAPSHOT.jar zuul-gateway-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","zuul-gateway-service-0.0.1-SNAPSHOT.jar"]
