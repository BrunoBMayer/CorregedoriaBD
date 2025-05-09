package com.api.ProjetoBD.controllers;

import com.api.ProjetoBD.DAOs.FuncionarioDAO;
import com.api.ProjetoBD.models.Funcionario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioDAO funcionarioDAO;

    public FuncionarioController(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    // List all
    @GetMapping
    public String list(Model model) {
        model.addAttribute("funcionarios", funcionarioDAO.findAll());
        return "funcionarios/list";  // list.html
    }

    // Show create form
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "funcionarios/form";  // form.html
    }

    // Save new
    @PostMapping
    public String save(@ModelAttribute Funcionario funcionario) {
        funcionarioDAO.save(funcionario);
        return "redirect:/funcionarios";
    }

    // Edit form
    @GetMapping("/edit/{matricula}")
    public String edit(@PathVariable String matricula, Model model) {
        model.addAttribute("funcionario", funcionarioDAO.findByMatricula(matricula));
        return "funcionarios/form";  // reuse the form
    }

    // Update existing
    @PostMapping("/update")
    public String update(@ModelAttribute Funcionario funcionario) {
        funcionarioDAO.update(funcionario);
        return "redirect:/funcionarios";
    }

    // Delete
    @GetMapping("/delete/{matricula}")
    public String delete(@PathVariable String matricula) {
        funcionarioDAO.deleteByMatricula(matricula);
        return "redirect:/funcionarios";
    }
}

