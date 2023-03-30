package com.contact.controllers;


import com.contact.models.Contact;
import com.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping("/")
    public Contact saveContact(@RequestBody Contact contact){
        return contactService.saveContact(contact);
    }

    @GetMapping("/{id}")
    public List<Contact>  getContactByUserId(@PathVariable("id") Long userId){
        return contactService.getContactByUserId(userId);
    }

}
