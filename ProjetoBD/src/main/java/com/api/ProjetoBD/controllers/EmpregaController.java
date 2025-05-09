package com.api.ProjetoBD.controllers;

import com.api.ProjetoBD.DAOs.EmpregaDAO;
import com.api.ProjetoBD.models.Emprega;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/emprega")
public class EmpregaController {

    private final EmpregaDAO empregaDAO;

    public EmpregaController(EmpregaDAO empregaDAO) {
        this.empregaDAO = empregaDAO;
    }

    // List all
    @GetMapping
    public String list(Model model) {
        model.addAttribute("empregas", empregaDAO.findAll());
        return "emprega/list";  // list.html
    }

    // Show create form
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("emprega", new Emprega());
        return "emprega/form";  // form.html
    }

    // Save new
    @PostMapping
    public String save(@ModelAttribute Emprega emp) {
        empregaDAO.save(emp);
        return "redirect:/emprega";
    }

    // Delete
    @GetMapping("/delete/{idFuncionario}/{idCorregedoria}")
    public String delete(@PathVariable String idFuncionario, @PathVariable int idCorregedoria) {
        empregaDAO.deleteByIds(idFuncionario, idCorregedoria);
        return "redirect:/emprega";
    }
}
