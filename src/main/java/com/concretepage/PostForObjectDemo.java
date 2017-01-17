package com.concretepage;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class PostForObjectDemo {
    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String url = "http://192.168.0.102:8070/ControleGastosService"+"/login/auth/";
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "admin");
        Usuario user = new Usuario(null,"admin", "123", null, null);
        Usuario usuario= restTemplate.postForObject(url, user, Usuario.class, map);
        System.out.println(usuario.getNome());
        System.out.println(usuario.getIdUsuario());


    }
}
 