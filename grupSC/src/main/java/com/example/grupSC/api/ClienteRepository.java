package com.example.grupSC.api;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
       Iterable<Cliente> findByCnpj(String cnpj);
       Optional<Iterable<Cliente>> findByRazaoSocial(String razaoSocial);

}
