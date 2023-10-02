# java_time_server_docker
A java webserver that tells time, deployed in docker

### Compile the app
```bash cd ./java_app/
javac ./SimpleTimeServer.java
```   
### To run the server
```bash
java SimpleTimeServer
```

### To check the server from diff terminal 
```bash
curl -i http://localhost:6000

HTTP/1.1 200 OK

Mon Oct 02 17:12:43 UTC 2023
```

## Deploy as docker
### 1.  Check Dockerfile
```docker
FROM openjdk:11

ADD ./java_app/ /tmp
WORKDIR /tmp
EXPOSE 6000

ENTRYPOINT ["java", "SimpleTimeServer"]
```
### 2. create docker image
```bash
$ docker build -f Dockerfile . -t web-server-test
+] Building 3.0s (8/8) FINISHED                                                                                     docker:default
 => [internal] load build definition from Dockerfile                                                                           0.0s
 => => transferring dockerfile: 141B                                                                                           0.0s
 => [internal] load .dockerignore                                                                                              0.0s
 => => transferring context: 2B                                                                                                0.0s
 => [internal] load metadata for docker.io/library/openjdk:11                                                                  3.0s
 => [internal] load build context                                                                                              0.0s
 => => transferring context: 81B                                                                                               0.0s
 => [1/3] FROM docker.io/library/openjdk:11@sha256:99bac5bf83633e3c7399aed725c8415e7b569b54e03e4599e580fc9cdb7c21ab            0.0s
 => CACHED [2/3] ADD ./java_app/ /tmp                                                                                          0.0s
 => CACHED [3/3] WORKDIR /tmp                                                                                                  0.0s
 => exporting to image                                                                                                         0.0s
 => => exporting layers                                                                                                        0.0s
 => => writing image sha256:09c616a699824be828d6c44464672cd98a396fcd19f3a57883798b9ec18aaebd                                   0.0s
 => => naming to docker.io/library/web-server-test                                                                             0.0s
```
To check the build images
```bash
$ docker images
REPOSITORY        TAG       IMAGE ID       CREATED          SIZE
web-server-test   latest    09c616a69982   48 minutes ago   654MB
```
### 3. to run the docker
```bash
$ sudo docker run -p 6000:6000 web-server-test
sudo docker run -p 6000:6000 web-server-test
Simple Echo Server
Waiting for connection…..
```

To run it in detached mode
```bash
$ sudo docker run -d -p 6000:6000 web-server-test
bb19cebf763c4a249cba0cb5c62d008ec6fb3b7dd12ddb6d0e209c9c0a9c268e
```
To check running container
```bash
$ sudo docker container ls
CONTAINER ID   IMAGE             COMMAND                  CREATED          STATUS          PORTS                                       NAMES
bb19cebf763c   web-server-test   "java SimpleEchoServ…"   39 seconds ago   Up 38 seconds   0.0.0.0:6000->6000/tcp, :::6000->6000/tcp   jovial_golic
```
## To check the server from diff terminal 
```bash
$ curl -i http://localhost:6000

HTTP/1.1 200 OK

Mon Oct 02 17:12:43 UTC 2023
```

## To stop the container
```bash
$ docker stop bb19cebf763c
```

