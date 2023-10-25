package com.avaliacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.avaliacao.model.Usuario;
import com.avaliacao.util.DBUtil;

public class UsuarioDAO {

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
}
