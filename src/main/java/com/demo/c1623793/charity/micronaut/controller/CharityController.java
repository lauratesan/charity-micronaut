package com.demo.c1623793.charity.micronaut.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import com.demo.c1623793.charity.micronaut.pojo.Charity;
import com.demo.c1623793.charity.micronaut.service.CharityService;

import java.util.List;

@Controller
public class CharityController {

    private CharityService charityService;

    public CharityController(CharityService charityService) {
        this.charityService = charityService;
    }


    @Get("/charities")
    @Secured(SecurityRule.IS_ANONYMOUS)
    public List<Charity> getAll() {
        return charityService.getAllBooks();
    }

    @Get("/admin/charity")
    @Secured(SecurityRule.IS_AUTHENTICATED)
    public Charity addBook(@QueryValue("title") String title) {
        return charityService.addBook(title);
    }
}
