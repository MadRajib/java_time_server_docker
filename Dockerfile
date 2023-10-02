FROM openjdk:11

ADD ./java_app/ /tmp
WORKDIR /tmp
EXPOSE 6000

ENTRYPOINT ["java", "SimpleTimeServer"]
