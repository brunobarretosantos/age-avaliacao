package com.avaliacao.actions;

import java.util.logging.Logger;

import com.avaliacao.dao.UsuarioDAO;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(IndexAction.class.getName());    

	@Override
	public String execute() {

		logger.info("Chegou aqui");

		
	    UsuarioDAO usuarioDAO = new UsuarioDAO(); int quantidadeUsuarios =
	    usuarioDAO.contarUsuarios();
	    
	    logger.info("quantidadeUsuarios: " + quantidadeUsuarios);
	  
	    if (quantidadeUsuarios == 0) {
	    	return "error412"; 
    	}
		 

		return SUCCESS;
	}
}