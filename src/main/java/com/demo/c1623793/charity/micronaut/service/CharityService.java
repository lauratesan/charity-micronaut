package com.demo.c1623793.charity.micronaut.service;

import com.demo.c1623793.charity.micronaut.pojo.Charity;
import com.demo.c1623793.charity.micronaut.repository.CharityRepository;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class CharityService {

    private CharityRepository charityRepository;

    public CharityService(CharityRepository charityRepository) {
        this.charityRepository = charityRepository;
    }

    public List<Charity> getAllBooks() {
        return charityRepository.findAll();
    }

    public Charity addBook(String title) {
        return charityRepository.save(title);
    }
}
