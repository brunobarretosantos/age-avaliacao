package com.avaliacao.facade;

import com.avaliacao.model.Usuario;
import com.avaliacao.services.UsuarioService;

public class UsuarioFacade {
    private final UsuarioService usuarioService;

    public UsuarioFacade() {
        this.usuarioService = new UsuarioService();
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarioService.cadastrarUsuario(usuario);
    }
}
