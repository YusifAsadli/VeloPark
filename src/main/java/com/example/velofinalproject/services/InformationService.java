package com.example.velofinalproject.services;


import com.example.velofinalproject.dtos.information.InformationCreateDto;
import com.example.velofinalproject.dtos.information.InformationDto;
import com.example.velofinalproject.dtos.information.InformationUpdateDto;
import com.example.velofinalproject.models.Information;

import java.util.List;

public interface InformationService {
    void createInformation(InformationCreateDto informationCreateDto);
    void updateInformation(InformationUpdateDto informationUpdateDto, Long id);
    void deleteInformation(Long id);
    InformationUpdateDto findUpdateInformation(Long id);
    List<InformationDto> getHomeInformations();
    Information findInformationById(Long id);
}
