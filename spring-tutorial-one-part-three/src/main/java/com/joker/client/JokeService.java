package com.joker.client;

import com.joker.domain.JokeResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {
    private final static String BASE_URL = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";
    RestTemplate restTemplate;

    public JokeService(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public String getJoke(String firstName, String lastName) {
        String url = String.format("%s&firstName=%s&lastName=%s", BASE_URL, firstName, lastName);;
        JokeResponse jokeResponse = restTemplate.getForObject(url, JokeResponse.class);
        String joke = jokeResponse != null ? jokeResponse.getValue().getJoke() : "API call failed";
        System.out.println("Here is the joke " + joke);
        return joke;
    }
}
