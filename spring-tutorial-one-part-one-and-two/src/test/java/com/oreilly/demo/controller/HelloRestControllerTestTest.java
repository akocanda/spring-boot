package com.oreilly.demo.controller;

import com.oreilly.demo.domain.Greeting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class HelloRestControllerTestTest {
        HelloRestController subject = new HelloRestController();

        @ParameterizedTest
        @ValueSource(strings = {"Ashley Kocanda", "Steve Racht", "Aloe Vera"})
        public void shouldReturnGreeting(String name){
            //Given
            String expectedGreeting = String.format("Hello, %s !", name);

            //When
            Greeting actualGreeting = subject.greet(name);

            //Then
            assertThat(expectedGreeting).isEqualTo(actualGreeting.toString());
        }
}