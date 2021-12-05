package com.example.db_project.registrations;

import com.example.db_project.courses.Course;
import com.example.db_project.users.User;

import javax.persistence.*;

@Entity
@Table(name = "registrations")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer registrationId) {
        this.id = registrationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User registeredBy) {
        this.user = registeredBy;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course registeredFor) {
        this.course = registeredFor;
    }

}
