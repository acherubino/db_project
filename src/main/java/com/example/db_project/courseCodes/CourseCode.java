package com.example.db_project.courseCodes;

import com.example.db_project.courses.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course_codes")
public class CourseCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;

    @OneToMany(mappedBy = "code")
    @JsonIgnore
    private List<Course> courses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer courseCodeId) {
        this.id = courseCodeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
