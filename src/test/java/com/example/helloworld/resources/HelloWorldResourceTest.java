package com.example.helloworld.resources;

import com.example.helloworld.core.Saying;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HelloWorldResourceTest {

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new HelloWorldResource("Hi %s", "You!"))
            .build();

    @Test
    public void shouldReturnTheDefaultMessageWhenNameIsNotPassed() {
        Saying saying = resources.client().resource("/hello-world/").get(Saying.class);

        assertThat(saying.getContent(), is("Hi You!"));
    }

    @Test
    public void shouldReturnTheMessageContainingTheNameThatIsPassed() {
        Saying saying = resources.client().resource("/hello-world/?name=Stranger").get(Saying.class);

        assertThat(saying.getContent(), is("Hi Stranger"));
    }
}
