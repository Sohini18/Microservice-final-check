FROM java:8
LABEL maintainer="nishadalal.dalal@gmail.com"
VOLUME /tmp
EXPOSE 8761
ADD target/eureka-discovery-service-0.0.1-SNAPSHOT.jar eureka-discovery-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","eureka-discovery-service-0.0.1-SNAPSHOT.jar"]
