package com.example.grupSC.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Iterable<Cliente> getClientes(){
        return clienteRepository.findAll();
    }


    public Optional<Cliente> getCliente(Long id){
        return clienteRepository.findById(id);
    }

    public Optional<Iterable<Cliente>> getClienteByRazaoSocial(String razaoSocial){
        return clienteRepository.findByRazaoSocial(razaoSocial);
    }



    public Iterable<Cliente> getClienteByCnpj(String cnpj){

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

        Assert.notNull(cliente.getId(),"Nao foi possivel registrar o registro");

        Optional<Cliente> c = clienteRepository.findById(cliente.getId());

        if (c.isPresent()){
            Cliente cliente1 = c.get();
            cliente1.setUsuario(cliente.getUsuario());
            cliente1.setRazaoSocial(cliente.getRazaoSocial());
            cliente1.setCnpj(cliente.getCnpj());
            cliente1.setStatus(cliente.getStatus());
            cliente1.setSenha(cliente.getSenha());
            clienteRepository.save(cliente);
        }else {
            throw  new RuntimeException("Nao foi possivel atualizar o cliente");
        }
    }

}
