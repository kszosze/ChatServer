/**
 * 
 */
package com.chatapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * The Class Room.
 */
@Entity
public class Room implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6796577926452158269L;

	/** The id. */
	@Id
	@GeneratedValue
	private Integer id;
	
	/** The name. */
	private String name;
	
	/** The member list. */
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="room_member", joinColumns = @JoinColumn(name = "room_id"), 
			   inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> memberList = new ArrayList<>();
	
	/** The messages list. */
	@OneToMany(mappedBy="room",fetch=FetchType.EAGER)
	private List<PublicMessage> messagesList = new ArrayList<>();
	
	/**
	 * Instantiates a new room.
	 */
	public Room() {
		
	}
	
	/**
	 * Instantiates a new room.
	 *
	 * @param roomName the room name
	 */
	public Room(String roomName) {
		this.name = roomName;
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
	 * Gets the member list.
	 *
	 * @return the memberList
	 */
	public List<User> getMemberList() {
		return memberList;
	}
	
	/**
	 * Sets the member list.
	 *
	 * @param memberList the memberList to set
	 */
	public void setMemberList(List<User> memberList) {
		this.memberList = memberList;
	}
	
	/**
	 * Gets the messages list.
	 *
	 * @return the messagesList
	 */
	public List<PublicMessage> getMessagesList() {
		return messagesList;
	}
	
	/**
	 * Sets the messages list.
	 *
	 * @param messagesList the messagesList to set
	 */
	public void setMessagesList(List<PublicMessage> messagesList) {
		this.messagesList = messagesList;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + "]";
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
		Room other = (Room) obj;
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
		return true;
	}

}
