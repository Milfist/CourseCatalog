package service.impl;

import dao.FindActiveCoursesDao;
import dao.impl.FindAllCoursesDaoImpl;
import dao.impl.JdbcBaseDaoImpl;
import model.Course;
import service.FindObjectInDaoCallService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FindActiveCoursesServiceImpl implements FindObjectInDaoCallService<Course> {

    private FindActiveCoursesDao findAllCoursesDao;

    public FindActiveCoursesServiceImpl() {
        this.findAllCoursesDao = new FindAllCoursesDaoImpl();
    }

    @Override
    public Optional<List<Course>> findObjectInDaoCall() {
        try {
            return Optional.of(findAllCoursesDao.findActiveCourses());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
