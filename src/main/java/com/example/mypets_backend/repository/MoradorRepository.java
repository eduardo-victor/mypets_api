package com.example.mypets_backend.repository;

import com.example.mypets_backend.models.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MoradorRepository extends JpaRepository<Morador, UUID> {

}
