package com.auth.backend.controllers;

import com.auth.backend.models.Day;
import com.auth.backend.models.User;
import com.auth.backend.repositories.DayRepository;
import com.auth.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private DayRepository dayRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public LocalTime allAccess() {
        return LocalTime.parse("12:00:00");
    }

    @GetMapping(path="/users")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path="/user")
    public @ResponseBody
    Optional<User> findByUserId() {
        long id = 1;
        // This returns a JSON or XML with the users
        return userRepository.findById(id);
    }

    @GetMapping(path="/day")
    public @ResponseBody
    Optional<Day> findByDayId() {
        long id = 1;
        Optional<Day> result = dayRepository.findById(id);
        return result;
    }

    @GetMapping(path = "/days")
    public @ResponseBody
    Iterable<Day> getAllDays() {
        List<Day> days = dayRepository.findAll();
        return days;
    }


}