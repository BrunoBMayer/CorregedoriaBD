package com.api.ProjetoBD.controllers;

import com.api.ProjetoBD.DAOs.SecretariaDAO;
import com.api.ProjetoBD.models.Secretaria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/secretarias")
public class SecretariaController {

    private final SecretariaDAO secretariaDAO;

    public SecretariaController(SecretariaDAO secretariaDAO) {
        this.secretariaDAO = secretariaDAO;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("secretarias", secretariaDAO.findAll());
        return "secretarias/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("secretaria", new Secretaria());
        return "secretarias/form";
    }

    @PostMapping
    public String save(@ModelAttribute Secretaria sec) {
        secretariaDAO.save(sec);
        return "redirect:/secretarias";
    }

    @GetMapping("/delete/{matricula}")
    public String delete(@PathVariable String matricula) {
        secretariaDAO.deleteByMatricula(matricula);
        return "redirect:/secretarias";
    }
}
