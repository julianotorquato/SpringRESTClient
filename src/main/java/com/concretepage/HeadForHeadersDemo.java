package com.concretepage;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class HeadForHeadersDemo {
    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/spring-rest-1/data/fetch/{id}";
        HttpHeaders httpHeaders = restTemplate.headForHeaders(url, 100);
        System.out.println(httpHeaders.getContentLength());
        System.out.println(httpHeaders.getContentType());
    }
}
 