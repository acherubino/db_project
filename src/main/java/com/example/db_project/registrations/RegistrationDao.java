package com.example.db_project.registrations;

import com.example.db_project.courses.Course;
import com.example.db_project.courses.CourseRepository;
import com.example.db_project.users.User;
import com.example.db_project.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RegistrationDao {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RegistrationRepository registrationRepository;
    @Autowired
    CourseRepository courseRepository;
    @GetMapping("/api/registrations/{registrationId}")
    public Registration findRegistrationById(
            @PathVariable("registrationId") Integer registrationId) {
        return registrationRepository.findById(registrationId).get();
    }
    @GetMapping("/api/registrations")
    public List<Registration> findAllRegistrations() {
        return (List<Registration>) registrationRepository.findAll();
    }
    @GetMapping("/api/users/{userId}/registrations")
    public List<Registration> findRegistrationsByUser(
            @PathVariable("userId") Integer id) {
        return userRepository.findById(id).get()
                .getRegistrations();
    }
    @GetMapping("/api/courses/{courseId}/registrations")
    public List<Registration> findRegistrationsByCourse(
            @PathVariable("courseId") Integer id) {
        return courseRepository.findById(id).get()
                .getRegistrations();
    }
    @GetMapping("/api/registrations/create")
    public Registration createRegistrationTemplate() {
        Registration newRegistration = new Registration();
        return newRegistration;
    }
    @GetMapping("/api/registrations/create/{user}/{course}")
    public Registration createRegistration(
            @PathVariable("user") User user,
            @PathVariable("course") Course course) {
        Registration newRegistration = new Registration();
        newRegistration.setUser(user);
        newRegistration.setCourse(course);
        return registrationRepository.save(newRegistration);
    }
    @GetMapping("/api/registrations/{registrationId}/{user}/{course}")
    public Registration updateRegistration(
            @PathVariable("registrationId") Integer id,
            @PathVariable("user") User user,
            @PathVariable("course") Course course) {
        Registration registration = registrationRepository.findById(id).get();
        registration.setUser(user);
        registration.setCourse(course);
        return registrationRepository.save(registration);
    }
    @GetMapping("/api/registrations/{registrationId}/delete")
    public List<Registration> deleteRegistration(
            @PathVariable("registrationId") Integer id) {
        registrationRepository.deleteById(id);
        return (List<Registration>) registrationRepository.findAll();
    }
}
