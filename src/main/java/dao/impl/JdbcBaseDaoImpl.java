package dao.impl;

import dao.JdbcBaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcBaseDaoImpl implements JdbcBaseDao {

    private PreparedStatement preparedStatement;
    private Connection connection;

    public JdbcBaseDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ResultSet getResultset(String query) throws SQLException {
        return getPreparedStatement(query).executeQuery();
    }

    @Override
    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }




}
