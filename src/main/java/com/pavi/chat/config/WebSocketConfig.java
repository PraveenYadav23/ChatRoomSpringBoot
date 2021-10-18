package com.pavi.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author Praveen Yadav
 * @since 18-Oct-2021, 9:10 PM
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     *The method registers the “/chat” endpoint, enabling Spring’s STOMP support.
     *
     * This endpoint, when prefixed with “/app”, is the endpoint that the ChatController.send() method is mapped to handle.
     *
     * It also enables the SockJS fallback options, so that alternative messaging options may be used if WebSockets are not available.
     * This is useful since WebSocket is not supported in all browsers yet and may be precluded by restrictive network proxies.
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").withSockJS();
    }

    /**
     *The method is used to configure the message broker.
     * First, we enable an in-memory message broker to carry the messages back to the client on destinations prefixed with “/topic”.
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
