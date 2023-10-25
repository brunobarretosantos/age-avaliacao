package com.avaliacao.actions;

import java.util.logging.Logger;

import com.avaliacao.facade.UsuarioFacade;
import com.avaliacao.model.Usuario;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LoginAction.class.getName());
	
	private Usuario usuario;
    private UsuarioFacade usuarioFacade;
    
    public Usuario getUsuario() {
    	return usuario;
    }
    
	public LoginAction() {
    	logger.info("LoginAction");
    	    	    	
        this.usuario = new Usuario();
        this.usuarioFacade = new UsuarioFacade();
    } 
	
	public String loginForm() {
		logger.info("loginForm.input");
		return INPUT;		
	}

	@Override
	public String execute() {
		try {		
			logger.info("execute.validacao");
			if (usuario.getNmLogin() == null || usuario.getNmLogin().trim().isEmpty()) {
				addActionError("Informe o login");				
				return ERROR;
	        }			
			
			logger.info("execute.autenticacao");
            Usuario usuarioAutenticado = usuarioFacade.autenticar(usuario.getNmLogin(), usuario.getEncryptedPassword());

            if (usuarioAutenticado != null) {
            	logger.info("execute.usuarioAutenticado");
            	
                return SUCCESS;
            } else {

                addActionError("Usuário ou senha inválidos");
                return ERROR;
            }

        } catch (IllegalArgumentException e) {
        	addActionError(e.getMessage());
    		return ERROR;
    		
		} catch (Exception e) {
            e.printStackTrace();
            addActionError("Usuário ou senha inválidos");
            return ERROR;
        }
	}
}