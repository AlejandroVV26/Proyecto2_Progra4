package org.example.proyecto2_progra4.controller;

import org.example.proyecto2_progra4.data.dto.RegisterFromDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {
    @RequestMapping("/")
    public String levantarPaginaPrincipal() {
        return "index.html";
    }

    @PostMapping("/registrarse")
    private ResponseEntity<Void> registrarse(@RequestBody RegisterFromDto register) {
        return ResponseEntity.ok().build();
    }
}
