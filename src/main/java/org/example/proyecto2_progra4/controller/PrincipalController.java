package org.example.proyecto2_progra4.controller;

import jakarta.websocket.server.PathParam;
import org.example.proyecto2_progra4.data.ProveedorRepository;
import org.example.proyecto2_progra4.data.UsuarioRepository;
import org.example.proyecto2_progra4.data.dto.RegisterFromDto;
import org.example.proyecto2_progra4.logic.Proveedor;
import org.example.proyecto2_progra4.logic.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ProveedorRepository proveedorRepository;
    @RequestMapping("/")
    public String levantarPaginaPrincipal() {
        return "index.html";
    }

//    @PostMapping("/registrarse")
//    private ResponseEntity<Void> registrarse(@RequestBody RegisterFromDto register) {
//        return ResponseEntity.ok().build();
//    }

    @PostMapping("/registrarse")
    public ResponseEntity<Void> register(@PathParam("nombre") String name, @PathParam("apellidos")String lastName, @PathParam("telefono")String phone, @PathParam("email")String email, @PathParam("cedula")String id, @PathParam("contrasena")String password, @PathParam("direccion")String address){
        Usuario user = new Usuario(id.trim(), password.trim(), "Proveedor");
        Proveedor prov = new Proveedor(id.trim(), name, lastName, phone, email, user);
        try{
            usuarioRepository.createUser(user);
            proveedorRepository.create(prov);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
