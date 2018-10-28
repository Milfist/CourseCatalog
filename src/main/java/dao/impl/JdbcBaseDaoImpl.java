package dao.impl;

import dao.JdbcBaseDao;
import utils.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcBaseDaoImpl implements JdbcBaseDao {

    private Connection connection;

    public JdbcBaseDaoImpl() {
        this.connection = ConnectionSingleton.getConecction();
    }

    @Override
    public ResultSet getResultSet(String query) throws SQLException {
        return getPreparedStatement(query).executeQuery();
    }

    @Override
    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }
}
