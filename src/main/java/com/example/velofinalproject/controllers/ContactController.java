package com.example.velofinalproject.controllers;

import com.example.velofinalproject.dtos.contact.ContactAdminDto;
import com.example.velofinalproject.dtos.contact.ContactDto;
import com.example.velofinalproject.services.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/admin/contact")
    public String contact(Model model) {
        List<ContactAdminDto> contacts =contactService.findAllContacts();
        model.addAttribute("contacts", contacts);
        return "/dashboard/contact/index";
    }

}
