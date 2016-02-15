/*
 * 
 */
package com.chatapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatapp.model.Room;
import com.chatapp.model.User;
import com.chatapp.repository.RoomRepository;
import com.chatapp.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Room save(Room room) {
		return roomRepository.save(room);
	}

	@Override
	public List<Room> findAll() {	
		return roomRepository.findAll();
	}

	@Override
	public List<Room> findAllByUser(User user) {
		final List<Room> roomList = new ArrayList<>();
		try (Stream<Room> roomStream = roomRepository.findAll().stream())
		{
			roomStream.filter(p -> p.getMemberList().contains(user)).forEach(p -> roomList.add(p));
		}
		return roomList;
	}

	@Override
	public Room findByName(String room) {
		return roomRepository.findByName(room);
	}

}
