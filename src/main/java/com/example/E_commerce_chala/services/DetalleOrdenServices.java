package com.example.E_commerce_chala.services;

import com.example.E_commerce_chala.models.DetalleOrden;
import com.example.E_commerce_chala.repository.IDDetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleOrdenServices {

    @Autowired
    IDDetalleOrdenRepository repository;

    public DetalleOrden guardarDetalle(DetalleOrden detalle) throws Exception {
        try {
            return this.repository.save(detalle);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<DetalleOrden> buscarTodos() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public DetalleOrden buscarPorId(Integer id) throws Exception {
        try {
            Optional<DetalleOrden> buscar = this.repository.findById(id);
            if (buscar.isPresent()) {
                return buscar.get();
            } else {
                throw new Exception("Detalle no encontrado");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public DetalleOrden modificarPorId(Integer id, DetalleOrden datos) throws Exception {
        try {
            Optional<DetalleOrden> buscar = this.repository.findById(id);
            if (buscar.isPresent()) {
                DetalleOrden existente = buscar.get();
                existente.setCantidad(datos.getCantidad());
                existente.setSubtotal(datos.getSubtotal());
                existente.setPrecioUnitario(datos.getPrecioUnitario());
                existente.setProducto(datos.getProducto());
                existente.setOrden(datos.getOrden());
                return this.repository.save(existente);
            } else {
                throw new Exception("Detalle no encontrado");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean eliminarDetalle(Integer id) throws Exception {
        try {
            Optional<DetalleOrden> buscar = this.repository.findById(id);
            if (buscar.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("Detalle no encontrado");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
