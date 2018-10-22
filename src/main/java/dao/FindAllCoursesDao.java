package dao;

import model.Course;

import java.sql.SQLException;
import java.util.List;

public interface FindAllCoursesDao {
    List<Course> findAllCourses() throws SQLException;
}
