package com.example.demo.controller;

import com.example.demo.model.PersonModel;
import com.example.demo.service.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonServiceImpl service;

    @GetMapping("/getAll")
    public List<PersonModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{identity}")
    public PersonModel getById(@PathVariable Long identity) {
        return service.getById(identity);
    }

    @PostMapping("/save")
    public PersonModel save(@RequestBody PersonModel model) {
        return service.save(model);
    }

    @PutMapping("/update")
    public PersonModel update(@RequestBody PersonModel model) {
        return service.update(model);
    }

    @DeleteMapping("/delete/{identity}")
    public PersonModel delete(@PathVariable Long identity) {
        return service.delete(identity);
    }
}