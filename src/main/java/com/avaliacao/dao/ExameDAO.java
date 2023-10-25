package com.avaliacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.avaliacao.model.Exame;

public class ExameDAO {
    private Connection conexao;
    
    public ExameDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void adicionarExame(Exame exame) throws SQLException {
        String sql = "INSERT INTO exame (nome, ativo) VALUES (?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, exame.getNome());
        stmt.setBoolean(2, exame.isAtivo());
        stmt.execute();
        stmt.close();
    }

    public List<Exame> listarExames() throws SQLException {
        List<Exame> listaExames = new ArrayList<>();
        String sql = "SELECT * FROM exame";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Exame exame = new Exame();
            exame.setId(rs.getInt("id"));
            exame.setNome(rs.getString("nome"));
            exame.setAtivo(rs.getBoolean("ativo"));
            listaExames.add(exame);
        }
        rs.close();
        stmt.close();
        return listaExames;
    }
}