package org.example.proyecto2_progra4.controller;

import org.example.proyecto2_progra4.data.ClienteRepository;
import org.example.proyecto2_progra4.data.FacturaRepository;
import org.example.proyecto2_progra4.logic.Cliente;
import org.example.proyecto2_progra4.logic.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class FacturaController {
    @Autowired
    private FacturaRepository facturaRepository;

    @GetMapping("/{proveedorId}")
    public ResponseEntity<List<Factura>> getProvFactura(@PathVariable("proveedorId") String provId) {
        try {
            List<Factura> list = facturaRepository.readByProveedor(provId);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/agregar")
    public ResponseEntity<Void> agregarFactura(Factura factura) {
        try {
            facturaRepository.create(factura);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar factura", e);
        }
    }
}
