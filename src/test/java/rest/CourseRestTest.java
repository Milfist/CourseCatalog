package rest;

import model.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CourseRestTest {

    @Mock private FindActiveCoursesServiceImpl findActiveCoursesService;
    @Mock private CreateNewCourseServiceImpl createNewCourseService;
    @Mock private HttpServletRequest request;
    @Mock private HttpServletResponse response;
    @Mock private ServletOutputStream servletOutputStream;

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

//    public void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        extractConnectionFromHttpSession(request);
//        FindObjectInDaoCallService findCoursesService = newFindObjectService();
//        response.setContentType("application/json");
//        ServletOutputStream servletOutputStream = response.getOutputStream();
//        JsonConverter converter = new JsonConverter();
//        String output = converter.convertToJson((List<Course>) findCoursesService.findObjectInDaoCall().orElse(new ArrayList<>()));
//        servletOutputStream.print(output);
//    }



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
}
