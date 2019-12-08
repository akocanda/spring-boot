package com.geocoder.client;

import com.geocoder.domain.GeocoderResult;
import org.apache.tomcat.jni.Address;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

@Service
/**
 * Look for tutorials on Hashmap, ArrayList and List
 */
public class GeocoderService {
    private final static String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    RestTemplate restTemplate;

    public GeocoderService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Map<String, String> getCoordinates(String street, String city, String state) {
        String addressParameters = String.join(",", asList(street, city, state));
        GeocoderResult geocoderResult = restTemplate.getForObject(BASE_URL + addressParameters, GeocoderResult.class);
        String latitude = String.valueOf(geocoderResult.getLocation().getLat());
        String longitude = String.valueOf(geocoderResult.getLocation().getLng());

        Map<String, String> coordinates = new HashMap<>();
        coordinates.put(latitude, longitude);
        return coordinates;
    }
}
