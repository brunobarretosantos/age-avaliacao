package com.avaliacao.actions;

import java.util.List;
import com.avaliacao.dao.ExameDAO;
import com.avaliacao.model.Exame;
import com.opensymphony.xwork2.ActionSupport;

public class ExameAction extends ActionSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Exame exame;
    private List<Exame> listaExames;
    private ExameDAO exameDAO;

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public Exame getExame() {
        return exame;
    }

    public List<Exame> getListaExames() {
        return listaExames;
    }

    public void setExameDAO(ExameDAO exameDAO) {
        this.exameDAO = exameDAO;
    }

    // Método para adicionar um exame
    public String adicionarExame() {
        try {
            exameDAO.adicionarExame(exame);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    // Método para listar os exames
    public String listarExames() {
        try {
            listaExames = exameDAO.listarExames();
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    // Método para editar um exame
    public String editarExame() {
        try {
            // Lógica para editar o exame
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    // Método para excluir um exame
    public String excluirExame() {
        try {
            // Lógica para excluir o exame
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
}