package com.avaliacao.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.logging.Logger;

import com.avaliacao.facade.UsuarioFacade;
import com.avaliacao.model.Usuario;

public class UsuarioAdminAction extends ActionSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private static final Logger logger = Logger.getLogger(UsuarioAdminAction.class.getName());
	
	private Usuario usuario;
    private UsuarioFacade usuarioFacade;
    private String errorMessage;    
    private boolean registerAdmin; 

    public boolean isRegisterAdmin() {
        return registerAdmin;
    }    
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public Usuario getUsuario() {
    	return usuario;
    }

    public UsuarioAdminAction() {
    	logger.info("UsuarioAdminAction");
    	
    	registerAdmin = true;
    	errorMessage = null;
    	
        this.usuario = new Usuario();
        this.usuarioFacade = new UsuarioFacade();
    } 
    
    @Override
    public String execute() {
    	try {
			logger.info("cadastrarUsuarioAdmin");
			
			if (usuario == null) {
				logger.info("cadastrarUsuario.usuario.null");
				errorMessage = "Ocorreu um erro ao cadastrar o usuário.";
				return ERROR;
			}
			
			logger.info("cadastrarUsuario.usuario.not.null");
			
			if (usuarioFacade == null) {
				logger.info("cadastrarUsuario.usuarioFacade.null");
				errorMessage = "Ocorreu um erro ao cadastrar o usuário.";
				return ERROR;
			}
			
			logger.info("cadastrarUsuario.usuarioFacade.not.null");
			
			if (usuario.getNmLogin() == null || usuario.getNmLogin().trim().isEmpty()) {
				errorMessage = "Informe o login";
				return ERROR;
	        }
			
			usuario.setNmRole("ADMIN");
			
			usuarioFacade.cadastrarUsuario(usuario);
			
			return SUCCESS;
    	} catch (IllegalArgumentException e) {
    		errorMessage = e.getMessage();
    		return ERROR;
    		
		} catch (Exception e) {
			logger.info("cadastrarUsuario.catch");
			e.printStackTrace();
		}

    	errorMessage = "Ocorreu um erro ao cadastrar o usuário.";
		return ERROR;
    }
}
