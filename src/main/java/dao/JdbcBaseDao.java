package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface JdbcBaseDao {
    ResultSet getResultset(String query) throws SQLException;
    PreparedStatement getPreparedStatement(String query) throws SQLException;
}
