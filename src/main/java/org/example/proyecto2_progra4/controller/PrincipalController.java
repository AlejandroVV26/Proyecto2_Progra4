package org.example.proyecto2_progra4.controller;

import jakarta.websocket.server.PathParam;
import org.example.proyecto2_progra4.data.ProveedorRepository;
import org.example.proyecto2_progra4.data.UsuarioRepository;
import org.example.proyecto2_progra4.logic.Proveedor;
import org.example.proyecto2_progra4.logic.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/registrarse")
    public ResponseEntity<Void> register(@PathParam("nombre") String name, @PathParam("apellidos")String lastName, @PathParam("telefono")String phone, @PathParam("email")String email, @PathParam("cedula")String id, @PathParam("contrasena")String password, @PathParam("direccion")String address){
        Usuario user = new Usuario(id.trim(), password.trim(), "Proveedor");
        Proveedor prov = new Proveedor(id.trim(), name, lastName, phone, email, user);
        try{
            if (proveedorRepository.stubRegistered(id.trim())){
                usuarioRepository.createUser(user);
                proveedorRepository.create(prov);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestParam("id")String id, @RequestParam("password")String password){
        try{
            Usuario user = usuarioRepository.login(id, password);
            if (user.isAccess()){
                Proveedor prov = proveedorRepository.readById(user.getId());
                return ResponseEntity.ok().body(prov);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Proveedor No Tiene Acceso");
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al autenticar al Usuario: "+e.getMessage());
        }
    }

    @PutMapping("/giveAccess/{id}")
    public ResponseEntity<Void>giveAccess(@PathVariable("id")String id){
        try{
            usuarioRepository.updateAccessTrue(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/revokeAccess/{id}")
    public ResponseEntity<Void>revokeAccess(@PathVariable("id")String id){
        try{
            usuarioRepository.updateAccessFalse(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
