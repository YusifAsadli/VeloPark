package com.example.velofinalproject.controllers;

import com.example.velofinalproject.dtos.category.CategoryCreateDto;
import com.example.velofinalproject.dtos.category.CategoryDto;
import com.example.velofinalproject.dtos.category.CategoryUpdateDto;
import com.example.velofinalproject.dtos.news.NewsCreateDto;
import com.example.velofinalproject.dtos.news.NewsDto;
import com.example.velofinalproject.dtos.news.NewsHomeDto;
import com.example.velofinalproject.dtos.news.NewsUpdateDto;
import com.example.velofinalproject.dtos.slider.SliderHomeDto;
import com.example.velofinalproject.services.NewsService;
import com.example.velofinalproject.services.SliderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NewsController {
    private final NewsService newsService;
    private final ModelMapper modelMapper;

    public NewsController(NewsService newsService, ModelMapper modelMapper) {
        this.newsService = newsService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/admin/news")
    public String news(Model model) {
        List<NewsDto> data = newsService.getHomeNews();
        model.addAttribute("newss", data);
        return "/dashboard/news/index";
    }
    @GetMapping("/admin/news/create")
    public String newsCreate() {
        return "/dashboard/news/create";
    }

    @PostMapping("/admin/news/create")
    public String newsCreateSubmit(NewsCreateDto newsCreateDto) {
        newsService.createNews(newsCreateDto);
        return "redirect:/admin/news";
    }
    @GetMapping("/admin/news/update/{id}")
    public String newsUpgrade(@PathVariable Long id, Model model) {
        NewsUpdateDto news=newsService.findUpdateNews(id);
        model.addAttribute("news", news);
        return "/dashboard/news/update";
    }
    @PostMapping("/admin/news/update/{id}")
    public String newsUpgradeSubmit(@PathVariable Long id, NewsUpdateDto newsUpdateDto) {
        newsService.updateNews(newsUpdateDto, id);
        return "redirect:/admin/news";
    }
    @GetMapping("/admin/news/delete/{id}")
    public String newsDelete(@PathVariable Long id) {
        return "/dashboard/news/delete";
    }

    @PostMapping("/admin/news/delete/{id}")
    public String newsDeleteSubmit(@PathVariable Long id) {
        newsService.deleteNews(id);
        return "redirect:/admin/news";
    }

}
