package com.auth.backend.controllers;

import com.auth.backend.models.Activity;
import com.auth.backend.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/activity")
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @PostMapping
    Activity create(@RequestBody Activity activity){
        return activityService.save(activity);
    }

    @GetMapping
    Iterable<Activity> read() { return activityService.findAll();}

    @PutMapping
    Activity update(@RequestBody Activity activity) {
        return activityService.save(activity);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id) {activityService.deleteById(id); }

    @GetMapping(path = "/{id}")
    Iterable<Activity> findByDayId(
            @PathVariable Long id)
    {
        return activityService.findByDayId(id);
    }


}
