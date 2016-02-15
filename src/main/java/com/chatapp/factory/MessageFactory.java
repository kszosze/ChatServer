package com.chatapp.factory;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chatapp.controller.UserController;
import com.chatapp.json.ChatMessage;
import com.chatapp.model.Message;
import com.chatapp.model.PrivateMessage;
import com.chatapp.model.PublicMessage;
import com.chatapp.model.Room;
import com.chatapp.model.User;
import com.chatapp.service.MessageService;
import com.chatapp.service.RoomService;
import com.chatapp.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Message objects.
 */
@Component
public class MessageFactory {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(MessageFactory.class);

	/** The message service. */
	@Autowired
	private MessageService messageService;
	
	/** The user service. */
	@Autowired
	private UserService userService;
	
	/** The room service. */
	@Autowired
	private RoomService roomService;
	
	/** The room factory. */
	@Autowired
	private RoomFactory roomFactory;

	/** The user factory. */
	@Autowired
	private UserFactory userFactory;
	
	/**
	 * Creates the Message.
	 *
	 * @param chatMessage the chat message
	 * @return the message
	 */
	public Message create(ChatMessage chatMessage)
	{
		Message message = null;
		User user = userService.findByUserName(chatMessage.getSender());
		if (user == null)
		{
			user = userFactory.create(chatMessage.getSender(), chatMessage.getSender());
		}
		Room room = roomService.findByName(chatMessage.getRoom());
		if (room == null && userService.findByUserName(chatMessage.getRoom()) != null)
		{
				 message = new PrivateMessage(userService.findByUserName(chatMessage.getRoom()));
		}else{
				room = roomFactory.create(chatMessage.getRoom());
				message = new PublicMessage(room);
				room.getMessagesList().add((PublicMessage)message);		
				room.getMemberList().add(user);
				roomService.save(room);
		}
			
		message.setContent(chatMessage.getContent());
		message.setTimestamp(new Timestamp(System.currentTimeMillis()));
		message.setSender(user);
		messageService.save(message);
		return message;
	}

}
