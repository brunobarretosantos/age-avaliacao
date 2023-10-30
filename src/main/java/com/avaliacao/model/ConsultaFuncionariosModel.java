package com.avaliacao.model;

public class ConsultaFuncionariosModel {
    
    private int paginaAtual = 1;
    private int totalPaginas;
    private int registrosPorPagina = 10;
    private int primeiraPagina;
    private Integer cd_funcionario = null;
    private String nm_funcionario;
    
    public int getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(int paginaAtual) {
        if (paginaAtual > this.totalPaginas) {
            this.paginaAtual = this.totalPaginas;
            return;
        }
        
        if (paginaAtual < 1) {
            this.paginaAtual = 1;
            return;
        }

        this.paginaAtual = paginaAtual;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }
    
    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }
    
    public int getPrimeiraPagina() {
        return primeiraPagina = Math.max(1, this.paginaAtual - 2);
    }

    public int getUltimaPagina() {
        return Math.min(this.totalPaginas, this.primeiraPagina + 4);
    }

    public int getRegistrosPorPagina() {
        return registrosPorPagina;
    }

    public void setRegistrosPorPagina(int registrosPorPagina) {
        this.registrosPorPagina = registrosPorPagina;
    }

    public Integer getCd_funcionario() {
        return cd_funcionario;
    }

    public void setCd_funcionario(Integer cd_funcionario) {
        this.cd_funcionario = cd_funcionario;
    }

    public String getNm_funcionario() {
        return nm_funcionario;
    }

    public void setNm_funcionario(String nm_funcionario) {
        this.nm_funcionario = nm_funcionario;
    }
}
