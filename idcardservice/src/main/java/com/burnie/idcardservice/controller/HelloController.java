package com.burnie.idcardservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.Random;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false, name = "point") Integer point) {
        if(point % 2 == 0){
            throw new RuntimeException("짝수 포인트는 보내지마세요");
        }else{
            return "hello";
        }
    }


    @ExceptionHandler
    public ResponseEntity<Map<String,String>> handleException(Exception ex) {
       return ResponseEntity.ok().header("x-api-error-response", "true").body(Collections.singletonMap("message", ex.getMessage()));
    }

}
