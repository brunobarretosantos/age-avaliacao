package com.avaliacao.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.logging.Logger;

public class UsuarioAction extends ActionSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    private static final Logger logger = Logger.getLogger(UsuarioAction.class.getName());
    
    public UsuarioAction() {
    	
    	logger.info("UsuarioAction");
    }
       
}
