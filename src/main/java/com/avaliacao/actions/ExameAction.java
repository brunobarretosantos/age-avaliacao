package com.avaliacao.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

import com.avaliacao.facade.ExameFacade;
import com.avaliacao.model.ConsultaExamesModel;
import com.avaliacao.model.Exame;

public class ExameAction extends ActionSupport {
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
    

    public ExameAction() {
        exameFacade = new ExameFacade();
        consultaExamesModel = new ConsultaExamesModel();
        consultaExamesModel.setTotalPaginas(exameFacade.getTotalPaginas(consultaExamesModel.getRegistrosPorPagina()));
    }
    
    public String list() {
    	executarConsulta();
    			
    	return SUCCESS;
    }

    private void executarConsulta() {
        listaExames = exameFacade.getListaExamesPaginada(consultaExamesModel.getPaginaAtual(), consultaExamesModel.getRegistrosPorPagina());
        consultaExamesModel.setTotalPaginas(exameFacade.getTotalPaginas(consultaExamesModel.getRegistrosPorPagina()));
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