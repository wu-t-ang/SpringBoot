package com.example.projetangularspring.control;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetangularspring.entity.Room;

import com.example.projetangularspring.service.RoomServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/room")
public class RoomController {
	@Autowired
	RoomServiceImpl roomService;
	@GetMapping("/{room-id}")
	
	public Room get_room(@PathVariable("room-id") String id_Room) {
		return roomService.get_room(id_Room);
	}
	@GetMapping("")
	
	public List<Room> list_all_room() {
		
		return roomService.list_all_room();
	}
	
	@GetMapping("/top")	
public List<Room> list_top_room() {
		return roomService.list_top_room();
	}
	
	@PutMapping("/reserver/{id}/{uid}")
	@PreAuthorize("hasRole('USER')")
	public Boolean reserver_room(@PathVariable("id") String id_Room , @PathVariable("uid") String id_User ) {


return roomService.reserver_room(id_Room, id_User);
	}

	@PostMapping("")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public Room ajouter_Room(@Valid @RequestBody Room room)
	{
		roomService.ajouter_Room(room);
		return room;
	}
	
	@GetMapping("/user/{uid}")	
	public List<Room> list_all_room_by_user(@PathVariable("uid") String id_User) {
		return roomService.list_all_room_by_user(id_User);
	}
	
	@DeleteMapping("/{room-id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public Boolean delete_room(@PathVariable("room-id") String id_Room) {
		roomService.delete_room(id_Room);
		return true;
	}
}
