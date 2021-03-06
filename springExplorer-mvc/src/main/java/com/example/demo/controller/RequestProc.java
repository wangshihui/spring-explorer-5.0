package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class RequestProc {
    @RequestMapping("/test")
    public String test() throws IOException{
        throw  new IOException("1");

    }
    @RequestMapping("/test2")
    public String test2() throws Exception{
        throw  new Exception("2131231");

    }
    @RequestMapping("/test3")
    public String test3() throws Exception{
        throw  new Exception(new IOException("3",new Exception("0")));

    }

    @RequestMapping("/test4")
    public String test4() throws Exception{
        throw  new Exception();

    }

    @RequestMapping("/test5")
    public String test5() throws Exception{
        throw  new Exception(new RuntimeException("RuntimeException",new IOException("5")));

    }

//    @ExceptionHandler
//    public ResponseEntity<String> handle(RuntimeException ex, HttpServletRequest rq) {
//        System.out.println(ex.getCause());
//        return ResponseEntity.ok().body("500");
//    }
}
