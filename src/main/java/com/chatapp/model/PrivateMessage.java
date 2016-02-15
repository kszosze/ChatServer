package com.chatapp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


/**
 * The Class PrivateMessage.
 */
@Entity
@DiscriminatorValue("PRIVATE")
public class PrivateMessage  extends Message {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6097529848261010590L;

	/** The receiver. */
	@ManyToOne
	private User receiver;
	

	/**
	 * Instantiates a new private message.
	 */
	public PrivateMessage() {
		
	}
	
	/**
	 * Instantiates a new private message.
	 *
	 * @param user the user
	 */
	public PrivateMessage(User user) {
		this.receiver = user;
	}

	/**
	 * Gets the receiver.
	 *
	 * @return the receiver
	 */
	public User getReceiver() {
		return receiver;
	}

	/**
	 * Sets the receiver.
	 *
	 * @param receiver the receiver to set
	 */
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

}
