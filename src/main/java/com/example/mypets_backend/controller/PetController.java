package com.example.mypets_backend.controller;

import com.example.mypets_backend.models.Pet;
import com.example.mypets_backend.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @PostMapping("/cadastrar")
    public Pet cadastrarPet(@RequestBody Pet pet) {
        return petRepository.save(pet);
    }

    @GetMapping
    public List<Pet> listarPets() {
        return petRepository.findAll();
    }
}
