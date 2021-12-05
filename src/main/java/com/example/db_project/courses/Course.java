package com.example.db_project.courses;

import com.example.db_project.assignments.Assignment;
import com.example.db_project.courseCodes.CourseCode;
import com.example.db_project.registrations.Registration;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    private String name;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Registration> registrations;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Assignment> assignments;

    @ManyToOne
    private CourseCode code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer courseId) {
        this.id = courseId;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CourseCode getCode() {
        return code;
    }

    public void setCode(CourseCode code) {
        this.code = code;
    }
}
