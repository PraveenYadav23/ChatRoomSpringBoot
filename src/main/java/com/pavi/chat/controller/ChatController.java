package com.pavi.chat.controller;

import com.pavi.chat.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Praveen Yadav
 * @since 18-Oct-2021, 9:19 PM
 */

@RestController
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message send(Message message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new Message(message.getName(), message.getContent(), time);
    }
}
