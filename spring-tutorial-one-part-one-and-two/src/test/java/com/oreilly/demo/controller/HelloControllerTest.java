package com.oreilly.demo.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.assertj.core.api.Assertions.assertThat;

//https://www.baeldung.com/parameterized-tests-junit-5
// Parameterized Test and using CSV Source to pass in multiple values
class HelloControllerTest {

    HelloController subject = new HelloController();

    @ParameterizedTest
    @CsvSource({"Ashley Kocanda, Ashley Kocanda", "World,World"})
    void sayHello(String inputName, String expectedName) {
        Model model = new BindingAwareModelMap();
        if(inputName.isEmpty()) {
            subject.sayHello(null, model);
        }
        String actualName = subject.sayHello(inputName, model);
        assertThat(expectedName).isEqualTo(model.asMap().get("user"));
        assertThat(actualName).isNotNull();
    }
}