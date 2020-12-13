package com.example.projetangularspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.projetangularspring.entity.Room;
import com.example.projetangularspring.entity.User;
import com.example.projetangularspring.repository.RoomRepository;
import com.example.projetangularspring.repository.UserRepository;





@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	UserRepository userRepository;
	@Override
	public Room ajouter_Room(Room room) {
		roomRepository.save(room);
		return room;
	}

	@Override
	public Boolean delete_room(String id_Room) {
		Room room = roomRepository.findById(id_Room).get();
		roomRepository.delete(room);
		return true;
	}

	@Override
	public List<Room> list_all_room() {
	
		return roomRepository.findAll();
	}

	@Override
	public List<Room> list_top_room() {
		
		Sort sort = Sort.by(Sort.Direction.DESC,"prix_room"); 
	
		return 	roomRepository.findAll(sort).subList(0, 3);
	}

	@Override
	public Boolean reserver_room(String id_Room, String id_User) {
		

		User user = userRepository.findById(id_User).get();
		Room room = roomRepository.findById(id_Room).get();
		room.setEtat("reserve");
		room.setUsers(user);

		roomRepository.save(room);
		
		return true;
	}

	@Override
	public Room get_room(String id_Room) {
		Room room = roomRepository.findById(id_Room).get();
		return room;
	}
	
	@Override
	public List<Room> list_all_room_by_user(String id_user) {
		
		List<Room> list = roomRepository.findAll();
		List<Room> listnew = new ArrayList<>();
		User user = userRepository.findById(id_user).get();

		System.out.println(listnew.size());
		
		for (Room room : list)
		{
			if (room.getUsers().equals(user))
			listnew.add(room);
		}


		
		return listnew;
	}


}
