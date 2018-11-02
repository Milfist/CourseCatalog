package service.impl;

import dao.impl.FindAllCoursesDaoImpl;
import model.Course;
import model.Level;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FindActiveCoursesServiceImplTest {

    @Mock
    private FindAllCoursesDaoImpl findAllCoursesDao;
    @InjectMocks
    private FindActiveCoursesServiceImpl service;

    @Before
    public void setUp() {
    }

    @Test
    public void shouldBeOkInCreateNewCourse() throws SQLException {
        when(findAllCoursesDao.findActiveCourses()).thenReturn(getMockCourses());
        Optional<List<Course>> result = service.findObjectInDaoCall();
        Assert.assertEquals(getMockCourses().get(0).getTitle(), result.get().get(0).getTitle());
    }

    @Test
    public void shouldBeKoInCreateNewCourse() throws SQLException {
        when(findAllCoursesDao.findActiveCourses()).thenThrow(new SQLException());
        Optional<List<Course>> result = service.findObjectInDaoCall();
        Assert.assertEquals(Optional.empty(), result);
    }

    private List<Course> getMockCourses() {
        List<Course> courses = new ArrayList<>();
        Course course = new Course("Titulo", 10, true, Level.MEDIUM);
        courses.add(course);
        return courses;
    }


}
