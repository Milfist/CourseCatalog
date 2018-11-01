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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FindAllCoursesDaoTest {

    @Mock
    private JdbcBaseDaoImpl jdbcBaseDao;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private FindAllCoursesDaoImpl findAllCoursesDao;

    @Before
    public void setUp() {
        try {
            when(jdbcBaseDao.getResultSet(Mockito.any(String.class))).thenReturn(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void shouldBeOkInCreateNewCourse() throws SQLException {
        when(resultSet.next()).thenReturn(true);

        List<Course> result = findAllCoursesDao.findActiveCourses();
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
