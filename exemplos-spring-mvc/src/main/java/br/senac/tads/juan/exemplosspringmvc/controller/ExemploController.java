package br.senac.tads.juan.exemplosspringmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exemplo")
public class ExemploController {
    @GetMapping("/mensagem")
    public String saudar1(Model modelo){
        return "message-view";
    }
}
