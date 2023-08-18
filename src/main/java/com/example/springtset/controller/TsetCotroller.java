package com.example.springtset.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TsetCotroller {
    @GetMapping("/getName")
    public String getName(Model model){
        model.addAttribute("name","参数");
        return "index";
    }
    @GetMapping("/getAge")
    public String getAge(Model model){
        model.addAttribute("age","参数2");
        return "index";
    }
    @GetMapping("/Add")
    public String Add(Model model){
        model.addAttribute("add","测试3");
        return "add";
    }
}
