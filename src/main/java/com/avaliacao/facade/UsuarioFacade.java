package com.avaliacao.facade;

import com.avaliacao.dao.UsuarioDAO;
import com.avaliacao.model.ConsultaUsuariosModel;
import com.avaliacao.model.Usuario;

import java.util.List;

public class UsuarioFacade {
    private final UsuarioDAO usuarioDAO;

    public UsuarioFacade() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarioDAO.inserirUsuario(usuario);
    }

    public Usuario autenticar(String nmLogin, String encryptedPassword) throws Exception { 
        Usuario usuario = usuarioDAO.getByLogin(nmLogin);

        if (usuario != null && usuario.getEncryptedPassword().equals(encryptedPassword)) {
            return usuario;
        }

        return null;
    }

    public List<Usuario> listarUsuarios(ConsultaUsuariosModel model) {
        return usuarioDAO.listarUsuarios(
                model.getPaginaAtual(),
                model.getRegistrosPorPagina(),
                model.getNmLogin(),
                model.getNmRole()
        );
    }

    public int getTotalPaginas(ConsultaUsuariosModel model) {
        int totalRegistros = usuarioDAO.contarUsuarios(
        		model.getNmLogin(), 
        		model.getNmRole());

        return (int) Math.ceil((double) totalRegistros / model.getRegistrosPorPagina());
    }

    public boolean alterarUsuario(Usuario usuario) {
        return usuarioDAO.alterarUsuario(usuario);
    }

    public boolean excluirUsuario(String nmLogin) {
        return usuarioDAO.excluirUsuario(nmLogin);
    }

    public boolean hasUsuarios() {
        return usuarioDAO.hasUsuarios();
    }
}
