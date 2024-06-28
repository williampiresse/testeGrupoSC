package com.example.grupSC.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Boolean login(Usuario usuario){
        var user = usuarioRepository.findByUsuario(usuario.getUsuario());
        return user.get().getSenha().equals(usuario.getSenha());
    }

    public String save(Usuario usuario){
        var c = new Cliente(
        usuario.getUsuario(),usuario.getSenha()
        );
        var user = usuarioRepository.save(c);
        return "cadastrado com sucesso...";
    }
}
