package org.example.proyecto2_progra4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {
    @RequestMapping("/")
    public String levantarPaginaPrincipal() {
        return "index.html";
    }
}
