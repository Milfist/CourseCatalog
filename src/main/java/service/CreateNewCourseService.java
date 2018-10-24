package service;

import model.Course;

import java.util.Optional;

public interface CreateNewCourseService {
    Optional<Integer> createNewCourse(Course course);

}
