package com.concretepage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PostForEntityDemo {
    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/spring-rest-1/data/saveinfo/{id}/{name}";
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", "111");
        map.put("name", "Shyam");
		Address address = new Address("Dhananjaypur", "Varanasi", "UP");
        ResponseEntity<Person> entity= restTemplate.postForEntity(url, address, Person.class, map);
        System.out.println(entity.getBody().getName());
        System.out.println(entity.getBody().getAddress().getVillage());
    }
}
 