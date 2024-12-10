package com.example.velofinalproject.controllers;

import com.example.velofinalproject.dtos.contact.ContactAdminDto;
import com.example.velofinalproject.dtos.contact.ContactDto;
import com.example.velofinalproject.dtos.news.NewsHomeDto;
import com.example.velofinalproject.dtos.product.ProductHomeDto;
import com.example.velofinalproject.dtos.slider.SliderHomeDto;
import com.example.velofinalproject.dtos.testimonial.TestimonialDto;
import com.example.velofinalproject.repositories.TestimonialRepository;
import com.example.velofinalproject.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    private final ProductService productService;
    private final SliderService sliderService;
    private final NewsService newsService;
    private final ContactService contactService;
    private final TestimonialService testimonialService;

    public HomeController(ProductService productService, SliderService sliderService, NewsService newsService, ContactService contactService, TestimonialService testimonialService) {
        this.productService = productService;
        this.sliderService = sliderService;
        this.newsService = newsService;
        this.contactService = contactService;
        this.testimonialService = testimonialService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<TestimonialDto> testimonials=testimonialService.getHomeTestimonial();
        List<ProductHomeDto> products = productService.getHomeProducts();
        List<SliderHomeDto> sliders=sliderService.getSliders();
        List<NewsHomeDto> newsData=newsService.getNews();
        model.addAttribute("testimonials", testimonials);
        model.addAttribute("products", products);
        model.addAttribute("sliders", sliders);
        model.addAttribute("newsData", newsData);

        return "/index";
    }
    @GetMapping("/about")
    public String about(Model model){
        List<SliderHomeDto> sliders=sliderService.getSliders();
        model.addAttribute("sliders", sliders);
        return "/about";}

    @GetMapping("/news")
    public String news(Model model){
        List<SliderHomeDto> sliders=sliderService.getSliders();
        model.addAttribute("sliders", sliders);

        List<NewsHomeDto> newsData=newsService.getNews();
        model.addAttribute("newsData", newsData);
        return "/news";}

    @GetMapping("/contact")
    public String contact(Model model){
        List<SliderHomeDto> sliders=sliderService.getSliders();
        model.addAttribute("sliders", sliders);
        return "/contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(@ModelAttribute("contactDto") ContactDto contactDto, Model model) {
        contactService.saveContact(contactDto);
        List<SliderHomeDto> sliders = sliderService.getSliders();
        model.addAttribute("sliders", sliders);
        return "redirect:/";
    }


}
