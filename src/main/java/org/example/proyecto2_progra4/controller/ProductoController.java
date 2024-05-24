package org.example.proyecto2_progra4.controller;

import org.example.proyecto2_progra4.data.ProductoRepository;
import org.example.proyecto2_progra4.logic.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/productos"})
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/{proveedorId}")
    public ResponseEntity<List<Producto>> getProvProducts(@PathVariable("proveedorId")String provId){
        try{
            List<Producto> list = productoRepository.getAllProductsByProvId(provId);
            return ResponseEntity.ok(list);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id")String id, @RequestParam("proveedorId")String provId){
        Producto product = productoRepository.readById(id, provId); // HACER UN GET ALL PRODUCTOS POR PROVEEDOR
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{descripcion}")
    public ResponseEntity<Producto> getByDescription(@PathVariable("descripcion")String desc){
        Producto product = productoRepository.readByDescription(desc);
        return ResponseEntity.ok(product);
    }

//    @PostMapping("/agregar")
//    public ResponseEntity<Void> addProduct(){
//
//    }

//    @PutMapping("/edit/{id}")
//    public ResponseEntity<Void> editProductById(@PathVariable("id")String id, @RequestParam("")){
//        Producto product = productoRepository.readById(id);
//
//    }
}
