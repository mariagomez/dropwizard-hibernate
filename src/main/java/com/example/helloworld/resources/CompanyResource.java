package com.example.helloworld.resources;

import com.example.helloworld.core.Company;
import com.example.helloworld.dao.CompanyDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/company")
@Produces(MediaType.APPLICATION_JSON)
public class CompanyResource {

    private CompanyDAO companyDAO;

    public CompanyResource(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @POST
    @UnitOfWork
    public Response create(Company company) {
        Company newCompany = companyDAO.create(company);
        return Response.status(Response.Status.CREATED).entity(newCompany).build();
    }
}
