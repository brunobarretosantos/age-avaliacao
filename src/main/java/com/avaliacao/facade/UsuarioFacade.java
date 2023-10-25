package com.avaliacao.facade;

import com.avaliacao.dao.UsuarioDAO;
import com.avaliacao.model.Usuario;
import com.avaliacao.services.UsuarioService;

public class UsuarioFacade {
    private final UsuarioService usuarioService;
    private UsuarioDAO usuarioDAO;

    public UsuarioFacade() {
        this.usuarioService = new UsuarioService();
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarioService.cadastrarUsuario(usuario);
    }
    
    public Usuario autenticar(String nmLogin, String encryptedPassword) throws Exception { 
        Usuario usuario = usuarioDAO.getByLogin(nmLogin);

        if (usuario != null && usuario.getEncryptedPassword().equals(encryptedPassword)) {
            return usuario;
        }

        return null;
    }
}
