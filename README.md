# ChatServer
Chat Server + Client using Web Sockets + Stomp

Probe of concept of Websockets over TCP using StomJS + Spring Boot + Spring data.

### Version
0.0.1

## Reasons
The main goal was create an small server + client chat multi user using stateless connection and Web Socket in order to transmit data.
Instead of implement a multi thread solution manually decided to use the softare already tested and workend in the market.

The choose of Spring - boot made the development quite fast, since it bundle mostly all the software and libraries needed.
Instead of create a multi thread layer my option was use JMS as backend using a lightweight STOMP server that comes by default.

As a try for increase the server load an small layer of persistance was added to the server, Sprig-data with Hibernate as ORM using HSQLD
in memory to store an small amount of data, and make some small queries show that the performance it's not affected quite much. In the future
will be needed to make a performance test with some thousand users. But I believe the system will answer quite well.

##Install and run

This project it's selfcontained. Only needed is checkout the project with git and execute a clean install

```sh
$ mvn clean install
```

Once finish this step without errors (crossfingers) we can proceed to launch the application using maven

```sh
$ mvn spring-boot:run
```

or using the generate jar in the target folder

```sh
$ java -jar chat-server-0.0.1-SNAPSHOT.jar
```
By default server will listen in the port 8080 and bind to all interfaces. That can be changed setting up the connection in the command line

```sh
$ java -jar chat-server-0.0.1-SNAPSHOT.jar --server.port=9090 --server.address=192.168.1.1
```

An small client can be launched using a browser. Used StomJS javascript and SockJS to make the connections with the messages queues and
be able to send and receive messages.

http://192.168.0.14:8090/client.html

The cliend request the address and port where the server it's listening and a user name to be able to communicate.

There are 3 simple inputs that allow us to introduce the message to the common room, send a private message to a user and 
filter an user so we will not see any messages from ir until disable the filter.

