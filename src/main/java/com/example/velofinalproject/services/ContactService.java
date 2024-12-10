package com.example.velofinalproject.services;

import com.example.velofinalproject.dtos.contact.ContactAdminDto;
import com.example.velofinalproject.dtos.contact.ContactDto;
import com.example.velofinalproject.models.ContactUser;

import java.util.List;

public interface ContactService {
    List<ContactAdminDto> findAllContacts();
    ContactUser findContactById(Long id);
    void saveContact(ContactDto contactDto);
}
