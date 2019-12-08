package com.oreilly.demo.integration;

import com.oreilly.demo.domain.Greeting;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.Objects;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * getObject -> (good if you don't want to test response status or mediatype)
 * exchange -> Requires you pass in body and heads (good for requests taking json)
 * getEntity (Only needs to know object being passed back (good for requests with request param's)
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @ParameterizedTest
    @ValueSource(strings = {"", "Ashley Kocanda"})
    void shouldReturnGreeting(String name) {
        String expectedGreeting = name.isEmpty() ? String.format("Hello, %s !","World") : String.format("Hello, %s !", name);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>("", headers);

        ResponseEntity<Greeting> greetingResponseEntity =
                testRestTemplate.exchange(
                        "/rest?name=" + name, HttpMethod.GET, httpEntity, Greeting.class);

        String actualGreeting = Objects.requireNonNull(greetingResponseEntity.getBody()).toString();

        assertThat(HttpStatus.OK).isEqualTo(greetingResponseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, greetingResponseEntity.getHeaders().getContentType());
        assertThat(actualGreeting).isEqualTo(expectedGreeting);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Ashley Kocanda"})
    void shouldReturnGreetingObject(String name) {
        String expectedGreeting = name.isEmpty() ? String.format("Hello, %s !","World") : String.format("Hello, %s !", name);

        Greeting actualGreeting = testRestTemplate.getForObject("/rest?name=" + name, Greeting.class);

        assertThat(expectedGreeting).isEqualTo(actualGreeting.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Ashley Kocanda"})
    void shouldReturnGreetingEntity(String name) {
        String expectedGreeting = name.isEmpty() ? String.format("Hello, %s !","World") : String.format("Hello, %s !", name);

        ResponseEntity<Greeting> actualGreeting = testRestTemplate.getForEntity("/rest?name=" + name, Greeting.class);

        assertThat(expectedGreeting).isEqualTo(Objects.requireNonNull(actualGreeting.getBody()).toString());
    }
}
