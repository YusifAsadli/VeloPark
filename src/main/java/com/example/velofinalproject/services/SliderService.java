package com.example.velofinalproject.services;

import com.example.velofinalproject.dtos.product.ProductCreateDto;
import com.example.velofinalproject.dtos.product.ProductDto;
import com.example.velofinalproject.dtos.product.ProductUpdateDto;
import com.example.velofinalproject.dtos.slider.SliderCreateDto;
import com.example.velofinalproject.dtos.slider.SliderDto;
import com.example.velofinalproject.dtos.slider.SliderHomeDto;
import com.example.velofinalproject.dtos.slider.SliderUpdateDto;
import com.example.velofinalproject.models.Product;
import com.example.velofinalproject.models.Slider;

import java.util.List;

public interface SliderService {
    List<SliderHomeDto> getSliders();

    void createSlider(SliderCreateDto sliderCreateDto);
    void updateSlider(SliderUpdateDto sliderUpdateDto, Long id);
    void deleteSlider(Long id);
    SliderUpdateDto findUpdateSlider(Long id);
    List<SliderDto> findAllSliders();
    Slider findSliderById(Long id);
}
