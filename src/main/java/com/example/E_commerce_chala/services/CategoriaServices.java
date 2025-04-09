package com.example.E_commerce_chala.services;

import com.example.E_commerce_chala.models.Categoria;
import com.example.E_commerce_chala.repository.IDCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class CategoriaServices {

    @Autowired
    IDCategoriaRepository repository;

    public Categoria guardarCategoria(Categoria categoria) throws Exception {
        try {
            return this.repository.save(categoria);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Categoria> buscarTodas() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Categoria buscarPorId(Integer id) throws Exception {
        try {
            Optional<Categoria> buscar = this.repository.findById(id);
            if (buscar.isPresent()) {
                return buscar.get();
            } else {
                throw new Exception("Categoría no encontrada");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Categoria modificarPorId(Integer id, Categoria datos) throws Exception {
        try {
            Optional<Categoria> buscar = this.repository.findById(id);
            if (buscar.isPresent()) {
                Categoria existente = buscar.get();
                existente.setNombre(datos.getNombre());
                return this.repository.save(existente);
            } else {
                throw new Exception("Categoría no encontrada");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean eliminarCategoria(Integer id) throws Exception {
        try {
            Optional<Categoria> buscar = this.repository.findById(id);
            if (buscar.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("Categoría no encontrada");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
