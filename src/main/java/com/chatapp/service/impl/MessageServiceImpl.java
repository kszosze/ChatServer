/**
 * 
 */
package com.chatapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatapp.model.Message;
import com.chatapp.model.Room;
import com.chatapp.model.User;
import com.chatapp.repository.MessageRepository;
import com.chatapp.repository.PrivateMessageRepository;
import com.chatapp.repository.PublicMessageRepository;
import com.chatapp.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private PrivateMessageRepository privateMsgRepository;
	
	@Autowired
	private PublicMessageRepository publicMsgRepository;
	/* (non-Javadoc)
	 * @see com.chatapp.service.MessageService#save(com.chatapp.model.Message)
	 */
	@Override
	public Message save(Message message) {
		return messageRepository.save(message);
	}

	/* (non-Javadoc)
	 * @see com.chatapp.service.MessageService#findAllMessagesByUser(com.chatapp.model.User)
	 */
	@Override
	public List<Message> findAllMessagesByUser(User user) {
		return messageRepository.findAllBySender(user);
	}

	/* (non-Javadoc)
	 * @see com.chatapp.service.MessageService#findAllMessagesByRoom(com.chatapp.model.Room)
	 */
	@Override
	public List<Message> findAllMessagesByRoom(Room room) {
		return publicMsgRepository.findAllByRoom(room);
	}

	/* (non-Javadoc)
	 * @see com.chatapp.service.MessageService#findAllMessageByUserAndRoom(com.chatapp.model.User, com.chatapp.model.Room)
	 */
	@Override
	public List<Message> findAllMessageByUserAndRoom(User user, Room room) {
		return publicMsgRepository.findAllBySenderAndRoom(user,room);
	}

}
