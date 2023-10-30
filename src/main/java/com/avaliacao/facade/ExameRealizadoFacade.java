package com.avaliacao.facade;

import com.avaliacao.dao.ExameRealizadoDAO;
import com.avaliacao.model.ConsultaExamesRealizadosModel;
import com.avaliacao.model.ExameRealizado;

import java.util.List;

public class ExameRealizadoFacade {
    private ExameRealizadoDAO exameRealizadoDAO;

    public ExameRealizadoFacade() {
        exameRealizadoDAO = new ExameRealizadoDAO();
    }

    public List<ExameRealizado> getListaExamesRealizadosPaginada(ConsultaExamesRealizadosModel consultaExamesRealizadosModel) {
        return exameRealizadoDAO.listarExamesRealizados(
        		consultaExamesRealizadosModel.getPaginaAtual(),
        		consultaExamesRealizadosModel.getRegistrosPorPagina());
    }

    public int getTotalPaginas(ConsultaExamesRealizadosModel consultaExamesRealizadosModel) {
        int totalRegistros = exameRealizadoDAO.contarExamesRealizados();

        return (int) Math.ceil((double) totalRegistros / consultaExamesRealizadosModel.getRegistrosPorPagina());
    }

    public boolean incluirExameRealizado(ExameRealizado exameRealizado) {
        int id = exameRealizadoDAO.incluirExameRealizado(exameRealizado);

        return id > 0;
    }    
}