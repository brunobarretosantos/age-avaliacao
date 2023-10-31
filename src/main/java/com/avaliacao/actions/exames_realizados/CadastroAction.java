package com.avaliacao.actions.exames_realizados;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.logging.Logger;

import com.avaliacao.facade.ExameFacade;
import com.avaliacao.facade.ExameRealizadoFacade;
import com.avaliacao.facade.FuncionarioFacade;
import com.avaliacao.model.Exame;
import com.avaliacao.model.ExameRealizado;
import com.avaliacao.model.Funcionario;

public class CadastroAction extends ActionSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private static final Logger logger = Logger.getLogger(CadastroAction.class.getName());
	
	private ExameFacade exameFacade;
    private FuncionarioFacade funcionarioFacade;
    private ExameRealizadoFacade exameRealizadoFacade;
	
	private ExameRealizado exameRealizado;
	private List<Funcionario> listaFuncionarios;
    private List<Exame> listaExames;
    
     
    public ExameRealizado getExameRealizado() {
    	return exameRealizado;
    }
    
    public List<Exame> getListaExames() {
    	return this.listaExames;
    }
    
    public List<Funcionario> getListaFuncionarios() {
    	return this.listaFuncionarios;
    }    

    public CadastroAction() {
    	logger.info("CadastroAction");
    	
    	this.exameRealizado = new ExameRealizado();
    	    	        
        this.exameFacade = new ExameFacade();
        this.funcionarioFacade = new FuncionarioFacade();
        
        this.listaExames = this.exameFacade.getListaExamesAtivosOrdenada();
        this.listaFuncionarios = this.funcionarioFacade.getListaFuncionariosOrdenada();
        
        this.exameRealizadoFacade = new ExameRealizadoFacade();
    }
    
    public String cadastro() {
		logger.info("CadastroAction.form");		
		
		return INPUT;		
	}
    
    @Override
    public String execute() {
    	try {
			logger.info("cadastrarExame");
			
			if (this.exameRealizadoFacade.incluirExameRealizado(this.exameRealizado)) {
				return SUCCESS;
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
