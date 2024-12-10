package com.example.velofinalproject.controllers;

import com.example.velofinalproject.dtos.category.CategoryDto;
import com.example.velofinalproject.dtos.product.ProductCreateDto;
import com.example.velofinalproject.dtos.product.ProductDto;
import com.example.velofinalproject.dtos.product.ProductUpdateDto;
import com.example.velofinalproject.dtos.slider.SliderCreateDto;
import com.example.velofinalproject.dtos.slider.SliderDto;
import com.example.velofinalproject.dtos.slider.SliderUpdateDto;
import com.example.velofinalproject.services.SliderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SliderController {
    private final SliderService sliderService;

    public SliderController(SliderService sliderService) {
        this.sliderService = sliderService;
    }


    @GetMapping("/admin/slider")
    public String adminSlider(Model model) {
        List<SliderDto> slider = sliderService.findAllSliders();
        model.addAttribute("sliders", slider);
        return "/dashboard/slider/index";
    }
    @GetMapping("/admin/slider/create")
    public String createProduct(Model model) {
        return "/dashboard/slider/create";
    }

    @PostMapping("/admin/slider/create")
    public String createSLider(@ModelAttribute("product") SliderCreateDto sliderCreateDto) {
        sliderService.createSlider(sliderCreateDto);
        return "redirect:/admin/slider";
    }

    @GetMapping("/admin/slider/delete/{id}")
    public String deleteSlider(@PathVariable Long id) {
        return "/dashboard/slider/delete";
    }

    @PostMapping("/admin/slider/delete/{id}")
    public String removeSlider(@PathVariable Long id) {
        sliderService.deleteSlider(id);
        return "redirect:/admin/slider";
    }

    @GetMapping("/admin/slider/update/{id}")
    public String updateSlider(@PathVariable Long id, Model model) {
        SliderUpdateDto sliderUpdateDto = sliderService.findUpdateSlider(id);
        model.addAttribute("slider", sliderUpdateDto);
        return "/dashboard/slider/update";
    }
    @PostMapping("/admin/slider/update/{id}")
    public String updateSlider(@PathVariable Long id, SliderUpdateDto sliderUpdateDto) {
        sliderService.updateSlider(sliderUpdateDto, id);
        return "redirect:/admin/slider";
    }

}
