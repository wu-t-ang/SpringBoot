package com.example.projetangularspring.service;

import java.util.List;

import com.example.projetangularspring.entity.Room;



public interface RoomService {
	
	public Room ajouter_Room(Room room);
	public Boolean delete_room(String id_Room);
	public  List<Room> list_all_room();
	public Room get_room(String id_Room);
	public  List<Room> list_top_room();
	public Boolean reserver_room(String id_Room, String id_User);
	public List<Room> list_all_room_by_user(String id_user);
}
