package com.example.demo.service;

import com.example.demo.model.PersonModel;

import java.util.List;

public interface PersonService {
    public List<PersonModel> getAll();

    public PersonModel getById(Long identity);

    public PersonModel save(PersonModel model);

    public PersonModel update(PersonModel model);

    public PersonModel delete(Long identity);
}
