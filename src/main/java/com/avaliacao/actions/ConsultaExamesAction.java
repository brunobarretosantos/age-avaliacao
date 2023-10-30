package com.avaliacao.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

import com.avaliacao.facade.ExameFacade;
import com.avaliacao.model.ConsultaExamesModel;
import com.avaliacao.model.Exame;

public class ConsultaExamesAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    private ExameFacade exameFacade;
    private List<Exame> listaExames;
    
    private ConsultaExamesModel consultaExamesModel;
    
    public ConsultaExamesModel getConsultaExamesModel() {
        return consultaExamesModel;
    }
    
    public void setPagina(int pagina) {
        this.consultaExamesModel.setPaginaAtual(pagina);
    }
    
    public void setCodigo(int codigo) {
    	this.consultaExamesModel.setCd_exame(codigo);
    }
    
    public void setNome(String nome) {
    	this.consultaExamesModel.setNm_exame(nome);
    }
    
    public void setAtivo(String ativo) {
    	if (ativo != null) {
    		this.consultaExamesModel.setIc_ativo(ativo.toLowerCase());
    	}
    }
    

    public ConsultaExamesAction() {
        exameFacade = new ExameFacade();
        consultaExamesModel = new ConsultaExamesModel();
        consultaExamesModel.setTotalPaginas(exameFacade.getTotalPaginas(consultaExamesModel));
    }
    
    public String list() {
    	executarConsulta();
    			
    	return SUCCESS;
    }

    private void executarConsulta() {    	
        listaExames = exameFacade.getListaExamesPaginada(consultaExamesModel);
        consultaExamesModel.setTotalPaginas(exameFacade.getTotalPaginas(consultaExamesModel));
    }

    public List<Exame> getListaExames() {
        return listaExames;
    }    

    @Override
    public String execute() {
        try {
            executarConsulta();
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return SUCCESS;
    }
}