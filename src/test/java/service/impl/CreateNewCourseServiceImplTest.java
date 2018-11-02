package service.impl;

import dao.impl.CreateNewCourseDaoImpl;
import dao.impl.JdbcBaseDaoImpl;
import model.Course;
import model.Level;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateNewCourseServiceImplTest  {

    @Mock
    private CreateNewCourseDaoImpl createNewCourseDao;
    @InjectMocks
    private CreateNewCourseServiceImpl service;

    @Before
    public void setUp() {
    }

    @Test
    public void shouldBeOkInCreateNewCourse() throws SQLException {

        when(createNewCourseDao.createNewCourse(Mockito.any(Course.class))).thenReturn(1);
        Optional<Integer> result = service.createNewObjectInDaoCall(getMockCourse());
        Assert.assertEquals(Optional.of(1), result);
    }

    @Test
    public void shouldBeKoInCreateNewCourse() throws SQLException {
        when(createNewCourseDao.createNewCourse(Mockito.any(Course.class))).thenThrow(new SQLException());
        Optional<Integer> result = service.createNewObjectInDaoCall(getMockCourse());
        Assert.assertEquals(Optional.empty(), result);
    }

    private Course getMockCourse() {
        return new Course("Titulo", 10, true, Level.ADVANCED);
    }


}
