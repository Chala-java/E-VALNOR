package com.example.E_commerce_chala.services;

import com.example.E_commerce_chala.repository.IDProductoCarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoCarrito {

    @Autowired
    IDProductoCarritoRepository productoCarritoRepository;

    public com.example.E_commerce_chala.models.ProductoCarrito agregarProductoAlCarrito(com.example.E_commerce_chala.models.ProductoCarrito productoCarrito) throws Exception {
        try {
            return productoCarritoRepository.save(productoCarrito);
        } catch (Exception e) {
            throw new Exception("Error agregando producto al carrito: " + e.getMessage());
        }
    }

    public List<com.example.E_commerce_chala.models.ProductoCarrito> obtenerTodos() throws Exception {
        try {
            return productoCarritoRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error obteniendo productos del carrito: " + e.getMessage());
        }
    }

    public com.example.E_commerce_chala.models.ProductoCarrito buscarPorId(Integer id) throws Exception {
        try {
            Optional<com.example.E_commerce_chala.models.ProductoCarrito> buscar = productoCarritoRepository.findById(id);
            if (buscar.isPresent()) {
                return buscar.get();
            } else {
                throw new Exception("ProductoCarrito no encontrado");
            }
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    public com.example.E_commerce_chala.models.ProductoCarrito modificarPorId(Integer id, com.example.E_commerce_chala.models.ProductoCarrito datos) throws Exception {
        try {
            Optional<com.example.E_commerce_chala.models.ProductoCarrito> buscar = productoCarritoRepository.findById(id);
            if (buscar.isPresent()) {
                com.example.E_commerce_chala.models.ProductoCarrito existente = buscar.get();
                existente.setCarritos(datos.getCarritos());
                existente.setProductos(datos.getProductos());
                existente.setCantidad(datos.getCantidad());

                return productoCarritoRepository.save(existente);
            } else {
                throw new Exception("ProductoCarrito no encontrado para actualizar");
            }
        } catch (Exception e) {
            throw new Exception("Error actualizando ProductoCarrito: " + e.getMessage());
        }
    }

    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<com.example.E_commerce_chala.models.ProductoCarrito> buscar = productoCarritoRepository.findById(id);
            if (buscar.isPresent()) {
                productoCarritoRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("ProductoCarrito no encontrado para eliminar");
            }
        } catch (Exception e) {
            throw new Exception("Error eliminando ProductoCarrito: " + e.getMessage());
        }
    }
}
