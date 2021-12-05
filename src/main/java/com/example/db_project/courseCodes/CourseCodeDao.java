package com.example.db_project.courseCodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CourseCodeDao {
    @Autowired
    CourseCodeRepository courseCodeRepository;
    @GetMapping("/api/courseCodes")
    public List<CourseCode> findAllCourseCodes() {
        return (List<CourseCode>) courseCodeRepository.findAll();
    }
    @GetMapping("/api/courseCodes/{courseCodeId}")
    public CourseCode findCourseCodeById(
            @PathVariable("courseCodeId") Integer courseCodeId) {
        return courseCodeRepository.findById(courseCodeId).get();
    }
    @GetMapping("/api/courseCodes/create")
    public CourseCode createCourseCodeTemplate() {
        CourseCode newCourseCode = new CourseCode();
        return newCourseCode;
    }
    @GetMapping("/api/courseCodes/create/{code}")
    public CourseCode createCourseCode(
            @PathVariable("code") String code) {
        CourseCode newCourseCode = new CourseCode();
        newCourseCode.setCode(code);
        return courseCodeRepository.save(newCourseCode);
    }
    @GetMapping("/api/courseCodes/{courseId}/{code}")
    public CourseCode updateCourseCode(
            @PathVariable("courseId") Integer courseId,
            @PathVariable("code") String code) {
        CourseCode courseCode = courseCodeRepository.findById(courseId).get();
        courseCode.setCode(code);
        return courseCodeRepository.save(courseCode);
    }
    @GetMapping("/api/courseCodes/{courseId}/delete")
    public List<CourseCode> deleteCourseCode(
            @PathVariable("courseId") Integer id) {
        courseCodeRepository.deleteById(id);
        return (List<CourseCode>) courseCodeRepository.findAll();
    }
}
