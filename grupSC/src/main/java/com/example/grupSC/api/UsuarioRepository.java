package com.example.grupSC.api;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Cliente,Long> {
    Optional<Cliente> findByUsuario(String usuario);
}
