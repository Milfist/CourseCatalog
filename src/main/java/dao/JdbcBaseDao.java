package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface JdbcBaseDao {
    ResultSet getResultSet(String query) throws SQLException;
    PreparedStatement getPreparedStatement(String query) throws SQLException;
}
