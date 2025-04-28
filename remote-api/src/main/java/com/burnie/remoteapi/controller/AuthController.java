package com.burnie.remoteapi.controller;

import com.burnie.remoteapi.service.AuthService;
import com.burnie.remoteapi.vo.AuthVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final Map<String, AuthService> authServices;

    @PostMapping("")
    public AuthVo processIdentification(@RequestBody AuthVo authVo) {
        System.out.println("요청들어옴");
        try{
            Thread.sleep(Integer.parseInt(authVo.getSleepSeconds()) * 1000L);
        }catch (Exception e){

        }
        System.out.println("정상응답처리완료");
        return authServices.get(authVo.getApi().getServiceName()).processIdentification(authVo);
    }

    @GetMapping("/hello")
    public String hello(HttpSession httpSession) {
        if(httpSession.getAttribute("name") != null){
            return (String)httpSession.getAttribute("name");
        }
        httpSession.setAttribute("name", "good");
        return "set ok";

    }
}
