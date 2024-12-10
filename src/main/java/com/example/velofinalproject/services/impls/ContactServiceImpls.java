package com.example.velofinalproject.services.impls;

import com.example.velofinalproject.dtos.contact.ContactAdminDto;
import com.example.velofinalproject.dtos.contact.ContactDto;
import com.example.velofinalproject.models.ContactUser;
import com.example.velofinalproject.repositories.ContactRepository;
import com.example.velofinalproject.services.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpls implements ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;


    public ContactServiceImpls(ContactRepository contactRepository, ModelMapper modelMapper) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ContactAdminDto> findAllContacts() {
        List<ContactAdminDto> contacts = contactRepository.findAll().stream().map(x->modelMapper.map(x,ContactAdminDto.class)).collect(Collectors.toList());
        return contacts;
    }

    @Override
    public ContactUser findContactById(Long id) {
        return contactRepository.findById(id).orElseThrow();
    }

    @Override
    public void saveContact(ContactDto contactDto) {
        ContactUser contactUser = new ContactUser();
        contactUser.setName(contactDto.getName());
        contactUser.setEmail(contactDto.getEmail());
        contactUser.setPhone(contactDto.getPhone());
        contactUser.setMassage(contactDto.getMassage());
        contactRepository.save(contactUser);
    }
}
