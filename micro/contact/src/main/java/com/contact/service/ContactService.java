package com.contact.service;

import com.contact.models.Contact;

import java.util.List;

public interface ContactService {
    
    public Contact getContact(Long contactId);

    Contact saveContact(Contact contact);

    List<Contact> getContactByUserId(Long userId);
}
