package com.example.velofinalproject.controllers;

import com.example.velofinalproject.dtos.news.NewsCreateDto;
import com.example.velofinalproject.dtos.news.NewsDto;
import com.example.velofinalproject.dtos.news.NewsUpdateDto;
import com.example.velofinalproject.dtos.testimonial.TestimonialCreateDto;
import com.example.velofinalproject.dtos.testimonial.TestimonialDto;
import com.example.velofinalproject.dtos.testimonial.TestimonialUpdateDto;
import com.example.velofinalproject.services.TestimonialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TestimonialController {
    private final TestimonialService testimonialService;

    public TestimonialController(TestimonialService testimonialService) {
        this.testimonialService = testimonialService;
    }

    @GetMapping("/admin/testimonial")
    public String testimonial(Model model) {
        List<TestimonialDto> data = testimonialService.getHomeTestimonial();
        model.addAttribute("testimonialss", data);
        return "/dashboard/testimonial/index";
    }
    @GetMapping("/admin/testimonial/create")
    public String testimonialCreate() {
        return "/dashboard/testimonial/create";
    }

    @PostMapping("/admin/testimonial/create")
    public String testimonialCreateSubmit(TestimonialCreateDto testimonialCreateDto) {
        testimonialService.createTestimonial(testimonialCreateDto);
        return "redirect:/admin/testimonial";
    }
    @GetMapping("/admin/testimonial/update/{id}")
    public String testimonialUpgrade(@PathVariable Long id, Model model) {
        TestimonialUpdateDto testimonial=testimonialService.findUpdateTestimonial(id);
        model.addAttribute("testimonial", testimonial);
        return "/dashboard/testimonial/update";
    }
    @PostMapping("/admin/testimonial/update/{id}")
    public String testimonialUpgradeSubmit(@PathVariable Long id, TestimonialUpdateDto testimonialUpdateDto) {
        testimonialService.updateTestimonial(testimonialUpdateDto, id);
        return "redirect:/admin/testimonial";
    }
    @GetMapping("/admin/testimonial/delete/{id}")
    public String testimonialDelete(@PathVariable Long id) {
        return "/dashboard/testimonial/delete";
    }

    @PostMapping("/admin/testimonial/delete/{id}")
    public String testimonialDeleteSubmit(@PathVariable Long id) {
        testimonialService.deleteTestimonial(id);
        return "redirect:/admin/testimonial";
    }
}
