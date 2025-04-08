package com.example.E_commerce_chala.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Producto_Table")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer id_Producto;
    @Column(name = "producto_nombre", length = 150, nullable = false)
    private String producto_nombre;
    @Column(name = "producto_marca", length = 100, nullable = false)
    private String producto_marca;
    @Column(name = "producto_descripcion",nullable = true)
    private String producto_descripcion;
    @Column(name = "producto_precio", nullable = false)
    private BigDecimal producto_precio;

    @Column(name = "producto_categoria",length = 150, nullable = false)
    private String producto_categoria;
    @Column(name = "producto_imagen",nullable = false)
    private String producto_imagen; // URL de la imagen
    @Column(name = "producto_cantidad",nullable = false)
    private BigDecimal producto_cantidad;
    @Column(name = "producto_fecha", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime producto_fecha;

    public Producto(){


    }

    public Producto(Integer id_Producto, String producto_nombre, String producto_marca, String producto_descripcion, BigDecimal producto_precio, String producto_categoria, String producto_imagen, BigDecimal producto_cantidad, LocalDateTime producto_fecha) {
        this.id_Producto = id_Producto;
        this.producto_nombre = producto_nombre;
        this.producto_marca = producto_marca;
        this.producto_descripcion = producto_descripcion;
        this.producto_precio = producto_precio;
        this.producto_categoria = producto_categoria;
        this.producto_imagen = producto_imagen;
        this.producto_cantidad = producto_cantidad;
        this.producto_fecha = producto_fecha;
    }

    public Integer getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(Integer id_Producto) {
        this.id_Producto = id_Producto;
    }

    public String getProducto_nombre() {
        return producto_nombre;
    }

    public void setProducto_nombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }

    public String getProducto_marca() {
        return producto_marca;
    }

    public void setProducto_marca(String producto_marca) {
        this.producto_marca = producto_marca;
    }

    public String getProducto_descripcion() {
        return producto_descripcion;
    }

    public void setProducto_descripcion(String producto_descripcion) {
        this.producto_descripcion = producto_descripcion;
    }

    public BigDecimal getProducto_precio() {
        return producto_precio;
    }

    public void setProducto_precio(BigDecimal producto_precio) {
        this.producto_precio = producto_precio;
    }

    public String getProducto_categoria() {
        return producto_categoria;
    }

    public void setProducto_categoria(String producto_categoria) {
        this.producto_categoria = producto_categoria;
    }

    public String getProducto_imagen() {
        return producto_imagen;
    }

    public void setProducto_imagen(String producto_imagen) {
        this.producto_imagen = producto_imagen;
    }

    public BigDecimal getProducto_cantidad() {
        return producto_cantidad;
    }

    public void setProducto_cantidad(BigDecimal producto_cantidad) {
        this.producto_cantidad = producto_cantidad;
    }

    public LocalDateTime getProducto_fecha() {
        return producto_fecha;
    }

    public void setProducto_fecha(LocalDateTime producto_fecha) {
        this.producto_fecha = producto_fecha;
    }
}
