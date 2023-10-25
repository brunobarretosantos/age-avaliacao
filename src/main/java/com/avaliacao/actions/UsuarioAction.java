package com.avaliacao.actions;

import com.avaliacao.facade.UsuarioFacade;
import com.avaliacao.model.Usuario;
import com.opensymphony.xwork2.ActionSupport;

import java.util.logging.Logger;

public class UsuarioAction extends ActionSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;    
    private static final Logger logger = Logger.getLogger(UsuarioAction.class.getName());
    
    private Usuario usuario;
    private UsuarioFacade usuarioFacade;
        
    public Usuario getUsuario() {
    	return usuario;
    }
    
    public UsuarioAction() {
    	
    	logger.info("UsuarioAction");
    }   
       
}
