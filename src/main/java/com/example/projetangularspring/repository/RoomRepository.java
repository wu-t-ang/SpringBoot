package com.example.projetangularspring.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.projetangularspring.entity.Room;



public interface RoomRepository extends MongoRepository<Room, String> {

}
