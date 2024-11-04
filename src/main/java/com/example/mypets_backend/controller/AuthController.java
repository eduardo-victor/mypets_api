package com.example.mypets_backend.controller;

import com.example.mypets_backend.models.AuthResponse;
import com.example.mypets_backend.models.Usuario;
import com.example.mypets_backend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody Usuario usuario) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha())
            );
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Usuário ou senha incorretos");
        }

        // Carrega os detalhes do usuário
        UserDetails userDetails = userDetailsService.loadUserByUsername(usuario.getEmail());

        // Gera o token JWT
        String jwt = jwtUtil.generateToken(userDetails.getUsername());

        // Retorna a resposta com o token
        return new AuthResponse(jwt);
    }
}
