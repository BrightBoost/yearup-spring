package com.yearup.demo.services;

import com.yearup.demo.models.Course;
import com.yearup.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // get all
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // get by id
    public Course getCourseById(long id){
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if(optionalCourse.isPresent()){
            return optionalCourse.get();
        }
        return null;
    }

    public List<Course> getCoursesByName(String name) {
        return courseRepository.findByName(name);
    }

    // adding a course
    public Course addCourse (Course course){
        return courseRepository.save(course);
    }

    // updating a course
    public boolean updateCourse(Course course, long id) {
        Course courseToBeUpdated = getCourseById(id);
        if(courseToBeUpdated != null) {
            courseToBeUpdated.setName(course.getName());
            courseToBeUpdated.setDescription(course.getDescription());
            courseToBeUpdated.setAvgGrade(course.getAvgGrade());
            courseRepository.save(courseToBeUpdated);
            return true;
        } else {
            return false;
        }
    }

    // deleting a course
    public void deleteCourseById(long id) {
        courseRepository.deleteById(id);
    }
}
