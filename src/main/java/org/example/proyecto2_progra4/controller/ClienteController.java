package org.example.proyecto2_progra4.controller;

import org.example.proyecto2_progra4.data.ClienteRepository;
import org.example.proyecto2_progra4.logic.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/{proveedorId}")
    public ResponseEntity<List<Cliente>> getProvClients(@PathVariable("proveedorId") String provId) {
        try {
            List<Cliente> list = clienteRepository.getAllClientsByProvId(provId);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable("id") String id, @RequestParam("proveedorId") String provId) {
        Cliente client = clienteRepository.readById(id, provId);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/agregar/{proveedorId}")
    public ResponseEntity<Void> addClient(Cliente client, @PathVariable("proveedorId") String provId) {
        try {
            clienteRepository.createClient(client, provId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar cliente", e);
        }
    }
}
