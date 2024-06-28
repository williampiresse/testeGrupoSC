package com.example.grupSC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.grupSC.entities.Cliente;
import com.example.grupSC.services.ClienteService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping()
    public ResponseEntity<Iterable<Cliente>> getAll(){
        var list = service.getClientes();
        return  new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Cliente>> get(@PathVariable("id") Long id){
        var usuario = service.getCliente(id);
        return  new ResponseEntity<>(usuario,HttpStatus.OK);
    }

    @GetMapping("/cnpj/{cnpj}")
    public Iterable<Cliente> getClienteByAllCnpj(@PathVariable("cnpj") String cnpj){
        var response = service.getClienteByCnpj(cnpj);
        return response;
    }

    @GetMapping("/razao-social/{razao-social}")
    public Iterable<Cliente> getClienteByRazaoSocial(@PathVariable("razao-social") String razaoSocial){
    
        var s = service.getClienteByRazaoSocial(razaoSocial);
        if (s.isPresent()) {
            return s.get();
        }
        return  new ArrayList<>();
    }

    @PutMapping("/salve")
    public String update(@RequestBody Cliente cliente){
        service.update(cliente);
        return  "salvo...";
    }

    @PostMapping()
    public String save(@RequestBody Cliente cliente){
        service.create(cliente);
        return  "criado com sucesso...";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id){
        System.out.print("aqui...");
        service.delete(id);
        return  "Cliente deletado com sucesso!!!";
    }


}
