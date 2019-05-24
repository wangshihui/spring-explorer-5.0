package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@ControllerAdvice
public class RequestProc2 {
    @RequestMapping("/test2")
    public String test() throws Exception{
        throw  new Exception("2131231");

    }
    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handle(Exception ex, HttpServletRequest rq) {
        return ResponseEntity.ok().body("600");
    }
}
