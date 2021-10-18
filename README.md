# ChatRoomSpringBoot

```
WebSockets is a bi-directional, full-duplex, persistent connection between a web browser and a server. 
Once a WebSocket connection is established the connection stays open until the client or server decides to close this connection.
```

###1. The Spring Initializer does not provide everything you need in this case. For Maven, you need to add the following dependencies:

```
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>webjars-locator-core</artifactId>
</dependency>
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>sockjs-client</artifactId>
    <version>1.0.2</version>
</dependency>
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>stomp-websocket</artifactId>
    <version>2.3.3</version>
</dependency>
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>bootstrap</artifactId>
    <version>5.0.2</version>
</dependency>
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>jquery</artifactId>
    <version>3.1.1-1</version>
</dependency>
```
##2. Enable WebSocket in Spring
```
we need to add a configuration class and annotate this class with @EnableWebSocketMessageBroker.
> The method configureMessageBroker is used to configure the message broker. 
> he registerStompEndpoints method registers the “/chat” endpoint, enabling Spring’s STOMP support. 
```

##3. Create the Message Model

##4. Create a Message-Handling Controller