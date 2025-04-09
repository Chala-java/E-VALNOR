package com.example.E_commerce_chala.controller;

import com.example.E_commerce_chala.models.Direccion;
import com.example.E_commerce_chala.services.DireccionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/direcciones")
public class ControllerDireccion {

    @Autowired
    DireccionServices direccionService;

    @PostMapping
    public ResponseEntity<?> crearDireccion(@RequestBody Direccion direccion) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(direccionService.guardarDireccion(direccion));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarDirecciones() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(direccionService.buscarTodas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(direccionService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Direccion direccion) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(direccionService.modificarPorId(id, direccion));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(direccionService.eliminarDireccion(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
