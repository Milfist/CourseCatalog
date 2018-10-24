package service;

import dao.CreateNewCourseDao;
import dao.CreateNewCourseDaoImpl;
import dao.JdbcBaseDao;
import model.Course;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class CreateNewCourseServiceImpl implements CreateNewCourseService {

    Connection connection;
    CreateNewCourseDao createNewCourseDao;

    public CreateNewCourseServiceImpl(Connection connection) {
        this.connection = connection;
        this.createNewCourseDao = new CreateNewCourseDaoImpl(new JdbcBaseDao(this.connection));
    }

    @Override
    public Optional<Integer> createNewCourse(Course course) {
        try {
            return Optional.of(createNewCourseDao.createNewCourse(course));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
