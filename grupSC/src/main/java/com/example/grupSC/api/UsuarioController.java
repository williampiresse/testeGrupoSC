package com.example.grupSC.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/login")
    public Boolean login(@RequestBody Usuario usuario){
        return service.login(usuario);
    }
    @PostMapping("/save")
    public String save(@RequestBody Usuario usuario){
        return service.save(usuario);
    }


}
