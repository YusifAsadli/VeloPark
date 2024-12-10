package com.example.velofinalproject.services.impls;
import com.example.velofinalproject.dtos.testimonial.TestimonialCreateDto;
import com.example.velofinalproject.dtos.testimonial.TestimonialDto;
import com.example.velofinalproject.dtos.testimonial.TestimonialHomeDto;
import com.example.velofinalproject.dtos.testimonial.TestimonialUpdateDto;
import com.example.velofinalproject.models.Testimonial;
import com.example.velofinalproject.repositories.TestimonialRepository;
import com.example.velofinalproject.services.TestimonialService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestimonialServiceImpls implements TestimonialService {
    private final TestimonialRepository testimonialRepository;
    private final ModelMapper modelMapper;

    public TestimonialServiceImpls(TestimonialRepository testimonialRepository, ModelMapper modelMapper) {
        this.testimonialRepository = testimonialRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TestimonialHomeDto> getNews() {
        List <TestimonialHomeDto> testimonilas = testimonialRepository.findAll().stream().map(newss->modelMapper.map(newss,TestimonialHomeDto.class)).toList();
        return testimonilas;
    }

    @Override
    public void createTestimonial(TestimonialCreateDto testimonialCreateDto) {
        Testimonial testimonial = new Testimonial();
        modelMapper.map(testimonialCreateDto,testimonial);
        testimonialRepository.save(testimonial);
    }

    @Override
    public void updateTestimonial(TestimonialUpdateDto testimonialUpdateDto, Long id) {
        Testimonial testimonial = testimonialRepository.findById(id).orElseThrow();
        modelMapper.map(testimonialUpdateDto,testimonial);
        testimonialRepository.save(testimonial);
    }

    @Override
    public void deleteTestimonial(Long id) {
        Testimonial testimonial=testimonialRepository.findById(id).orElseThrow();
        testimonialRepository.delete(testimonial);

    }

    @Override
    public TestimonialUpdateDto findUpdateTestimonial(Long id) {
        Testimonial testimonial = testimonialRepository.findById(id).orElseThrow();
        TestimonialUpdateDto testimonialUpdateDto = modelMapper.map(testimonial,TestimonialUpdateDto.class);
        return testimonialUpdateDto;
    }

    @Override
    public List<TestimonialDto> getHomeTestimonial() {
        List<TestimonialDto> testimonial=testimonialRepository.findAll().stream().map(x->modelMapper.map(x,TestimonialDto.class)).toList();
        return testimonial;
    }


    @Override
    public Testimonial findTestimonialById(Long id) {
        return testimonialRepository.findById(id).orElseThrow();
    }
}
