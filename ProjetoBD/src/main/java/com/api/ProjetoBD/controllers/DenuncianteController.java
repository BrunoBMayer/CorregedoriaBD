package com.api.ProjetoBD.controllers;

import com.api.ProjetoBD.DAOs.DenuncianteDAO;
import com.api.ProjetoBD.models.Denunciante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/denunciantes")
public class DenuncianteController {

    private final DenuncianteDAO denuncianteDAO;

    public DenuncianteController(DenuncianteDAO denuncianteDAO) {
        this.denuncianteDAO = denuncianteDAO;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("denunciantes", denuncianteDAO.findAll());
        return "denunciantes/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("denunciante", new Denunciante());
        return "denunciantes/form";
    }

    @PostMapping
    public String save(@ModelAttribute Denunciante denunciante) {
        denuncianteDAO.save(denunciante);
        return "redirect:/denunciantes";
    }

    @GetMapping("/delete/{anonimo}")
    public String delete(@PathVariable boolean anonimo) {
        denuncianteDAO.deleteByAnonimo(anonimo);
        return "redirect:/denunciantes";
    }
}
