# java_time_server_docker
A java webserver that tells time, deployed in docker

## Compile the app
```bash cd ./java_app/
javac ./SimpleTimeServer.java
```   
## To run the server
```bash
java SimpleTimeServer
```

## To check the server from diff terminal 
```bash
curl -i http://localhost:6000

HTTP/1.1 200 OK

Mon Oct 02 17:12:43 UTC 2023
```

## Deploy as docker
1.  Check Dockerfile
```docker
FROM openjdk:11

ADD ./java_app/ /tmp
WORKDIR /tmp
EXPOSE 6000

ENTRYPOINT ["java", "SimpleEchoServer"]
```
2. create docker image
```bash
$ docker build -f Dockerfile . -t web-server-test
```
3. to run the docker
```bash
$ sudo docker run -p 6000:6000 web-server-test
// to run it in detached mode
sudo docker run -d -p 6000:6000 web-server-test
```
## To check the server from diff terminal 
```bash
curl -i http://localhost:6000

HTTP/1.1 200 OK

Mon Oct 02 17:12:43 UTC 2023
```

