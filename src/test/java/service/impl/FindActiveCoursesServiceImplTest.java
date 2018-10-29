package service.impl;

import dao.impl.CreateNewCourseDaoImpl;
import dao.impl.FindAllCoursesDaoImpl;
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
        when(findAllCoursesDao.findActiveCourses()).thenReturn(getMockCourse());
        Optional<List<Course>> result = service.findObjectInDaoCall();
        Assert.assertEquals(getMockCourse().get(0), result.get().get(0));
    }

//    @Test
//    public void shouldBeKoInCreateNewCourse() throws SQLException {
//        when(createNewCourseDao.createNewCourse(Mockito.any(Course.class))).thenThrow(new SQLException());
//        Optional<Integer> result = service.createNewObjectInDaoCall(getMockCourse());
//        Assert.assertEquals(Optional.empty(), result);
//    }

    private List<Course> getMockCourse() {
        List<Course> courses = new ArrayList<>();
        Course course = new Course("Titulo", 10, true, Level.BASIC);
        courses.add(course);
        return courses;
    }


}
