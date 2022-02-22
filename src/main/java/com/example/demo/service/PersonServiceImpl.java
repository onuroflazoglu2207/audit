package com.example.demo.service;

import com.example.demo.model.PersonModel;
import com.example.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;


    @Override
    public List<PersonModel> getAll() {
        return repository.findAll();
    }

    @Override
    public PersonModel getById(Long identity) {
        Optional<PersonModel> optional = repository.findById(identity);
        return optional.isEmpty() ? null : optional.get();
    }

    @Override
    public PersonModel save(PersonModel model) {
        try {
            if (model.getIdentity() != null)
                return null;
            return repository.save(model);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PersonModel update(PersonModel model) {
        try {
            PersonModel temp = getById(model.getIdentity());
            if (temp == null) return null;
            temp.setName(model.getName());
            return repository.save(temp);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PersonModel delete(Long identity) {
        PersonModel model = getById(identity);
        if (model != null) repository.deleteById(identity);
        return model;
    }
}
