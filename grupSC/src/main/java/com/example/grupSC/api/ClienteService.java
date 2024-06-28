package com.example.grupSC.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Iterable<Cliente> getClientes(){
        return clienteRepository.findAll();
    }
    public Optional<Iterable<Cliente>> getClienteByRazaoSocial(String razaoSocial){
        return clienteRepository.findByRazaoSocial(razaoSocial);
    }



    public Optional<Cliente> getClienteByCnpj(String cnpj){

        return clienteRepository.findByCnpj(cnpj);

    }

    public void delete(Long id){
            Optional<Cliente>cliente = clienteRepository.findById(id);
            if (cliente.isPresent()){
                clienteRepository.deleteById(id);

            }
    }

    public void create(Cliente cliente){
            clienteRepository.save(cliente);
    }


    public void update(Cliente cliente){
        Optional<Cliente> c = clienteRepository.findById(cliente.getId());
        if (c.isPresent()){
            clienteRepository.save(cliente);
        }else {
            throw  new RuntimeException("Nao foi possivel atualizar o cliente");
        }
    }

}
