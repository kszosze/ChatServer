package com.chatapp.controller;

import java.text.DateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.chatapp.factory.MessageFactory;
import com.chatapp.json.ChatMessage;
import com.chatapp.model.Message;
import com.chatapp.model.PrivateMessage;
import com.chatapp.model.PublicMessage;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageController.
 */
@Controller
public class MessageController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	/** The template. */
	@Autowired
	private SimpMessagingTemplate template;
	
	/** The message factory. */
	@Autowired
	private MessageFactory messageFactory;
	
    /**
     * Entry point for receive the message from the Chat Client and send to the correct queue 
     *
     * @param chatMessage the chat message
     * @throws Exception the exception
     */
    @MessageMapping("/send")
    public void sendMessage(ChatMessage chatMessage) throws Exception {
        Message message = messageFactory.create(chatMessage);
        if (message instanceof PublicMessage)
        {
        	logger.info("Received message for room "+chatMessage.getRoom()+" at "+DateFormat.getDateInstance().format(message.getTimestamp()));
        	template.convertAndSend("/topic/"+((PublicMessage)message).getRoom().getName(),chatMessage);		
        }else 
        {
        	logger.info("Received message for user "+chatMessage.getRoom()+" at "+DateFormat.getDateInstance().format(message.getTimestamp()));
        	template.convertAndSend("/topic/"+((PrivateMessage)message).getReceiver().getUserName(), chatMessage);
        }
    }

}
