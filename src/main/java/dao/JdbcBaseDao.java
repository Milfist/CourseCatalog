package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcBaseDao {

    private PreparedStatement preparedStatement;
    private Connection connection;

    public JdbcBaseDao(Connection connection) {
        this.connection = connection;
    }

    public ResultSet getResulset(String query) throws SQLException {
        return getPreparedStatement(query).executeQuery();
    }

    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }




}
