package com.example.velofinalproject.services.impls;


import com.example.velofinalproject.dtos.slider.SliderCreateDto;
import com.example.velofinalproject.dtos.slider.SliderDto;
import com.example.velofinalproject.dtos.slider.SliderHomeDto;
import com.example.velofinalproject.dtos.slider.SliderUpdateDto;

import com.example.velofinalproject.models.Slider;
import com.example.velofinalproject.repositories.SliderRepository;
import com.example.velofinalproject.services.SliderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.stream.Collectors;

@Service
public class SliderServiceImpls implements SliderService {
    private final SliderRepository sliderRepository;
    private final ModelMapper modelMapper;

    public SliderServiceImpls(SliderRepository sliderRepository, ModelMapper modelMapper) {
        this.sliderRepository = sliderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SliderHomeDto> getSliders() {
        List<Slider> sliders = sliderRepository.findAll();
        List<SliderHomeDto> result = sliders.stream().map(slider -> modelMapper.map(slider, SliderHomeDto.class)).collect(Collectors.toList());
        return result;
    }

    @Override
    public void createSlider(SliderCreateDto sliderCreateDto) {
        Slider slider = new Slider();
        slider.setDescription(sliderCreateDto.getDescription());
        slider.setTitle(sliderCreateDto.getTitle());
        slider.setPhotoUrl(sliderCreateDto.getPhotoUrl());
        sliderRepository.save(slider);
    }

    @Override
    public void updateSlider(SliderUpdateDto sliderUpdateDto, Long id) {
        Slider slider = sliderRepository.findById(id).orElseThrow();
        slider.setDescription(sliderUpdateDto.getDescription());
        slider.setTitle(sliderUpdateDto.getTitle());
        slider.setPhotoUrl(sliderUpdateDto.getPhotoUrl());
        sliderRepository.save(slider);
    }

    @Override
    public void deleteSlider(Long id) {
        Slider slider = sliderRepository.findById(id).orElseThrow();
        sliderRepository.delete(slider);

    }

    @Override
    public SliderUpdateDto findUpdateSlider(Long id) {
        Slider slider = sliderRepository.findById(id).orElseThrow();
        SliderUpdateDto result = modelMapper.map(slider, SliderUpdateDto.class);
        return result;
    }

    @Override
    public List<SliderDto> findAllSliders() {
        List<SliderDto> sliders = sliderRepository.findAll().stream().map(x -> modelMapper.map(x, SliderDto.class)).collect(Collectors.toList());
        return sliders;
    }

    @Override
    public Slider findSliderById(Long id) {
        return sliderRepository.findById(id).orElseThrow();
    }
}
