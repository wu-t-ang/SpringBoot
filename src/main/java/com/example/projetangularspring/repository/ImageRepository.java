package com.example.projetangularspring.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.projetangularspring.entity.Image;


public interface ImageRepository extends MongoRepository<Image, String> {
	Optional<Image> findByName(String name);
}
