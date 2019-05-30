package com.example.demo.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@ControllerAdvice("com.example.demo")
public class ControllerAdvice0 {
    @ModelAttribute
    public void setAttr(Model model){
        model.addAttribute("setAttr","setAttrVal");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,
                false));
    }

    @ModelAttribute("returnMethod")
    public String returnAttr(){
        return "returnMethod:by returnAttr";
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handle(Exception ex, HttpServletRequest rq) {
        return ResponseEntity.ok().body("600");
    }
}
