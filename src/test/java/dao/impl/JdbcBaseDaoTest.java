package dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.InstanceOf;
import org.mockito.junit.MockitoJUnitRunner;
import utils.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JdbcBaseDaoTest {

    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @InjectMocks
    private JdbcBaseDaoImpl jdbcBaseDao;

    @Test
    public void getResultSetTest() throws SQLException {
        when(connection.prepareStatement(Mockito.any(String.class))).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        ResultSet result = jdbcBaseDao.getResultSet(getQueryMock());
        Assert.assertNotNull(result);
    }

    @Test
    public void shouldBeOkWhenGetResultSetTest() throws SQLException {
        when(connection.prepareStatement(Mockito.any(String.class))).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        ResultSet result = jdbcBaseDao.getResultSet(getQueryMock());
        Assert.assertNotNull(result);
    }

    @Test
    public void shouldBeOkWhenGetPrepareStatementTest() throws SQLException {
        when(connection.prepareStatement(Mockito.any(String.class))).thenReturn(preparedStatement);
        PreparedStatement result = jdbcBaseDao.getPreparedStatement(getQueryMock());
        Assert.assertNotNull(result);
    }

    @Test(expected = SQLException.class)
    public void shouldBeKoWhenPrepareStatementExecuteQueryTest() throws SQLException {
        when(connection.prepareStatement(Mockito.any(String.class))).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenThrow(new SQLException());
        jdbcBaseDao.getResultSet(getQueryMock());
    }

    @Test(expected = SQLException.class)
    public void shouldBeKoWhenReturnPrepareStatementTest() throws SQLException {
        when(connection.prepareStatement(Mockito.any(String.class))).thenThrow(new SQLException());
        jdbcBaseDao.getResultSet(getQueryMock());
    }
    private String getQueryMock() {
        return "SELECT * FROM COURSES;";
    }

}



//    private Connection connection;
//
//    public JdbcBaseDaoImpl() {
//        this.connection = ConnectionSingleton.getConecction();
//    }
//
//    @Override
//    public ResultSet getResultSet(String query) throws SQLException {
//        return getPreparedStatement(query).executeQuery();
//    }
//
//    @Override
//    public PreparedStatement getPreparedStatement(String query) throws SQLException {
//        return connection.prepareStatement(query);
//    }