package dao;

import model.Course;

import java.sql.SQLException;
import java.util.List;

public interface FindActiveCoursesDao {
    List<Course> findActiveCourses() throws SQLException;
}
