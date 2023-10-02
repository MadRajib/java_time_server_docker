# java_time_server_docker
A java webserver that tells time, deployed in docker

## Compile the app
1. cd ./java_app/
2. javac ./SimpleTimeServer.java
   
## To run the server
1. java SimpleTimeServer

## To check the server from diff terminal
1. curl -i curl -i http://localhost:6000
```bash
HTTP/1.1 200 OK

Mon Oct 02 17:12:43 UTC 2023
```
