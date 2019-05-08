package com.acme.sfgpetclinic.controllers;

import com.acme.sfgpetclinic.model.Owner;
import com.acme.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owners", "/owners/index", "owners/index.html"})
    public String ownersList(Model model) {
        Set<Owner> allOwners = ownerService.findAll();
        System.out.println("owners list: \n =======");
        allOwners.forEach(o -> System.out.println(o.getFirstName()));

        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
}
