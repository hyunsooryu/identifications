package com.burnie.idcardservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {


    @PostMapping({"/idcard/auth", "/api/idcard/auth"})
    public ResponseEntity<Map<String,String>> auth(@RequestBody Map<String,String> body) throws RestClientException{
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(20 * 1000);
        factory.setConnectTimeout(20 * 1000);

        restTemplate.setRequestFactory(factory);

        var response = restTemplate.postForEntity("http://127.0.0.1:7781/auth", body, Map.class);
        Map<String, String> resBody = response.getBody();
        if(ObjectUtils
                .isEmpty(resBody)) {
            return ResponseEntity.ok(Collections.singletonMap("resultYn", "N"));

        }
        return ResponseEntity.ok(Collections.singletonMap("resultYn", resBody.get("authResult")));
    }


    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<Map<String,String>> handleException(RestClientException ex) {
        System.out.println("Hello I am here");
        return ResponseEntity.ok().header("x-api-error-response", "true").body(Collections.singletonMap("message", ex.getMessage()));
    }


}
