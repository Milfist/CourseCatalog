package rest;

import model.Course;
import model.Level;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import service.CreateNewObjectInDaoCallService;
import service.FindObjectInDaoCallService;
import service.impl.CreateNewCourseServiceImpl;
import service.impl.FindActiveCoursesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CourseRestTest {

    @Mock private FindActiveCoursesServiceImpl findActiveCoursesService;
    @Mock private CreateNewCourseServiceImpl createNewCourseService;
    @Mock private HttpServletRequest request;
    @Mock private HttpServletResponse response;
    @Mock private ServletOutputStream servletOutputStream;
    @Mock private BufferedReader bufferedReader;

    @Spy
    private CourseRest courseRest;


    @Test
    public void doGetTest() throws IOException, ServletException {
        Mockito.doNothing().when(courseRest).extractConnectionFromHttpSession(Mockito.any(HttpServletRequest.class));
        Mockito.doReturn(findActiveCoursesService).when(courseRest).newFindObjectService();
        Mockito.doReturn(Optional.of(new ArrayList<Course>())).when(findActiveCoursesService).findObjectInDaoCall();
        Mockito.doReturn(servletOutputStream).when(response).getOutputStream();

        courseRest.doGet(request, response);
        verify(courseRest, times(1)).doGet(Mockito.any(HttpServletRequest.class), Mockito.any(HttpServletResponse.class));
    }

    @Test
    public void doPostTest() throws IOException, ServletException {

        Mockito.doNothing().when(courseRest).extractConnectionFromHttpSession(Mockito.any(HttpServletRequest.class));
        Mockito.doReturn(createNewCourseService).when(courseRest).newCreateNewObjectService();
        Mockito.doReturn(Optional.of(1)).when(createNewCourseService).createNewObjectInDaoCall(Mockito.any());
        Mockito.doReturn(servletOutputStream).when(response).getOutputStream();
//        Mockito.doReturn(bufferedReader).when(request).getReader();
        Mockito.doReturn(getMockCourse()).when(courseRest).getCourseFromRequest(Mockito.any(HttpServletRequest.class));

        courseRest.doPost(request, response);
        verify(courseRest, times(1)).doPost(Mockito.any(HttpServletRequest.class), Mockito.any(HttpServletResponse.class));
    }

    @Test
    public void doPostTestKO() throws IOException, ServletException {

        Mockito.doNothing().when(courseRest).extractConnectionFromHttpSession(Mockito.any(HttpServletRequest.class));
        Mockito.doReturn(createNewCourseService).when(courseRest).newCreateNewObjectService();
        Mockito.doReturn(Optional.of(0)).when(createNewCourseService).createNewObjectInDaoCall(Mockito.any());
        Mockito.doReturn(servletOutputStream).when(response).getOutputStream();
//        Mockito.doReturn(bufferedReader).when(request).getReader();
        Mockito.doReturn(getMockCourse()).when(courseRest).getCourseFromRequest(Mockito.any(HttpServletRequest.class));

        courseRest.doPost(request, response);
        verify(courseRest, times(1)).doPost(Mockito.any(HttpServletRequest.class), Mockito.any(HttpServletResponse.class));
    }

    @Test
    public void shouldBeReturnFindActiveCoursesServiceTest(){
        when(courseRest.newFindObjectService()).thenReturn(findActiveCoursesService);

        FindObjectInDaoCallService service = courseRest.newFindObjectService();
        Assert.assertTrue(service instanceof FindActiveCoursesServiceImpl);
    }

    @Test
    public void shouldBeReturnCreateNewCourseServiceTest(){
        when(courseRest.newCreateNewObjectService()).thenReturn(createNewCourseService);
        CreateNewObjectInDaoCallService service = courseRest.newCreateNewObjectService();
        Assert.assertTrue(service instanceof CreateNewCourseServiceImpl);
    }

    private Course getMockCourse() {
        return new Course("Title", 10, true, Level.ADVANCED);
    }

}
