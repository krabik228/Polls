package com.rschir.kursach.controllers;

import com.rschir.kursach.models.Opros;
import com.rschir.kursach.repo.OprosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private OprosRepository oprosRepository;
    @GetMapping("/")
    public String home(Model model) {
        Iterable<Opros> oprosi = oprosRepository.findAll();
        model.addAttribute("oprosi", oprosi);
        return "home";
    }

    @GetMapping("/add")
    public String oprosAdd(Model model) {
        return "opros-add";
    }

    @PostMapping("/add")
    public String oprosAdding(@RequestParam String title, @RequestParam String text, @RequestParam String otv1, @RequestParam String otv2, Model model) {
        Opros opros = new Opros(title, text, otv1, otv2);
        oprosRepository.save(opros);
        return "redirect:/";
    }

    @PostMapping ("/")
    public String oprosStats(@RequestParam String id, @RequestParam("otv") String first, Model model) {
        Opros opros = oprosRepository.findById(Long.valueOf(id)).orElseThrow();
        if (Objects.equals(first, "first")) {
            opros.setStats1(opros.getStats1() + 1);
        } else {
            opros.setStats2(opros.getStats2() + 1);
        }
        oprosRepository.save(opros);
        return "redirect:/";
    }
}