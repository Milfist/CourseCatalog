package dao;

import model.Course;
import model.Level;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindAllCoursesDaoImpl implements FindAllCoursesDao {

    private static final StringBuilder SELECT_ALL_FROM_COURSE =  new StringBuilder("SELECT ")
            .append("TITLE, DURATION, IS_ACTIVE, COURSE_LEVEL ")
            .append("FROM COURSE ")
            .append("WHERE IS_ACTIVE = TRUE ")
            .append("ORDER BY TITLE DESC");

    private JdbcBaseDao jdbcBaseDao;

    public FindAllCoursesDaoImpl(JdbcBaseDao jdbcBaseDao) {
        this.jdbcBaseDao = jdbcBaseDao;
    }


    @Override
    public List<Course> findAllCourses() throws SQLException {

        ResultSet resultSet = jdbcBaseDao.getResulset(SELECT_ALL_FROM_COURSE.toString());
        List<Course> courses = new ArrayList<>();

        while (resultSet.next()) {
            Course course = new Course(
                    resultSet.getString("TITLE"),
                    resultSet.getInt("DURATION"),
                    resultSet.getBoolean("IS_ACTIVE"),
                    Level.valueOf(resultSet.getString("COURSE_LEVEL")));

            courses.add(course);
        }

        return courses;
    }
}
