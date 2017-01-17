package com.concretepage;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Juliano Torquato on 28/11/2016.
 */

public class Test_Http {

    public static void main(String[] args) {
        //test_1();
        //test_2();
        //test_3();
        //test_post_save_1();
        //test_post_save_2();
        //test_post_save_3();
        //test_post_save_4();
        //test_get_all_1();
        //test_get_all_2();
        test_get_all_3();

    }
    //funcionou para login
    public static void test_1() {
        Usuario user = new Usuario("1", "1");
        final String url ="http://192.168.44.1:8070/ControleGastosService"+"/login/auth/{username}";
        RestTemplate restTemplate = new RestTemplate();
        // Add the Jackson and String message converters
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        // Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        Usuario response = restTemplate.getForObject(url, Usuario.class, "admin");
    }
    public static void test_2() {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String url = "http://192.168.0.102:8070/ControleGastosService"+"/login/auth/{username}/{password}";
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "admin");
        map.put("password", "123");
        Usuario user = new Usuario(null,"admin", "123", null, null);
        Usuario usuario= restTemplate.postForObject(url, user, Usuario.class, map);
        System.out.println(usuario.getNome());
        System.out.println(usuario.getIdUsuario());
    }
    public static void test_3() {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://192.168.0.102:8070/ControleGastosService"+"/login/auth";
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "admin");
        map.put("password", "123");
        Address address = new Address("Dhananjaypur", "Varanasi", "UP");
        ResponseEntity<Usuario> entity= restTemplate.postForEntity(url, address, Usuario.class, map);
        /*System.out.println(entity.getBody().getName());
        System.out.println(entity.getBody().getAddress().getVillage());*/
    }



    public static void test_post_save_1() {
        Usuario user = new Usuario("1", "1", new Date());
        final String url ="http://192.168.44.1:8070/ControleGastosService"+"/usuario/save";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(url, user, String.class, user);
        //String response = restTemplate.postForObject(url, user, String.class);
        System.out.print(response);
    }

    public static void test_post_save_2() {
        User user = new User(null,"admin", "123", null);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String url = "http://192.168.44.1:8070/ControleGastosService"+"/usuario/save";
        //String url = "http://192.168.44.1:8070/ControleGastosService"+"/usuario/save/{user}";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", user);
        map.put("dtNascimento", "07/05/1993");
        String usuario= restTemplate.postForObject(url, user, String.class, map);
    }
    public static void test_post_save_3() {
        String url = "http://192.168.44.1:8070/ControleGastosService"+"/usuario/save";
        Usuario user = new Usuario(null,"admin", "123", null, null);
        RestTemplate restTemplate = new RestTemplate();
        // Add the Jackson and String message converters
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        // Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        String response = restTemplate.postForObject(url, user, String.class);
    }
    public static void test_post_save_4() {
        User user = new User(null,"admin", "123", null);
        final String url ="http://192.168.44.1:8070/ControleGastosService"+"/usuario/save/{dtNascimento}/{user}";
        RestTemplate restTemplate = new RestTemplate();
        String person = restTemplate.postForObject(url, user, String.class, user, "07/05/1993");
        System.out.print(person);
    }
    public static void test_get_all_1() {
        final String url ="http://192.168.44.1:8070/ControleGastosService/movimentacao/categoria/all";
        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        template.getMessageConverters().add(new StringHttpMessageConverter());
        List list = template.getForObject(url, ArrayList.class);
        System.out.println(list);
    }
    public static void test_get_all_2() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        final String url ="http://192.168.44.1:8070/ControleGastosService/movimentacao/categoria/all";
        ResponseEntity<List<CategoriaMovimentacao>> rateResponse = restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<CategoriaMovimentacao>>() {
                        });
        List<CategoriaMovimentacao> rates = rateResponse.getBody();
    }
    public static void test_get_all_3() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        final String url ="http://192.168.44.1:8070/ControleGastosService/movimentacao/categoria/all";
        //ResponseEntity<List<CategoriaMovimentacao>> categorias = restTemplate.getForObject(url,ResponseEntity.class);
        CategoriaMovimentacao[] categorias = restTemplate.getForObject(url,CategoriaMovimentacao[].class);
        List<CategoriaMovimentacao> list =  Arrays.asList(categorias);
        System.out.println("Name:"+ Arrays.asList(categorias));
        System.out.println("Name:"+ list);
    }

}
