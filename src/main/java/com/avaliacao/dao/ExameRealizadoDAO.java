package com.avaliacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.avaliacao.model.ExameRealizado;
import com.avaliacao.util.DBUtil;

public class ExameRealizadoDAO {
    
    public List<ExameRealizado> listarExamesRealizados(int pagina, int qtdPagina) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtil.getConnection();
            StringBuilder query = new StringBuilder("SELECT er.cd_funcionario, er.cd_exame, er.dt_realizacao, e.nm_exame, f.nm_funcionario FROM exame_realizado er");
            query.append(" JOIN exame e ON er.cd_exame = e.cd_exame");
            query.append(" JOIN funcionario f ON er.cd_funcionario = f.cd_funcionario");            

            query.append(" LIMIT ?, ?");

            preparedStatement = connection.prepareStatement(query.toString());            
            preparedStatement.setInt(1, (pagina - 1) * qtdPagina);
            preparedStatement.setInt(2, qtdPagina);

            ResultSet rs = preparedStatement.executeQuery();

            List<ExameRealizado> examesRealizados = new ArrayList<>();
            while (rs.next()) {
                ExameRealizado exameRealizado = new ExameRealizado();
                exameRealizado.setCd_funcionario(rs.getInt("cd_funcionario"));
                exameRealizado.setCd_exame(rs.getInt("cd_exame"));
                exameRealizado.setDt_realizacao(rs.getDate("dt_realizacao"));
                exameRealizado.setNm_exame(rs.getString("nm_exame"));
                exameRealizado.setNm_funcionario(rs.getString("nm_funcionario"));
                examesRealizados.add(exameRealizado);
            }

            return examesRealizados;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int contarExamesRealizados() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtil.getConnection();
            StringBuilder query = new StringBuilder("SELECT COUNT(*) FROM exame_realizado");

            preparedStatement = connection.prepareStatement(query.toString());

            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public int incluirExameRealizado(ExameRealizado exameRealizado) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO exame_realizado (cd_funcionario, cd_exame, dt_realizacao) VALUES (?, ?, ?)");

            preparedStatement.setInt(1, exameRealizado.getCd_funcionario());
            preparedStatement.setInt(2, exameRealizado.getCd_exame());
            preparedStatement.setDate(3, new java.sql.Date(exameRealizado.getDt_realizacao().getTime()));

            int rowsInserted = preparedStatement.executeUpdate();            
            
            return rowsInserted;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}