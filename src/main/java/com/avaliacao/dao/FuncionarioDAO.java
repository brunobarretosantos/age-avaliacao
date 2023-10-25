package com.avaliacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.avaliacao.model.Funcionario;

public class FuncionarioDAO {
    private Connection conexao;

    public FuncionarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void adicionarFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (codigo, nome) VALUES (?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, funcionario.getCodigo());
        stmt.setString(2, funcionario.getNome());
        stmt.execute();
        stmt.close();
    }

    public List<Funcionario> listarFuncionarios() throws SQLException {
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setCodigo(rs.getInt("codigo"));
            funcionario.setNome(rs.getString("nome"));
            listaFuncionarios.add(funcionario);
        }
        rs.close();
        stmt.close();
        return listaFuncionarios;
    }
}