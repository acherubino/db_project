package com.example.db_project.assignments;

import com.example.db_project.courses.Course;
import com.example.db_project.courses.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AssignmentDao {
    @Autowired
    AssignmentRepository assignmentRepository;
    @Autowired
    CourseRepository courseRepository;
    @GetMapping("/api/assignments/{assignmentId}")
    public Assignment findAssignmentById(
            @PathVariable("assignmentId") Integer assignmentId) {
        return assignmentRepository.findById(assignmentId).get();
    }
    @GetMapping("/api/assignments")
    public List<Assignment> findAllAssignments() {
        return (List<Assignment>) assignmentRepository.findAll();
    }

    @GetMapping("/api/courses/{courseId}/assignments")
    public List<Assignment> findAssignmentsByCourse(
            @PathVariable("courseId") Integer courseId) {
        return courseRepository.findById(courseId).get()
                .getAssignments();
    }
    @GetMapping("/api/assignments/create")
    public Assignment createAssignmentTemplate() {
        Assignment newAssignment = new Assignment();
        return newAssignment;
    }
    @GetMapping("/api/assignments/create/{title}/{dueDate}/{course}")
    public Assignment createAssignment(
            @PathVariable("title") String title,
            @PathVariable("dueDate") Date dueDate,
            @PathVariable("course") Course course) {
        Assignment newAssignment = new Assignment();
        newAssignment.setTitle(title);
        newAssignment.setDueDate(dueDate);
        newAssignment.setCourse(course);
        return assignmentRepository.save(newAssignment);
    }
    @GetMapping("/api/assignments/{courseId}/{title}/{dueDate}/{course}")
    public Assignment updateAssignment(
            @PathVariable("courseId") Integer courseId,
            @PathVariable("title") String title,
            @PathVariable("dueDate") Date dueDate,
            @PathVariable("course") Course course) {
        Assignment assignment = assignmentRepository.findById(courseId).get();
        assignment.setTitle(title);
        assignment.setDueDate(dueDate);
        assignment.setCourse(course);
        return assignmentRepository.save(assignment);
    }
    @GetMapping("/api/assignments/{courseId}/delete")
    public List<Assignment> deleteAssignment(
            @PathVariable("courseId") Integer id) {
        assignmentRepository.deleteById(id);
        return (List<Assignment>) assignmentRepository.findAll();
    }
}
