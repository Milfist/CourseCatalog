package service;

import dao.FindAllCoursesDao;
import dao.FindAllCoursesDaoImpl;
import dao.JdbcBaseDao;
import model.Course;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindAllCoursesServiceImpl implements FindAllCoursesService {

    Connection connection;
    FindAllCoursesDao findAllCoursesDao;

    public FindAllCoursesServiceImpl(Connection connection) {
        this.connection = connection;
        this.findAllCoursesDao = new FindAllCoursesDaoImpl(new JdbcBaseDao(this.connection));
    }

    @Override
    public List<Course> findAllCourse() {
        List<Course> courses = new ArrayList<>();
        try {
            courses = findAllCoursesDao.findAllCourses();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
