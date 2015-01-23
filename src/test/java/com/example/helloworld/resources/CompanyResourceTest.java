package com.example.helloworld.resources;

import com.example.helloworld.HelloWorldApplication;
import com.example.helloworld.HelloWorldConfiguration;
import com.example.helloworld.core.Company;
import com.google.common.io.Resources;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.ClassRule;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CompanyResourceTest {

    @ClassRule
    public static final DropwizardAppRule<HelloWorldConfiguration> RULE = new DropwizardAppRule<>(HelloWorldApplication.class, resourceFilePath("hello-world.yml"));

    @Test
    public void shouldCreateANewCompany() {
        Client client = new Client();
        Company company = new Company("my company");
        ClientResponse response = client.resource(String.format("http://localhost:%d/company", RULE.getLocalPort()))
                .header("Content-Type", "application/json")
                .post(ClientResponse.class, company);

        assertThat(response.getStatus(), is(201));
        Company newCompany = response.getEntity(Company.class);
        assertThat(newCompany.getId(), is(not(0l)));
    }


    public static String resourceFilePath(String resourceClassPathLocation) {
        try {
            return new File(Resources.getResource(resourceClassPathLocation).toURI()).getAbsolutePath();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
