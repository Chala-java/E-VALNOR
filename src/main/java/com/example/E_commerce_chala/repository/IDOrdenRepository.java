package com.example.E_commerce_chala.repository;

import com.example.E_commerce_chala.models.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDOrdenRepository extends JpaRepository<Orden,Integer> {
}
