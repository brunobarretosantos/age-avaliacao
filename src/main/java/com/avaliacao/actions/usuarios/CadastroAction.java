package com.avaliacao.actions.usuarios;

import com.opensymphony.xwork2.ActionSupport;

import java.util.logging.Logger;

import com.avaliacao.facade.UsuarioFacade;
import com.avaliacao.model.CadastroUsuarioModel;
import com.avaliacao.model.Usuario;

public class CadastroAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(CadastroAction.class.getName());

    private CadastroUsuarioModel cadastroUsuarioModel;
    private UsuarioFacade usuarioFacade;
    private String login;

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public CadastroUsuarioModel getCadastroUsuarioModel() {
        return cadastroUsuarioModel;
    }

    public void setCadastroUsuarioModel(CadastroUsuarioModel cadastroUsuarioModel) {
        this.cadastroUsuarioModel = cadastroUsuarioModel;
    }

    public CadastroAction() {
        this.usuarioFacade = new UsuarioFacade();
        this.cadastroUsuarioModel = new CadastroUsuarioModel();
    }
    
    public String cadastro() {
        logger.info("CadastroAction.form");
        
        logger.info("CadastroAction.this.id: " + this.login );
        
        if (this.login != null) {
            Usuario usuario = usuarioFacade.carregarUsuario(this.login);
            
            this.cadastroUsuarioModel = new CadastroUsuarioModel();
            this.cadastroUsuarioModel.setLoaded(true);
            this.cadastroUsuarioModel.setNmLogin(usuario.getNmLogin());
            this.cadastroUsuarioModel.setNmRole(usuario.getNmRole());
            this.cadastroUsuarioModel.setQtTempoInatividade(usuario.getQtTempoInatividade());
        }
        
        return INPUT;        
    }

    @Override
    public String execute() {
        logger.info("CadastroUsuarioAction.execute");

        try {
        	
        	logger.info("CadastroUsuarioAction.cadastroUsuarioModel.isLoaded: " + this.cadastroUsuarioModel.isLoaded());
        	logger.info("CadastroUsuarioAction.cadastroUsuarioModel.getNmLogin: " + this.cadastroUsuarioModel.getNmLogin());
        	
            if (cadastroUsuarioModel.getNmRole() == null || cadastroUsuarioModel.getNmRole().trim().isEmpty()) {
                addActionError("Informe a Role");
                return ERROR;
            }

            if (this.cadastroUsuarioModel.isLoaded() == true) {
            	logger.info("CadastroUsuarioAction.isLoaded");
                if (usuarioFacade.alterarUsuario(cadastroUsuarioModel)) {
                    addActionMessage("Usuário alterado com sucesso!");
                    return SUCCESS;
                }
            } else {
            	logger.info("CadastroUsuarioAction.is Not Loaded");
            	if (cadastroUsuarioModel.getNmLogin() == null || cadastroUsuarioModel.getNmLogin().trim().isEmpty()) {
            		addActionError("Informe o login");
                    return ERROR;
            	}
            	
            	if (cadastroUsuarioModel.getNmLogin().trim().contains(" ")) {
            		addActionError("Login inválido. Não utilize espaços em branco.");
                    return ERROR;
            	}
            	
            	if (cadastroUsuarioModel.getDsSenha() == null || cadastroUsuarioModel.getDsSenha().trim().isEmpty()) {
            		addActionError("Informe a senha");
                    return ERROR;
            	}
            	
            	
                if (usuarioFacade.cadastrarUsuario(cadastroUsuarioModel)) {
                    addActionMessage("Usuário criado com sucesso!");
                    return SUCCESS;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        addActionError("Ocorreu um erro inesperado");
        return ERROR;
    }

    public String excluir() {
        logger.info("CadastroUsuarioAction.excluir.login: " + login);

        try {
            if (login != null) {
                boolean sucesso = usuarioFacade.excluirUsuario(login);

                if (sucesso) {
                    addActionMessage("Usuário excluído com sucesso.");
                    return SUCCESS;
                } else {
                    addActionError("Não foi possível excluir o usuário.");
                    return ERROR;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        addActionError("Ocorreu um erro inesperado");
        return ERROR;
    }
}