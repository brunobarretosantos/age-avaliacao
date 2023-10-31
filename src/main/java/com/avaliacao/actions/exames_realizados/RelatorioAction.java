package com.avaliacao.actions.exames_realizados;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.avaliacao.facade.ExameRealizadoFacade;
import com.avaliacao.model.RelatorioExamesRealizadosModel;
import com.avaliacao.model.ExameRealizado;

public class RelatorioAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(RelatorioAction.class.getName());

    private ExameRealizadoFacade exameRealizadoFacade;
    private List<ExameRealizado> listaExamesRealizados;    
    private RelatorioExamesRealizadosModel relatorioExamesRealizadosModel;
    
    public RelatorioAction() {
        exameRealizadoFacade = new ExameRealizadoFacade();
        relatorioExamesRealizadosModel = new RelatorioExamesRealizadosModel();
    }
    
    public RelatorioExamesRealizadosModel getRelatorioExamesRealizadosModel() {
        return relatorioExamesRealizadosModel;
    }
    
    public void setPagina(int pagina) {
        this.relatorioExamesRealizadosModel.setPaginaAtual(pagina);
    }
    
    public void setDtInicio(Date dtInicio) {
    	this.relatorioExamesRealizadosModel.setDtInicio(dtInicio);
    }
    
    public void setDtFim(Date dtFim) {
    	this.relatorioExamesRealizadosModel.setDtFim(dtFim);
    }    

    private void executarConsulta() {
    	logger.info("RelatorioAction.executarConsulta");
    	
    	if (relatorioExamesRealizadosModel.getDtInicio() == null || relatorioExamesRealizadosModel.getDtFim() == null) {
    		return;
    	}
    	
        listaExamesRealizados = exameRealizadoFacade.getListaExamesRealizadosPaginada(relatorioExamesRealizadosModel);
        relatorioExamesRealizadosModel.setTotalPaginas(exameRealizadoFacade.getTotalPaginas(relatorioExamesRealizadosModel));
    }

    public List<ExameRealizado> getListaExamesRealizados() {
        return listaExamesRealizados;
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
