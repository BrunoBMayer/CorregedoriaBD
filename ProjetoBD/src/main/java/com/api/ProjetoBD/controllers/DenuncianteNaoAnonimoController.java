package com.api.ProjetoBD.controllers;

import com.api.ProjetoBD.DAOs.DenuncianteNaoAnonimoDAO;
import com.api.ProjetoBD.models.DenuncianteNaoAnonimo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/denunciantesnaoanonimos")
public class DenuncianteNaoAnonimoController {

    private final DenuncianteNaoAnonimoDAO denuncianteNaoAnonimoDAO;

    public DenuncianteNaoAnonimoController(DenuncianteNaoAnonimoDAO denuncianteNaoAnonimoDAO) {
        this.denuncianteNaoAnonimoDAO = denuncianteNaoAnonimoDAO;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("denunciantesnaoanonimos", denuncianteNaoAnonimoDAO.findAll());
        return "denunciantesnaoanonimos/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("denuncianteNaoAnonimo", new DenuncianteNaoAnonimo());
        return "denunciantesnaoanonimos/form";
    }

    @PostMapping
    public String save(@ModelAttribute DenuncianteNaoAnonimo denuncianteNaoAnonimo) {
        denuncianteNaoAnonimoDAO.save(denuncianteNaoAnonimo);
        return "redirect:/denunciantesnaoanonimos";
    }

    @GetMapping("/delete/{cpf}/{denuncianteAnonimo}")
    public String delete(@PathVariable String cpf, @PathVariable boolean denuncianteAnonimo) {
        denuncianteNaoAnonimoDAO.deleteByCpfAndAnonimo(cpf, denuncianteAnonimo);
        return "redirect:/denunciantesnaoanonimos";
    }
}
