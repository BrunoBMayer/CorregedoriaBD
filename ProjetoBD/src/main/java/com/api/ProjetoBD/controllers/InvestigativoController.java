package com.api.ProjetoBD.controllers;

import com.api.ProjetoBD.DAOs.InvestigativoDAO;
import com.api.ProjetoBD.models.Investigativo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/investigativos")
public class InvestigativoController {

    private final InvestigativoDAO investigativoDAO;

    public InvestigativoController(InvestigativoDAO investigativoDAO) {
        this.investigativoDAO = investigativoDAO;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("investigativos", investigativoDAO.findAll());
        return "investigativos/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("investigativo", new Investigativo());
        return "investigativos/form";
    }

    @PostMapping
    public String save(@ModelAttribute Investigativo inv) {
        investigativoDAO.save(inv);
        return "redirect:/investigativos";
    }

    @GetMapping("/delete/{matricula}")
    public String delete(@PathVariable String matricula) {
        investigativoDAO.deleteByMatricula(matricula);
        return "redirect:/investigativos";
    }
}
