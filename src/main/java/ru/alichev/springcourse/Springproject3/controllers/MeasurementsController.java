package ru.alichev.springcourse.Springproject3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/measurements")
public class MeasurementsController {

    @PostMapping("/add")
    public void add(){

    }

    @GetMapping
    public void getMeasurements(){

    }

    @GetMapping("/rainyDaysCount")
    public int getRainyDaysCount(){
        return 0;
    }
}
