package com.example.velofinalproject.services.impls;

import com.example.velofinalproject.dtos.news.NewsCreateDto;
import com.example.velofinalproject.dtos.news.NewsDto;
import com.example.velofinalproject.dtos.news.NewsHomeDto;
import com.example.velofinalproject.dtos.news.NewsUpdateDto;
import com.example.velofinalproject.models.News;
import com.example.velofinalproject.repositories.NewsRepository;
import com.example.velofinalproject.services.NewsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImpls implements NewsService {

    private final NewsRepository newsRepository;
    private final ModelMapper modelMapper;

    public NewsServiceImpls(NewsRepository newsRepository, ModelMapper modelMapper) {
        this.newsRepository = newsRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<NewsHomeDto> getNews() {
        List <NewsHomeDto> news = newsRepository.findAll().stream().map(newss->modelMapper.map(newss,NewsHomeDto.class)).toList();
        return news;
    }

    @Override
    public void createNews(NewsCreateDto newsCreateDto) {
        News news = new News();
        news.setTitle(newsCreateDto.getTitle());
        news.setDescription(newsCreateDto.getDescription());
        news.setDate(newsCreateDto.getDate());
        news.setPhotoUrl(newsCreateDto.getPhotoUrl());
        news.setUsername(newsCreateDto.getUsername());
        news.setVisible(newsCreateDto.getVisible());
        newsRepository.save(news);
    }

    @Override
    public void updateNews(NewsUpdateDto newsUpdateDto, Long id) {
        News news = newsRepository.findById(id).orElseThrow();
        news.setTitle(newsUpdateDto.getTitle());
        news.setDescription(newsUpdateDto.getDescription());
        news.setDate(newsUpdateDto.getDate());
        news.setPhotoUrl(newsUpdateDto.getPhotoUrl());
        news.setUsername(newsUpdateDto.getUsername());
        news.setVisible(newsUpdateDto.getVisible());
        newsRepository.save(news);
    }

    @Override
    public void deleteNews(Long id) {
        News news = newsRepository.findById(id).orElseThrow();
        newsRepository.deleteById(id);
    }

    @Override
    public NewsUpdateDto findUpdateNews(Long id) {
        News news = newsRepository.findById(id).orElseThrow();
        NewsUpdateDto newsUpdateDto = modelMapper.map(news,NewsUpdateDto.class);
        return newsUpdateDto;
    }

    @Override
    public List<NewsDto> getHomeNews() {
        List<NewsDto> news=newsRepository.findAll().stream().map(x->modelMapper.map(x,NewsDto.class)).toList();
        return news;
    }

    @Override
    public News findNewsById(Long id) {
        return newsRepository.findById(id).orElseThrow();
    }
}
