package com.avaliacao.actions.funcionarios;

import com.opensymphony.xwork2.ActionSupport;
import com.avaliacao.facade.FuncionarioFacade;
import com.avaliacao.model.ConsultaFuncionariosModel;
import com.avaliacao.model.Funcionario;

import java.util.List;

public class ConsultaAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    private FuncionarioFacade funcionarioFacade;
    private List<Funcionario> listaFuncionarios;
    private ConsultaFuncionariosModel consultaFuncionariosModel;

    public ConsultaAction() {
        funcionarioFacade = new FuncionarioFacade();
        consultaFuncionariosModel = new ConsultaFuncionariosModel();
        consultaFuncionariosModel.setTotalPaginas(funcionarioFacade.getTotalPaginas(consultaFuncionariosModel));
    }

    public ConsultaFuncionariosModel getConsultaFuncionariosModel() {
        return consultaFuncionariosModel;
    }

    public void setPagina(int pagina) {
        this.consultaFuncionariosModel.setPaginaAtual(pagina);
    }

    public void setCodigo(int codigo) {
        this.consultaFuncionariosModel.setCd_funcionario(codigo);
    }

    public void setNome(String nome) {
        this.consultaFuncionariosModel.setNm_funcionario(nome);
    }

    private void executarConsulta() {
        listaFuncionarios = funcionarioFacade.getListaFuncionariosPaginada(consultaFuncionariosModel);
        consultaFuncionariosModel.setTotalPaginas(funcionarioFacade.getTotalPaginas(consultaFuncionariosModel));
    }

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
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