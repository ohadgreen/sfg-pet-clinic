package com.acme.sfgpetclinic.controllers;

import com.acme.sfgpetclinic.converters.OwnerDbToWeb;
import com.acme.sfgpetclinic.model.Owner;
import com.acme.sfgpetclinic.model.OwnerWeb;
import com.acme.sfgpetclinic.services.OwnerService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class OwnerController {

    private final OwnerService ownerService;
    private final OwnerDbToWeb ownerDbToWebConverter;

    public OwnerController(OwnerService ownerService, OwnerDbToWeb ownerDbToWebConverter) {
        this.ownerService = ownerService;
        this.ownerDbToWebConverter = ownerDbToWebConverter;
    }

    @RequestMapping({"/owners", "/owners/index", "owners/index.html"})
    public String ownersList(Model model) {
        Set<Owner> allOwners = ownerService.findAll();
        System.out.println("owners list: \n =======");
        allOwners.forEach(o -> System.out.println(o.getFirstName()));

        model.addAttribute("owners", allOwners);
        return "owners/index";
    }

    @RequestMapping({"test/owners"})
    public Set<OwnerWeb> ownersListTest() {
        Set<Owner> allOwners = ownerService.findAll();
        System.out.println("owners list: \n =======");
        Set<OwnerWeb> allOwnersWebFormat = new HashSet<>();
        allOwners.forEach(o -> {
            System.out.println(o.getFirstName());
            allOwnersWebFormat.add(ownerDbToWebConverter.convert(o));
        } );

        return allOwnersWebFormat;
    }
}
