package com.example.E_commerce_chala.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "table_direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Integer idDireccion;

    @Column(name = "ciudad", length = 100, nullable = false)
    private String ciudad;

    @Column(name = "direccion", length = 200, nullable = false)
    private String direccion;

    @Column(name = "departamento", length = 100, nullable = false)
    private String departamento;

    @Column(name = "telefono", length = 100, nullable = false)
    private String telefono;

    @Column(name = "codigo_postal", length = 100, nullable = false)
    private String codigoPostal;

    @Column(name = "pais", length = 100, nullable = false)
    private String pais;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonBackReference
    private Usuario usuario;

    public Direccion() {
    }

    public Direccion(Integer idDireccion, String ciudad, String direccion, String departamento, String telefono, String codigoPostal, String pais) {
        this.idDireccion = idDireccion;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.departamento = departamento;
        this.telefono = telefono;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
