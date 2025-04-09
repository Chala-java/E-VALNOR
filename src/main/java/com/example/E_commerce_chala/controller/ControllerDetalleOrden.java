package com.example.E_commerce_chala.controller;

import com.example.E_commerce_chala.models.DetalleOrden;
import com.example.E_commerce_chala.services.DetalleOrdenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detalles")
public class ControllerDetalleOrden {

    @Autowired
    DetalleOrdenServices detalleOrdenService;

    @PostMapping
    public ResponseEntity<?> crearDetalle(@RequestBody DetalleOrden detalle) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(detalleOrdenService.guardarDetalle(detalle));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarDetalles() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(detalleOrdenService.buscarTodos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(detalleOrdenService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody DetalleOrden detalle) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(detalleOrdenService.modificarPorId(id, detalle));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(detalleOrdenService.eliminarDetalle(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
