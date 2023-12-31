package com.avaliacao.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.logging.Logger;

import com.avaliacao.facade.UsuarioFacade;
import com.avaliacao.model.CadastroUsuarioModel;

public class UsuarioAdminAction extends ActionSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private static final Logger logger = Logger.getLogger(UsuarioAdminAction.class.getName());
	
	private CadastroUsuarioModel usuario;	
    private UsuarioFacade usuarioFacade;
    private String errorMessage;    
    private boolean registerAdmin; 

    public boolean isRegisterAdmin() {
        return registerAdmin;
    }    
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public CadastroUsuarioModel getUsuario() {
    	return usuario;
    }

    public UsuarioAdminAction() {
    	logger.info("UsuarioAdminAction");
    	
    	registerAdmin = true;
    	errorMessage = null;
    	
        this.usuario = new CadastroUsuarioModel();
        this.usuarioFacade = new UsuarioFacade();
    } 
    
    @Override
    public String execute() {
    	try {
			logger.info("cadastrarUsuarioAdmin");
					
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
