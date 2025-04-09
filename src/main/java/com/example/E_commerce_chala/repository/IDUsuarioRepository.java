package com.example.E_commerce_chala.repository;

import com.example.E_commerce_chala.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDUsuarioRepository extends JpaRepository<Usuario,Integer> {
}
