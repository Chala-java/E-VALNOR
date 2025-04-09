package com.example.E_commerce_chala.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "Table_Producto_Carrito")
public class ProductoCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal cantidad;

    @ManyToOne
    @JoinColumn(name = "carrito_id")
    @JsonBackReference
    private Carrito carritos;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto productos;

    public ProductoCarrito (){

    }

    public ProductoCarrito(Integer id, BigDecimal cantidad, Carrito carritos, Producto productos) {
        this.id = id;
        this.cantidad = cantidad;
        this.carritos = carritos;
        this.productos = productos;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Carrito getCarritos() {
        return carritos;
    }

    public void setCarritos(Carrito carritos) {
        this.carritos = carritos;
    }

    public Producto getProductos() {
        return productos;
    }

    public void setProductos(Producto productos) {
        this.productos = productos;
    }
}
