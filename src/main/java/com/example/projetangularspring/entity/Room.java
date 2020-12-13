package com.example.projetangularspring.entity;



import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "rooms")
public class Room {
	@Id
	private String id;
	

	private String num_room;

	private float prix_room;
	private Type_Room type;
	
	private String nom_Image;
	
	private String Description;
	
	private String Etat;
	@DBRef
	private User users = new User();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNum_room() {
		return num_room;
	}
	public void setNum_room(String num_room) {
		this.num_room = num_room;
	}
	public float getPrix_room() {
		return prix_room;
	}
	public void setPrix_room(float prix_room) {
		this.prix_room = prix_room;
	}
	public Type_Room getType() {
		return type;
	}
	public void setType(Type_Room type) {
		this.type = type;
	}
	public String getNom_Image() {
		return nom_Image;
	}
	public void setNom_Image(String nom_Image) {
		this.nom_Image = nom_Image;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getEtat() {
		return Etat;
	}
	public void setEtat(String etat) {
		Etat = etat;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public Room(String id, @NotBlank String num_room, @NotBlank float prix_room, @NotBlank Type_Room type,
			String nom_Image, String description, String etat) {
		super();
		this.id = id;
		this.num_room = num_room;
		this.prix_room = prix_room;
		this.type = type;
		this.nom_Image = nom_Image;
		Description = description;
		Etat = etat;
	}
	public Room(@NotBlank String num_room, @NotBlank float prix_room, @NotBlank Type_Room type, String nom_Image,
			String description, String etat) {
		super();
		this.num_room = num_room;
		this.prix_room = prix_room;
		this.type = type;
		this.nom_Image = nom_Image;
		Description = description;
		Etat = etat;
	}
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
