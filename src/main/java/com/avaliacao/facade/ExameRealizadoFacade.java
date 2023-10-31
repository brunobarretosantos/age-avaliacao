package com.avaliacao.facade;

import com.avaliacao.dao.ExameRealizadoDAO;
import com.avaliacao.model.ConsultaExamesRealizadosModel;
import com.avaliacao.model.ExameRealizado;
import com.avaliacao.model.RelatorioExamesRealizadosModel;

import java.util.List;

public class ExameRealizadoFacade {
    private ExameRealizadoDAO exameRealizadoDAO;

    public ExameRealizadoFacade() {
        exameRealizadoDAO = new ExameRealizadoDAO();
    }

    public List<ExameRealizado> getListaExamesRealizadosPaginada(ConsultaExamesRealizadosModel consultaExamesRealizadosModel) {
        return exameRealizadoDAO.listarExamesRealizados(
        		consultaExamesRealizadosModel.getPaginaAtual(),
        		consultaExamesRealizadosModel.getRegistrosPorPagina(),
        		consultaExamesRealizadosModel.getNm_exame(),
        		consultaExamesRealizadosModel.getNm_funcionario());
    }

    public int getTotalPaginas(ConsultaExamesRealizadosModel consultaExamesRealizadosModel) {
        int totalRegistros = exameRealizadoDAO.contarExamesRealizados(
        		consultaExamesRealizadosModel.getNm_exame(),
        		consultaExamesRealizadosModel.getNm_funcionario());

        return (int) Math.ceil((double) totalRegistros / consultaExamesRealizadosModel.getRegistrosPorPagina());
    }
    
    public List<ExameRealizado> getListaExamesRealizadosPaginada(RelatorioExamesRealizadosModel model) {
        return exameRealizadoDAO.listarExamesPorData(
        		model.getPaginaAtual(),
        		model.getRegistrosPorPagina(),
        		model.getDtInicio(),
        		model.getDtFim());
    }

    public int getTotalPaginas(RelatorioExamesRealizadosModel model) {
        int totalRegistros = exameRealizadoDAO.contarExamesPorData(
        		model.getDtInicio(),
        		model.getDtFim());

        return (int) Math.ceil((double) totalRegistros / model.getRegistrosPorPagina());
    }

    public boolean incluirExameRealizado(ExameRealizado exameRealizado) {
        int id = exameRealizadoDAO.incluirExameRealizado(exameRealizado);

        return id > 0;
    }    
}