package com.avaliacao.services;

import com.avaliacao.model.Usuario;
import com.avaliacao.dao.UsuarioDAO;

public class UsuarioService {

    public void cadastrarUsuario(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.inserirUsuario(usuario);
    }
}
