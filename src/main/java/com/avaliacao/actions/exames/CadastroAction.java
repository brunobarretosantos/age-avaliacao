package com.avaliacao.actions.exames;

import com.opensymphony.xwork2.ActionSupport;

import java.util.logging.Logger;

import com.avaliacao.facade.ExameFacade;
import com.avaliacao.model.Exame;

public class CadastroAction extends ActionSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private static final Logger logger = Logger.getLogger(CadastroAction.class.getName());
	
	private int id;
	private Exame exame;
    private ExameFacade exameFacade;
    
    public int getId() {
    	return this.id;
    }  
    
    public void setId(int id) {
    	this.id = id;
    }   
        
    public Exame getExame() {
    	return this.exame;
    }

    public CadastroAction() {
    	logger.info("CadastroAction");
    	    	
    	
        this.exame = new Exame();
        this.exameFacade = new ExameFacade();
    }
    
    public String cadastro() {
		logger.info("CadastroAction.form");
		
		logger.info("CadastroAction.this.id: " + this.id );
		
		if (this.id > 0) {
	        exame = exameFacade.carregarExame(this.id);
	        if (exame != null) {
	            return INPUT;
	        }
	    }
		
		return INPUT;		
	}
    
    @Override
    public String execute() {
    	try {
			logger.info("cadastrarExame");
			
			if (exame.getNmExame() == null || exame.getNmExame().trim().isEmpty()) {
                addFieldError("exame.nmExameError", "O nome do exame é obrigatório.");
                return ERROR;
            }
			
			if (this.exame.getCdExame() > 0) {
				
				if (exameFacade.alterarExame(exame)) {
					addActionMessage("Exame alterado com sucesso!");
					return SUCCESS;
				}
			} else {			
				Exame exameResult = exameFacade.incluirExame(this.exame);
				
				if (exameResult != null && exameResult.getCdExame() > 0) {
					this.id = exameResult.getCdExame();
					this.exame.setCdExame(id);
					addActionMessage("Exame criado com sucesso!");
					return SUCCESS;
				}
			}
			
    	} catch (IllegalArgumentException e) {
    		addActionError(e.getMessage());
    		return ERROR;
    		
		} catch (Exception e) {
			logger.info("cadastrarExame.catch");
			e.printStackTrace();
		}

    	
    	addActionError("Ocorreu um erro inesperado");
		return ERROR;
    }
}
