package service.impl;

import dao.CreateNewCourseDao;
import dao.impl.CreateNewCourseDaoImpl;
import dao.impl.JdbcBaseDaoImpl;
import model.Course;
import service.CreateNewObjectInDaoCallService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class CreateNewCourseServiceImpl implements CreateNewObjectInDaoCallService<Course> {

    private CreateNewCourseDao createNewCourseDao = new CreateNewCourseDaoImpl();

    @Override
    public Optional<Integer> createNewObjectInDaoCall(Course object) {
        try {
            return Optional.of(createNewCourseDao.createNewCourse(object));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
