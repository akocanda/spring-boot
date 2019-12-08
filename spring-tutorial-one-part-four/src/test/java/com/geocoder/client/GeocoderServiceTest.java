package com.geocoder.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GeocoderServiceTest {
    GeocoderService subject = new GeocoderService(new RestTemplateBuilder());

    @ParameterizedTest
    @CsvSource({"Westville, 706 Ann Drive, IL"})
    void getCoordinates(String city, String street, String state) {
        Map<String, String> locationCoordinates = subject.getCoordinates(city, street, state);
        assertNotNull(locationCoordinates);
    }
}