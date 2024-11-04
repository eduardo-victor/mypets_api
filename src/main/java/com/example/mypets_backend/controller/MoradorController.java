package com.example.mypets_backend.controller;

import com.example.mypets_backend.models.Morador;
import com.example.mypets_backend.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    @Autowired
    private MoradorRepository moradorRepository;

    @PostMapping("/cadastrar")
    public Morador cadastrarMorador(@RequestBody Morador morador) {
        return moradorRepository.save(morador);
    }

    @GetMapping
    public List<Morador> listarMoradores() {
        return moradorRepository.findAll();
    }
}
