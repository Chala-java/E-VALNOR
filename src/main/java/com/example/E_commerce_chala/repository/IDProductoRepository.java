package com.example.E_commerce_chala.repository;

import com.example.E_commerce_chala.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDProductoRepository extends JpaRepository <Producto,Integer> {

}
