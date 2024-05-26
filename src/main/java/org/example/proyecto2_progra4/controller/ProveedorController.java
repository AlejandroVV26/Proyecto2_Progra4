package org.example.proyecto2_progra4.controller;

import org.example.proyecto2_progra4.data.ProveedorRepository;
import org.example.proyecto2_progra4.logic.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorRepository proveedorRepository;

    @PostMapping("/agregar")
    public ResponseEntity<Void> addProveedor(Proveedor prov){
        try{
            proveedorRepository.create(prov);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            throw new RuntimeException("Error al agregar proveedor",e);
        }
    }

    @PutMapping("/editar")
    public ResponseEntity<Void> updateProv(Proveedor prov){
        try{
            proveedorRepository.update(prov);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            throw new RuntimeException("Error al actualizar datos del proveedor",e);
        }
    }
}


