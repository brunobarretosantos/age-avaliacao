package com.avaliacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.avaliacao.model.Exame;
import com.avaliacao.util.DBUtil;

public class ExameDAO {
	
	private static final Logger logger = Logger.getLogger(ExameDAO.class.getName());
    
    public List<Exame> listarExames(int pagina, int qtdPagina) {
    	logger.info("pagina: " + pagina);
    	logger.info("qtdPagina: " + qtdPagina);
    	
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
    	
    	try {
            connection = DBUtil.getConnection();            
            preparedStatement = connection.prepareStatement("SELECT * FROM exame LIMIT ?, ?");
                        
            int limiteInferior = (pagina - 1) * qtdPagina;
            preparedStatement.setInt(1, limiteInferior);
            preparedStatement.setInt(2, qtdPagina);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            List<Exame> exames = new ArrayList<>();
            while (rs.next()) {
                Exame exame = new Exame();
                exame.setCdExame(rs.getInt("cd_exame"));
                exame.setNmExame(rs.getString("nm_exame"));
                exame.setIcAtivo(rs.getBoolean("ic_ativo"));
                exame.setDsDetalheExame(rs.getString("ds_detalhe_exame"));
                exame.setDsDetalheExame1(rs.getString("ds_detalhe_exame1"));
                exames.add(exame);
            }
            
            return exames;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Exame>();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public int contarExames() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM exame");

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
}