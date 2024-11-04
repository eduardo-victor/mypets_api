package com.example.mypets_backend.repository;

import com.example.mypets_backend.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PetRepository extends JpaRepository<Pet, UUID> {

}
