package br.senac.tads.juan.exemplosspringmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/exemplo")
public class ExemploController {
    @GetMapping("/mensagem")
    public String saudar1(Model modelo){
        return "message-view";
    }

    @GetMapping("/mensagem2")
    public ModelAndView saudar2(){
        return new ModelAndView("message-view");
    }

    @GetMapping("/exemplo-request-param")
    public ModelAndView exemploRequestParam(@RequestParam(value = "param1str", required = true, defaultValue = "valor") String param1,
                                            @RequestParam(value = "param2int", required = false, defaultValue = "99") int param2)
    {
        ModelAndView resposta = new ModelAndView("view-exemplo");
        return resposta;
    }

    @GetMapping("/exemplo-path-var/{param1str}/{param2int}")
    public ModelAndView exemploPathVariable(@PathVariable(value = "param1str", required = true) String param1,
                                            @PathVariable(value = "param2int", required = false) int param2)
    {
        ModelAndView resposta = new ModelAndView("view-exemplo");
        return resposta;
    }

    @GetMapping("exemplo-view-obj")
    public ModelAndView exemploViewObk()
    {
        ModelAndView mv = new ModelAndView("view-exemplo");
        List<Integer> f = new ArrayList<>();
        f.add(2);
        f.add(3);
        f.add(4);
        f.add(5);
        f.add(6);
        mv.addObject("texto", "Texto gerado no controller v2");
        mv.addObject("numero", 100);
        mv.addObject("dataHora", LocalDateTime.now());
        mv.addObject("lista", f);
        return mv;
    }
}
