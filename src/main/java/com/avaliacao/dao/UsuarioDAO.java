package com.avaliacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.avaliacao.model.Usuario;
import com.avaliacao.util.DBUtil;

public class UsuarioDAO {
	
	private static final Logger logger = Logger.getLogger(UsuarioDAO.class.getName());

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            String query = "SELECT * FROM usuario";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setNmLogin(resultSet.getString("nm_login"));
                usuario.setDsSenha(resultSet.getString("ds_senha"));
                usuario.setQtTempoInatividade(resultSet.getInt("qt_tempo_inatividade"));
                usuario.setNmRole(resultSet.getString("nm_role"));
                usuarios.add(usuario);
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    public int contarUsuarios() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            String query = "SELECT COUNT(*) FROM usuario";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {

			e.printStackTrace();
		}

        return 0;
    }
    
    public void inserirUsuario(Usuario usuario) {
    	logger.info("inserirUsuario");
    	
    	Connection connection = null;
        PreparedStatement statement = null;        
        
        try {
    		connection = DBUtil.getConnection();
            String query = "INSERT INTO avaliacao.usuario (nm_login, ds_senha, qt_tempo_inatividade, nm_role) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
                      

            statement.setString(1, usuario.getNmLogin());
            statement.setString(2, usuario.getEncryptedPassword());
            statement.setInt(3, usuario.getQtTempoInatividade());
            statement.setString(4, usuario.getNmRole());

            statement.executeUpdate();
            
            connection.close();
        } catch (Exception e) {
        	logger.info("inserirUsuario.exception");
            e.printStackTrace();
        }
    }
    
    public Usuario getByLogin(String nmLogin) {
    	logger.info("getByLogin");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Usuario usuario = null;

        try {
            connection = DBUtil.getConnection();
            String query = "SELECT * FROM avaliacao.usuario WHERE nm_login = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, nmLogin);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                usuario = new Usuario();
                usuario.setNmLogin(resultSet.getString("nm_login"));
                usuario.setDsSenha(resultSet.getString("ds_senha"));
                usuario.setQtTempoInatividade(resultSet.getInt("qt_tempo_inatividade"));
                usuario.setNmRole(resultSet.getString("nm_role"));
                usuario.setIsPasswordEncripted(true);
            }
            
            connection.close();
        } catch (Exception e) {
        	logger.info("getByLogin.exception");
            e.printStackTrace();
        }
        
        return usuario;
    }
}
