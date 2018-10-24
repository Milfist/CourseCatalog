package service;

import dao.FindAllCoursesDao;
import dao.FindAllCoursesDaoImpl;
import dao.JdbcBaseDao;
import model.Course;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindAllCoursesServiceImpl implements FindAllCoursesService {

    Connection connection;
    FindAllCoursesDao findAllCoursesDao;

    public FindAllCoursesServiceImpl(Connection connection) {
        this.connection = connection;
        this.findAllCoursesDao = new FindAllCoursesDaoImpl(new JdbcBaseDao(this.connection));
    }

    @Override
    public Optional<List<Course>> findAllCourse() {
        try {
            return Optional.of(findAllCoursesDao.findAllCourses());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
