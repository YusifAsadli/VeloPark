package com.example.velofinalproject.services;

import com.example.velofinalproject.dtos.news.NewsCreateDto;
import com.example.velofinalproject.dtos.news.NewsDto;
import com.example.velofinalproject.dtos.news.NewsHomeDto;
import com.example.velofinalproject.dtos.news.NewsUpdateDto;
import com.example.velofinalproject.dtos.testimonial.TestimonialCreateDto;
import com.example.velofinalproject.dtos.testimonial.TestimonialDto;
import com.example.velofinalproject.dtos.testimonial.TestimonialHomeDto;
import com.example.velofinalproject.dtos.testimonial.TestimonialUpdateDto;
import com.example.velofinalproject.models.Testimonial;

import java.util.List;

public interface TestimonialService {
    List<TestimonialHomeDto> getNews();

    void createTestimonial(TestimonialCreateDto testimonialCreateDto);
    void updateTestimonial(TestimonialUpdateDto testimonialUpdateDto, Long id);
    void deleteTestimonial(Long id);
    TestimonialUpdateDto findUpdateTestimonial(Long id);
    List<TestimonialDto> getHomeTestimonial();
    Testimonial findTestimonialById(Long id);
}
