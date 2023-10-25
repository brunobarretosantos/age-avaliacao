package com.avaliacao.model;

public class Usuario {
    private String nmLogin;
    private String dsSenha;
    private int qtTempoInatividade;
    private String nmRole;

    public String getNmLogin() {
        return nmLogin;
    }

    public void setNmLogin(String nmLogin) {
        this.nmLogin = nmLogin;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public int getQtTempoInatividade() {
        return qtTempoInatividade;
    }

    public void setQtTempoInatividade(int qtTempoInatividade) {
        this.qtTempoInatividade = qtTempoInatividade;
    }

    public String getNmRole() {
        return nmRole;
    }

    public void setNmRole(String nmRole) {
        this.nmRole = nmRole;
    }
}
