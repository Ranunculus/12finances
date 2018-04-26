package com.twelveweeks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    @PostMapping("/category/add")
    @ResponseBody
    public String addCategory(String categoryName) {
        return "ok";
    }
}
