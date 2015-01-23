package com.example.helloworld;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExampleTest {

    @Test
    public void shouldPass() {
        assertThat(true, is(true));
    }

    @Test
    @Ignore
    public void shouldFail() {
        assertThat(true, is(false));
    }
}
