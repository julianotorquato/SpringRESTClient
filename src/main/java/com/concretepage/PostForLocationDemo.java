package com.concretepage;

import java.net.URI;

import org.springframework.web.client.RestTemplate;

public class PostForLocationDemo {
    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/spring-rest-1/data/location/{id}/{name}";
		Address address = new Address("Dhananjaypur", "Varanasi", "UP");
		URI uri= restTemplate.postForLocation(url, address, 111, "Shyam");
		System.out.println(uri.getPath());
    }
}
 