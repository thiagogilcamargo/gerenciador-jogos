package com.example.gerenciadorjogos.gerenciador_jogos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("home")
    public String home(){
        return "index";
    }

}