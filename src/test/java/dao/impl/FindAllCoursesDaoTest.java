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
import java.util.ArrayList;
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
    public void shouldBeOkWhenFindCourses() throws SQLException {
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getString("TITLE")).thenReturn("Title");
        when(resultSet.getInt("DURATION")).thenReturn(10);
        when(resultSet.getBoolean("IS_ACTIVE")).thenReturn(true);
        when(resultSet.getString("COURSE_LEVEL")).thenReturn("BASIC");
        List<Course> result = findAllCoursesDao.findActiveCourses();
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void shouldBeOkWhenFindCoursesWithEmptyList() throws SQLException {
        when(resultSet.next()).thenReturn(false);
        List<Course> result = findAllCoursesDao.findActiveCourses();
        Assert.assertEquals(0, result.size());
    }

    @Test(expected = SQLException.class)
    public void shouldBeKoWhenResultSetThrowSQLException() throws SQLException {
        when(findAllCoursesDao.findActiveCourses()).thenThrow(new SQLException());
        findAllCoursesDao.findActiveCourses();
    }

    @Test(expected = SQLException.class)
    public void shouldBeKoWhenFindCoursesThrowSQLException() throws SQLException {
        when(resultSet.next()).thenThrow(new SQLException());
        findAllCoursesDao.findActiveCourses();
    }
}
