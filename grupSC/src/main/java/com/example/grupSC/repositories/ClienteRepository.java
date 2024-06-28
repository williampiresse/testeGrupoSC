package com.example.grupSC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grupSC.entities.Cliente;

import java.util.Optional;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
       Iterable<Cliente> findByCnpj(String cnpj);
       Optional<Iterable<Cliente>> findByRazaoSocial(String razaoSocial);
}
