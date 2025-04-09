package com.example.E_commerce_chala.services;

import com.example.E_commerce_chala.models.Orden;
import com.example.E_commerce_chala.repository.IDOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenServices {

    @Autowired
    IDOrdenRepository repository;

    public Orden guardarOrden(Orden orden) throws Exception {
        try {
            return this.repository.save(orden);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Orden> buscarTodas() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Orden buscarPorId(Integer id) throws Exception {
        try {
            Optional<Orden> buscar = this.repository.findById(id);
            if (buscar.isPresent()) {
                return buscar.get();
            } else {
                throw new Exception("Orden no encontrada");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Orden modificarPorId(Integer id, Orden datos) throws Exception {
        try {
            Optional<Orden> buscar = this.repository.findById(id);
            if (buscar.isPresent()) {
                Orden existente = buscar.get();
                existente.setFecha(datos.getFecha());
                existente.setUsuario(datos.getUsuario());
                existente.setTotal(datos.getTotal());
                return this.repository.save(existente);
            } else {
                throw new Exception("Orden no encontrada");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean eliminarOrden(Integer id) throws Exception {
        try {
            Optional<Orden> buscar = this.repository.findById(id);
            if (buscar.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("Orden no encontrada");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
