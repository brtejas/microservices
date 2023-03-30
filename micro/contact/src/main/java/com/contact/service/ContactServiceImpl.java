package com.contact.service;

import com.contact.ContactRepo;
import com.contact.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public  class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepo contactrepo;

    @Override
    public Contact getContact(Long userId) {
        return contactrepo.findById(userId).get();
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactrepo.save(contact);
    }

    @Override
    public List<Contact> getContactByUserId(Long userId) {

        List<Contact> contacts =  contactrepo.findAll().stream()
                .filter(contact -> contact.getUserid()==userId)
                .collect(Collectors.toList());

        return contacts;
    }


}
