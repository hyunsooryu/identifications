package com.burnie.gateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

@RestController
public class FailController {

    @RequestMapping(value = "/fallback")
    public ResponseEntity<String> fallback(ServerWebExchange exchange){
        String error = (String) exchange.getAttribute("error");
        System.out.println(error);
        return ResponseEntity.status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED).body("error");
    }
}
