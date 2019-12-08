package com.joker.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JokeServiceTest {
    @Autowired
    private JokeService service;

    @ParameterizedTest
    @CsvSource({"Chuck,Norris", "Priyanka,Chopra"})
    public void getJoke(String firstName, String lastName) {
        String joke = service.getJoke(firstName, lastName);
        assertTrue(joke.contains(firstName) ||
                joke.contains(lastName));
    }
}