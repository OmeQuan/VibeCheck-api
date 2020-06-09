package com.auth.backend.controllers;

import com.auth.backend.models.Day;
import com.auth.backend.services.DayService;
import com.auth.backend.util.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path="/api/day")
public class DayController{
    @Autowired
    DayService dayService;

    @PostMapping("")
    Day create(@RequestBody Day day) throws ValidationException {
        if (day.getDate() != null)
            return dayService.save(day);
        else throw new ValidationException("no date is set");
    }


    //ToDo, clean up to own controller
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    ErrorMessage exceptionHandler(ValidationException e) {
        return new ErrorMessage("400", e.getMessage());
    }

    //@CrossOrigin(origins = "http://localhost:8085/", maxAge = 3600)
    @GetMapping("")
    Iterable<Day> read() {
        return dayService.findAll();
    }

    @PutMapping()
    Day update(@RequestBody Day day) {
        return dayService.save(day);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        dayService.deleteById(id);
    }

    @GetMapping("/{id}")
    Optional<Day> findById(@PathVariable Long id){
        return dayService.findById(id);
    }

    @GetMapping("/user")
    Iterable<Day> findByUser(
            @RequestParam("userId") Long userId)
    {
        return dayService.findByUserId(userId);
    }

    @GetMapping("/today")
    Day findByDate(
            @RequestParam("userId") Long userId,
            @RequestParam("date") String date)
    {
        Iterable<Day> days = dayService.findByUserId(userId);
        for(Day day : days) {
            if (day.checkDate().equals(date)){
                return day;
            }

        }

        throw new ValidationException("not found: " + days);
    }
}

