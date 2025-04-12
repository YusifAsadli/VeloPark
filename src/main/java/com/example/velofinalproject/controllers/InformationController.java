package com.example.velofinalproject.controllers;

import com.example.velofinalproject.dtos.category.CategoryCreateDto;
import com.example.velofinalproject.dtos.category.CategoryDto;
import com.example.velofinalproject.dtos.category.CategoryUpdateDto;
import com.example.velofinalproject.dtos.information.InformationCreateDto;
import com.example.velofinalproject.dtos.information.InformationDto;
import com.example.velofinalproject.dtos.information.InformationUpdateDto;
import com.example.velofinalproject.repositories.InformationRepository;
import com.example.velofinalproject.services.InformationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class InformationController {

    private final InformationService informationService;

    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("/admin/information")
    public String information(Model model) {
        List<InformationDto> data = informationService.getHomeInformations();
        model.addAttribute("informations", data);
        return "/dashboard/information/index";
    }

    @GetMapping("/admin/information/create")
    public String informationInformation() {
        return "/dashboard/information/create";
    }

    @PostMapping("/admin/information/create")
    public String informationInformationSubmit(InformationCreateDto informationCreateDto) {
        informationService.createInformation(informationCreateDto);
        return "redirect:/admin/information";
    }

    @GetMapping("/admin/information/update/{id}")
    public String informationUpgrade(@PathVariable Long id, Model model) {
        InformationUpdateDto information=informationService.findUpdateInformation(id);
        model.addAttribute("information", information);
        return "/dashboard/information/update";
    }

    @PostMapping("/admin/information/update/{id}")
    public String informationInformationUpdate(@PathVariable Long id, InformationUpdateDto informationUpdateDto) {
        informationService.updateInformation(informationUpdateDto,id);
        return "redirect:/admin/information";
    }

    @GetMapping("/admin/information/delete/{id}")
    public String informationInformationDelete(@PathVariable Long id) {
        return "/dashboard/information/delete";
    }

    @PostMapping("/admin/information/delete/{id}")
    public String informationDeleteSubmit(@PathVariable Long id) {
        informationService.deleteInformation(id);
        return "redirect:/admin/information";
    }


}
