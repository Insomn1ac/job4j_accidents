package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.service.AccidentService;

@Controller
public class IndexController {
    private final AccidentService service;

    public IndexController(AccidentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", "Пётр Арсентьев");
        model.addAttribute("accidents", service.findAll());
        return "index";
    }
}
