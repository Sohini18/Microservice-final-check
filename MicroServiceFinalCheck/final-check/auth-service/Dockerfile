FROM java:8
LABEL maintainer="nishadalal.dalal@gmail.com"
VOLUME /tmp
EXPOSE 9100
ADD target/auth-service-0.0.1-SNAPSHOT.jar auth-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","auth-service-0.0.1-SNAPSHOT.jar"]
