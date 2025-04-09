package com.example.E_commerce_chala.services;

import com.example.E_commerce_chala.models.Carrito;
import com.example.E_commerce_chala.repository.IDCarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoServices {

    @Autowired
    IDCarritoRepository carritoRepository;

    public Carrito crearCarrito(Carrito carrito) throws Exception {
        try {
            return carritoRepository.save(carrito);
        } catch (Exception e) {
            throw new Exception("Error creando el carrito: " + e.getMessage());
        }
    }

    public List<Carrito> buscarTodosLosCarritos() throws Exception {
        try {
            return carritoRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error buscando carritos: " + e.getMessage());
        }
    }

    public Carrito buscarCarritoPorId(Integer id) throws Exception {
        try {
            Optional<Carrito> buscar = carritoRepository.findById(id);
            if (buscar.isPresent()) {
                return buscar.get();
            } else {
                throw new Exception("Carrito no encontrado");
            }
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    public Carrito modificarCarritoPorId(Integer id, Carrito datos) throws Exception {
        try {
            Optional<Carrito> buscar = carritoRepository.findById(id);
            if (buscar.isPresent()) {
                Carrito carritoExistente = buscar.get();

                carritoExistente.setUsuario(datos.getUsuario());
                carritoExistente.setProductos(datos.getProductos()); // Aquí corregimos el nombre

                return carritoRepository.save(carritoExistente);
            } else {
                throw new Exception("Carrito no encontrado para actualizar");
            }
        } catch (Exception e) {
            throw new Exception("Error actualizando carrito: " + e.getMessage());
        }
    }

    public boolean eliminarCarrito(Integer id) throws Exception {
        try {
            Optional<Carrito> buscar = carritoRepository.findById(id);
            if (buscar.isPresent()) {
                carritoRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("Carrito no encontrado para eliminar");
            }
        } catch (Exception e) {
            throw new Exception("Error eliminando carrito: " + e.getMessage());
        }
    }
}
