package com.concretepage;

import org.springframework.web.client.RestTemplate;

public class GetForObjectDemoWithJSON {
    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        //Person person = restTemplate.getForObject("http://localhost:8070/ControleGastosService/conta/{id}", Person.class, 2);
        Conta person = restTemplate.getForObject("http://localhost:8070/ControleGastosService/conta/{id}", Conta.class, 2);
        System.out.println("ID: " + person.getIdConta());
        System.out.println("Name: " + person.getNome());
        //System.out.println("Village Name: " + person.getAddress().getVillage());
    }
}
