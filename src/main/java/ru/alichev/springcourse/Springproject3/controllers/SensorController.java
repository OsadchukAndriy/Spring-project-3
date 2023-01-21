package ru.alichev.springcourse.Springproject3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sensors")
public class SensorController {

    @PostMapping("/registration")
    public void registration(){

    }
}
