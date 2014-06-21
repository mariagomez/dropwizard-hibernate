package com.example.helloworld;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExampleTest {

    @Test
    public void shouldPass() {
        assertThat(true, is(true));
    }

    @Test
    public void shouldFail() {
        assertThat(true, is(false));
    }
}
