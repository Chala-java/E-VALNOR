package com.example.E_commerce_chala.services;

import com.example.E_commerce_chala.models.Direccion;
import com.example.E_commerce_chala.repository.IDDireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServices {

    @Autowired
    IDDireccionRepository repository;

    public Direccion guardarDireccion(Direccion direccion) throws Exception {
        try {
            return this.repository.save(direccion);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Direccion> buscarTodas() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Direccion buscarPorId(Integer id) throws Exception {
        try {
            Optional<Direccion> buscar = this.repository.findById(id);
            if (buscar.isPresent()) {
                return buscar.get();
            } else {
                throw new Exception("Dirección no encontrada");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Direccion modificarPorId(Integer id, Direccion datos) throws Exception {
        try {
            Optional<Direccion> buscar = this.repository.findById(id);
            if (buscar.isPresent()) {
                Direccion existente = buscar.get();
                existente.setCiudad(datos.getCiudad());
                existente.setDepartamento(datos.getDepartamento());
                existente.setDireccion(datos.getDireccion());
                existente.setTelefono(datos.getTelefono());
                existente.setCodigoPostal(datos.getCodigoPostal());
                existente.setPais(datos.getPais());
                return this.repository.save(existente);
            } else {
                throw new Exception("Dirección no encontrada");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean eliminarDireccion(Integer id) throws Exception {
        try {
            Optional<Direccion> buscar = this.repository.findById(id);
            if (buscar.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("Dirección no encontrada");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
