FROM java:alpine
ADD target/hi-world.jar hi-world.jar
EXPOSE 8982
ENTRYPOINT ["java","-jar","hi-world.jar"]
