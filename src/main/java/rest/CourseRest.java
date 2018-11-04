package rest;


import com.google.gson.Gson;
import model.Course;
import service.FindObjectInDaoCallService;
import service.CreateNewObjectInDaoCallService;
import service.AbstractServiceFactory;
import service.impl.CreateNewCourseServiceImpl;
import service.impl.FindActiveCoursesServiceImpl;
import servlet.BaseServlet;
import utils.JsonConverter;
import utils.JsonDeserializer;
import views.SimpleResponseView;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name="course",  urlPatterns = "/course")
public class CourseRest extends HttpServlet implements BaseServlet, AbstractServiceFactory {

    @Override
    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        extractConnectionFromHttpSession(request);
        FindObjectInDaoCallService findCoursesService = newFindObjectService();
        response.setContentType("application/json");
        ServletOutputStream servletOutputStream = response.getOutputStream();
        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson((List<Course>) findCoursesService.findObjectInDaoCall().orElse(new ArrayList<>()));
        servletOutputStream.print(output);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        extractConnectionFromHttpSession(request);
        CreateNewObjectInDaoCallService createNewObjectInDaoCallService = newCreateNewObjectService();
        response.setContentType("application/json");
        ServletOutputStream servletOutputStream = response.getOutputStream();
        printResultByOptionalInteger(createNewObjectInDaoCallService.createNewObjectInDaoCall(getCourseFromRequest(request)), servletOutputStream);
    }

    @Override
    public FindObjectInDaoCallService newFindObjectService() {
        return new FindActiveCoursesServiceImpl();
    }

    @Override
    public CreateNewObjectInDaoCallService newCreateNewObjectService() {
        return new CreateNewCourseServiceImpl();
    }

    public JsonDeserializer createJsonDeserializerInstance() {
        return new JsonDeserializer();
    }

    private Course getCourseFromRequest(HttpServletRequest request) throws IOException{
        JsonDeserializer jsonDeserializer = createJsonDeserializerInstance();
        return  jsonDeserializer.convertToObject(request.getReader());
    }

    private void printResultByOptionalInteger(Optional<Integer> numberCoursesAdded,
                                              ServletOutputStream servletOutputStream) throws IOException {
        if (numberCoursesAdded.isPresent() && numberCoursesAdded.get().equals(1)) {
            servletOutputStream.print(SimpleResponseView.getOkResponse().getHtml());
        } else {
            servletOutputStream.print(SimpleResponseView.getKoResponse().getHtml());
        }
    }
}
