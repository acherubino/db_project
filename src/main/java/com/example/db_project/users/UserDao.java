package com.example.db_project.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserDao {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }
    @GetMapping("/api/users/{userId}")
    public User findUserById(
            @PathVariable("userId") Integer id) {
        return userRepository.findById(id).get();
    }
    @GetMapping("/api/users/create")
    public User createUserTemplate() {
        User newUser = new User();
        return newUser;
    }
    @GetMapping("/api/users/create/{uname}/{pword}/{fname}/{lname}/{email}/{dob}")
    public User createUser(
            @PathVariable("fname") String fname,
            @PathVariable("lname") String lname,
            @PathVariable("uname") String uname,
            @PathVariable("pword") String pword,
            @PathVariable("email") String email,
            @PathVariable("dob") Date dob) {
        User newUser = new User();
        newUser.setFirstName(fname);
        newUser.setLastName(lname);
        newUser.setUsername(uname);
        newUser.setPassword(pword);
        newUser.setEmail(email);
        newUser.setDob(dob);
        return userRepository.save(newUser);
    }
    @GetMapping("/api/users/{userId}/{fname}/{lname}/{uname}/{pword}/{email}/{dob}")
    public User updateUser(
            @PathVariable("userId") Integer id,
            @PathVariable("fname") String fname,
            @PathVariable("lname") String lname,
            @PathVariable("uname") String uname,
            @PathVariable("pword") String pword,
            @PathVariable("email") String email,
            @PathVariable("dob") Date dob) {
        User user = userRepository.findById(id).get();
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setUsername(uname);
        user.setPassword(pword);
        user.setEmail(email);
        user.setDob(dob);
        return userRepository.save(user);
    }
    @GetMapping("/api/users/{userId}/delete")
    public List<User> deleteUser(
            @PathVariable("userId") Integer id) {
        userRepository.deleteById(id);
        return (List<User>) userRepository.findAll();
    }
}
