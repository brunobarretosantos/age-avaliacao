package com.avaliacao.actions.exames_realizados;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

import com.avaliacao.facade.ExameRealizadoFacade;
import com.avaliacao.model.ConsultaExamesRealizadosModel;
import com.avaliacao.model.ExameRealizado;

public class ConsultaAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    private ExameRealizadoFacade exameRealizadoFacade;
    private List<ExameRealizado> listaExamesRealizados;    
    private ConsultaExamesRealizadosModel consultaExamesRealizadosModel;
    
    public ConsultaAction() {
        exameRealizadoFacade = new ExameRealizadoFacade();
        consultaExamesRealizadosModel = new ConsultaExamesRealizadosModel();
        consultaExamesRealizadosModel.setTotalPaginas(exameRealizadoFacade.getTotalPaginas(consultaExamesRealizadosModel));
    }
    
    public ConsultaExamesRealizadosModel getConsultaExamesRealizadosModel() {
        return consultaExamesRealizadosModel;
    }
    
    public void setPagina(int pagina) {
        this.consultaExamesRealizadosModel.setPaginaAtual(pagina);
    }
    
    public void setExame(String exame) {
    	this.consultaExamesRealizadosModel.setNm_exame(exame);
    }
    
    public void setFuncionario(String functionario) {
    	this.consultaExamesRealizadosModel.setNm_funcionario(functionario);
    }    

    private void executarConsulta() {    	
        listaExamesRealizados = exameRealizadoFacade.getListaExamesRealizadosPaginada(consultaExamesRealizadosModel);
        consultaExamesRealizadosModel.setTotalPaginas(exameRealizadoFacade.getTotalPaginas(consultaExamesRealizadosModel));
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
