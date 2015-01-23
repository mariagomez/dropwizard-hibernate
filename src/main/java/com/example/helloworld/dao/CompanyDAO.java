package com.example.helloworld.dao;

import com.example.helloworld.core.Company;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class CompanyDAO extends AbstractDAO<Company> {

    public CompanyDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Company create(Company company) {
        return persist(company);
    }
}
