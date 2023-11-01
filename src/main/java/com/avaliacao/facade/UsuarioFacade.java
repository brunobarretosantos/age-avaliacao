package com.avaliacao.facade;

import com.avaliacao.dao.UsuarioDAO;
import com.avaliacao.model.CadastroUsuarioModel;
import com.avaliacao.model.ConsultaUsuariosModel;
import com.avaliacao.model.Usuario;

import java.util.List;

public class UsuarioFacade {
    private final UsuarioDAO usuarioDAO;

    public UsuarioFacade() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public boolean cadastrarUsuario(CadastroUsuarioModel model) {
        return usuarioDAO.inserirUsuario(model.makeUsuario(true));
    }
    
    public Usuario autenticar(String login, String password) throws Exception {
    	Usuario usuario = new Usuario();
    	usuario.setNmLogin(login);
    	usuario.setDsSenha(password);
    	
    	return autenticar(usuario);
    }

    public Usuario autenticar(Usuario usuario) throws Exception { 
        Usuario dbUsuario = usuarioDAO.getByLogin(usuario.getNmLogin());

        if (dbUsuario != null && dbUsuario.getEncryptedPassword().equals(usuario.getEncryptedPassword())) {
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

    public boolean alterarUsuario(CadastroUsuarioModel model) {    	    
        return usuarioDAO.alterarUsuario(model.makeUsuario(false));
    }

    public boolean excluirUsuario(String nmLogin) {
        return usuarioDAO.excluirUsuario(nmLogin);
    }

    public boolean hasUsuarios() {
        return usuarioDAO.hasUsuarios();
    }

	public Usuario carregarUsuario(String nmLogin) {
		return usuarioDAO.getByLogin(nmLogin);
	}
}
