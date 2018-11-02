package dao.impl;

import model.Course;
import model.Level;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateNewCourseDaoTest {

    @Mock
    private JdbcBaseDaoImpl jdbcBaseDao;

    @Mock
    private PreparedStatement preparedStatement;

    @InjectMocks
    private CreateNewCourseDaoImpl createNewCourseDao;

    @Before
    public void setUp() {
        try {
            when(jdbcBaseDao.getPreparedStatement(Mockito.any(String.class))).thenReturn(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void shouldBeOkInCreateNewCourse() throws SQLException {
        when(preparedStatement.executeUpdate()).thenReturn(1);

        int result = createNewCourseDao.createNewCourse(getMockCourse());
        Assert.assertEquals(1, result);
    }

    @Test
    public void shouldBeKoInCreateNewCourse() throws SQLException {
        when(preparedStatement.executeUpdate()).thenReturn(0);

        int result = createNewCourseDao.createNewCourse(getMockCourse());
        Assert.assertEquals(0, result);
    }

    @Test(expected = SQLException.class)
    public void shouldBeKoAndThrowExceptionInCreateNewCourse() throws SQLException {
        when(preparedStatement.executeUpdate()).thenThrow(new SQLException());
        createNewCourseDao.createNewCourse(getMockCourse());
    }

    private Course getMockCourse() {
        return new Course("Title", 10, true, Level.BASIC);
    }



}
