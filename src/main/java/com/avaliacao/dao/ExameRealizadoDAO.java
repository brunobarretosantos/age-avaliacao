package com.avaliacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.avaliacao.model.ExameRealizado;

public class ExameRealizadoDAO {
    private Connection conexao;

    public ExameRealizadoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void adicionarExameRealizado(ExameRealizado exameRealizado) throws SQLException {
        String sql = "INSERT INTO exame_realizado (codigo_funcionario, codigo_exame, data_realizacao) VALUES (?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, exameRealizado.getCodigoFuncionario());
        stmt.setInt(2, exameRealizado.getCodigoExame());
        stmt.setDate(3, new java.sql.Date(exameRealizado.getDataRealizacao().getTime()));
        stmt.execute();
        stmt.close();
    }

    public List<ExameRealizado> listarExamesRealizados() throws SQLException {
        List<ExameRealizado> listaExamesRealizados = new ArrayList<>();
        String sql = "SELECT * FROM exame_realizado";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ExameRealizado exameRealizado = new ExameRealizado();
            exameRealizado.setCodigoFuncionario(rs.getInt("codigo_funcionario"));
            exameRealizado.setCodigoExame(rs.getInt("codigo_exame"));
            exameRealizado.setDataRealizacao(rs.getDate("data_realizacao"));
            listaExamesRealizados.add(exameRealizado);
        }
        rs.close();
        stmt.close();
        return listaExamesRealizados;
    }
}