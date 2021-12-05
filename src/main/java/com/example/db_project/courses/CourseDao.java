package com.example.db_project.courses;

import com.example.db_project.courseCodes.CourseCode;
import com.example.db_project.courseCodes.CourseCodeRepository;
import com.example.db_project.registrations.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CourseDao {
    @Autowired
    RegistrationRepository registrationRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseCodeRepository courseCodeRepository;
    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }
    @GetMapping("/api/courses/{courseId}")
    public Course findCourseById(
            @PathVariable("courseId") Integer courseId) {
        return courseRepository.findById(courseId).get();
    }
    @GetMapping("/api/courseCodes/{courseCodeId}/courses")
    public List<Course> findCoursesByCourseCode(
            @PathVariable("courseCodeId") Integer courseCodeId) {
        return courseCodeRepository.findById(courseCodeId).get()
                .getCourses();
    }
    @GetMapping("/api/courses/create")
    public Course createCourseTemplate() {
        Course newCourse = new Course();
        return newCourse;
    }
    @GetMapping("/api/courses/create/{number}/{name}/{code}")
    public Course createCourse(
            @PathVariable("code") CourseCode code,
            @PathVariable("number") Integer number,
            @PathVariable("name") String name) {
        Course newCourse = new Course();
        newCourse.setCode(code);
        newCourse.setNumber(number);
        newCourse.setName(name);
        return courseRepository.save(newCourse);
    }
    @GetMapping("/api/courses/{courseId}/{number}/{name}/{code}")
    public Course updateCourse(
            @PathVariable("courseId") Integer courseId,
            @PathVariable("code") CourseCode code,
            @PathVariable("number") Integer number,
            @PathVariable("name") String name) {
        Course course = courseRepository.findById(courseId).get();
        course.setCode(code);
        course.setNumber(number);
        course.setName(name);
        return courseRepository.save(course);
    }
    @GetMapping("/api/courses/{courseId}/delete")
    public List<Course> deleteCourse(
            @PathVariable("courseId") Integer id) {
        courseRepository.deleteById(id);
        return (List<Course>) courseRepository.findAll();
    }
}
