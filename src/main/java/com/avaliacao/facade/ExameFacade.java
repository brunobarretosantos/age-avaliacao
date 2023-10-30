package com.avaliacao.facade;

import com.avaliacao.dao.ExameDAO;
import com.avaliacao.model.Exame;

import java.util.List;

public class ExameFacade {
    private ExameDAO exameDAO;

    public ExameFacade() {
        exameDAO = new ExameDAO();
    }

    public List<Exame> getListaExamesPaginada(int pagina, int registrosPorPagina) {
        return exameDAO.listarExames(pagina, registrosPorPagina);
    }

    public int getTotalPaginas(int registrosPorPagina) {
        int totalRegistros = exameDAO.contarExames();

        return (int) Math.ceil((double) totalRegistros / registrosPorPagina);
    }
}