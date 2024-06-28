package com.example.grupSC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grupSC.entities.Cliente;

import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Cliente,Long> {
    Optional<Cliente> findByUsuario(String usuario);
}
