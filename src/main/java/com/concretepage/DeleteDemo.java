package com.concretepage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class DeleteDemo {
    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/spring-rest-1/data/delete/{name}/{village}";
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Mahesh");
        map.put("village", "Dhananjaypur");
        restTemplate.delete(url, map);
    }
}
