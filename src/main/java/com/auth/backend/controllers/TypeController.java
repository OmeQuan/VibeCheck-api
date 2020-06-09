package com.auth.backend.controllers;

import com.auth.backend.models.Activity;
import com.auth.backend.models.Type;
import com.auth.backend.services.ActivityService;
import com.auth.backend.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/type")
public class TypeController {
    @Autowired
    TypeService typeService;

    @PostMapping
    Type create(@RequestBody Type type){
        return typeService.save(type);
    }

    @GetMapping
    Iterable<Type> read() { return typeService.findAll();}

    @PutMapping
    Type update(@RequestBody Type type) {
        return typeService.save(type);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id) {typeService.deleteById(id); }
}
