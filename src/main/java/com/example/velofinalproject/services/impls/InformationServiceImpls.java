package com.example.velofinalproject.services.impls;

import com.example.velofinalproject.dtos.information.InformationCreateDto;
import com.example.velofinalproject.dtos.information.InformationDto;
import com.example.velofinalproject.dtos.information.InformationUpdateDto;
import com.example.velofinalproject.models.Information;
import com.example.velofinalproject.repositories.InformationRepository;
import com.example.velofinalproject.services.InformationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InformationServiceImpls implements InformationService {

    private final InformationRepository informationRepository;
    private final ModelMapper modelMapper;

    public InformationServiceImpls(InformationRepository informationRepository, ModelMapper modelMapper) {
        this.informationRepository = informationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createInformation(InformationCreateDto informationCreateDto) {
        Information information=new Information();
        modelMapper.map(informationCreateDto,information);
        informationRepository.save(information);
    }

    @Override
    public void updateInformation(InformationUpdateDto informationUpdateDto, Long id) {
        Information information=informationRepository.findById(id).orElseThrow();
        modelMapper.map(informationUpdateDto,information);
        informationRepository.save(information);
    }

    @Override
    public void deleteInformation(Long id) {
        Information information=informationRepository.findById(id).orElseThrow();
        informationRepository.delete(information);
    }

    @Override
    public InformationUpdateDto findUpdateInformation(Long id) {
        Information information=informationRepository.findById(id).orElseThrow();
        InformationUpdateDto informationUpdateDto=modelMapper.map(information,InformationUpdateDto.class);
        return informationUpdateDto;
    }

    @Override
    public List<InformationDto> getHomeInformations() {
        List<InformationDto> informations=informationRepository.findAll().stream().map(info->modelMapper.map(info, InformationDto.class)).toList();
        return informations;
    }

    @Override
    public Information findInformationById(Long id) {
        return informationRepository.findById(id).orElseThrow();
    }
}
