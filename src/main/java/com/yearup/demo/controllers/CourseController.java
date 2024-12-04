package com.yearup.demo.controllers;

import com.yearup.demo.models.Course;
import com.yearup.demo.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // get all courses
    @GetMapping
    public ResponseEntity<List<Course>> getCourses(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    // get course by id
    @GetMapping("{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable long id){
        Course courseFound = courseService.getCourseById(id);
        if(courseFound == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(courseFound);
    }

    // get course by name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Course>> getCourseByName(@PathVariable String name) {
        return ResponseEntity.ok(courseService.getCoursesByName(name));
    }

    // add a course
    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        if(course.getId() != 0) {
            return ResponseEntity.badRequest().build();
        }
        Course newCourse = courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCourse);
    }

    // update a course
    @PutMapping("{id}")
    public ResponseEntity<Void> updateCourse(@RequestBody Course course,@PathVariable long id ){
        boolean success = courseService.updateCourse(course,id);
        if(success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete a course
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable long id){
        courseService.deleteCourseById(id);
        return ResponseEntity.ok().build();
    }
}
