package com.demo.c1623793.charity.micronaut.repository;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.runtime.ApplicationConfiguration;
import io.micronaut.spring.tx.annotation.Transactional;
import com.demo.c1623793.charity.micronaut.pojo.Charity;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Singleton
public class CharityRepository {

    @PersistenceContext
    private EntityManager entityManager;
    private final ApplicationConfiguration applicationConfiguration;

    public CharityRepository(@CurrentSession EntityManager entityManager,
                             ApplicationConfiguration applicationConfiguration) {
        this.entityManager = entityManager;
        this.applicationConfiguration = applicationConfiguration;
    }

    @Transactional(readOnly = true)
    public List<Charity> findAll() {
        String sqlString = "Select o from Charity as o";
        TypedQuery<Charity> query = entityManager.createQuery(sqlString, Charity.class);
        return query.getResultList();
    }

    @Transactional
    public Charity save(String title) {
        Charity charity = new Charity();
        charity.setTitle(title);
        entityManager.persist(charity);

        return charity;
    }
}
