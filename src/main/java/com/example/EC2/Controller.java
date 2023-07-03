package com.example.EC2;

import java.lang.String;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path="/")
public class Controller{

    @GetMapping(path="/")
    public String home (){
        return "AT75969192 - Lozano Jean";
    }

    @GetMapping(path="idat/codigo")
    public String codigo(){
        return "AT75969192";
    }

    @GetMapping(path="idat/nombre")
    public String nombre(){
        return "Lozano Curi Jean Carlos";
    }

}