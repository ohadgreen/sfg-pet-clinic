package com.acme.sfgpetclinic.controllers;

import com.acme.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetsController {

    private final VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "vets/index.html"})
    public String vetsList(Model model) {
        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
