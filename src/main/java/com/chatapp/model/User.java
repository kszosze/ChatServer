package com.chatapp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/**
 * The Class User.
 */
@Entity
public class User implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8368680567529945864L;

	/** The id. */
	@Id
	@GeneratedValue
	private Integer id;
	
	/** The uuid. */
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String uuid;
	
	/** The name. */
	private String name;
	
	/** The user name. */
	private String userName;
	
	/** The last connection. */
	private Timestamp lastConnection;
	
	/** The active. */
	private Boolean active;

	/** The room list. */
	@ManyToMany
	@JoinTable(name="room_member", joinColumns = @JoinColumn(name = "room_id"), 
	   inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<Room> roomList = new ArrayList<>();
	
	/** The message list. */
	@OneToMany(mappedBy="sender")
	private List<Message> messageList = new ArrayList<>(); 
	
	/** The private msg list. */
	@OneToMany(mappedBy="receiver")
	private List<PrivateMessage> privateMsgList = new ArrayList<>();
	
	/**
	 * Instantiates a new user.
	 */
	public User()
	{}
	
	/**
	 * Instantiates a new user.
	 *
	 * @param name the name
	 * @param userName the user name
	 */
	public User(String name, String userName) {
		super();
		this.name = name;
		this.userName = userName;
		this.active = true;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the uuid.
	 *
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Sets the uuid.
	 *
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * Gets the room list.
	 *
	 * @return the roomList
	 */
	public List<Room> getRoomList() {
		return roomList;
	}

	/**
	 * Sets the room list.
	 *
	 * @param roomList the roomList to set
	 */
	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	/**
	 * Gets the message list.
	 *
	 * @return the messageList
	 */
	public List<Message> getMessageList() {
		return messageList;
	}

	/**
	 * Sets the message list.
	 *
	 * @param messageList the messageList to set
	 */
	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	/**
	 * Gets the last connection.
	 *
	 * @return the lastConnection
	 */
	public Timestamp getLastConnection() {
		return lastConnection;
	}

	/**
	 * Sets the last connection.
	 *
	 * @param lastConnection the lastConnection to set
	 */
	public void setLastConnection(Timestamp lastConnection) {
		this.lastConnection = lastConnection;
	}

	/**
	 * Gets the active.
	 *
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userName=" + userName
				+ "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	
}
