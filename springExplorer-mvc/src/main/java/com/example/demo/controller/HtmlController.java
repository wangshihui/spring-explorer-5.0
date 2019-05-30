package com.example.demo.controller;

import com.example.demo.Beans.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@Controller
public class HtmlController {
    @RequestMapping("/page0")
        public String page0(Model model, @RequestParam("date") Date date){
        model.addAttribute("test","test");
        System.out.println("complete2");
        System.out.println(date);
        System.out.println(model.asMap().get("returnMethod"));
        System.out.println(model.asMap().get("setAttr"));
        return "0.html";
    }

    @RequestMapping("/page2")
    public String page2(User user, Model model, @RequestParam("date") String date){
        model.addAttribute("test","test");
        System.out.println("complete2");
        System.out.println(date);
        System.out.println(model.asMap().get("returnMethod"));
        System.out.println(model.asMap().get("setAttr"));
        return "0.html";
    }



    @RequestMapping("/async3")
    public void asyncProc3(){
        System.out.println("complete3");
    }

    public ResponseEntity<String> handle(Exception ex, HttpServletRequest rq) {
        return ResponseEntity.ok().body("700");
    }
}
