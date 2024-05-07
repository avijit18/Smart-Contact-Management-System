package com.ContactManagement.ContactManagement.Controller;

import com.ContactManagement.ContactManagement.Entity.ContactEntity;
import com.ContactManagement.ContactManagement.Model.contact_model;
import com.ContactManagement.ContactManagement.Service.ContactServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @Autowired
    ContactServiceImpl contactServiceImpl;

    ContactController(ContactServiceImpl contactServiceImpl) {
        this.contactServiceImpl = contactServiceImpl;
    }


    @GetMapping("/contacts")
    public String getStudentsList(Model model) {
        model.addAttribute("Contacts", contactServiceImpl.getAllContacts());
        return "Contacts";
    }

    @GetMapping("/contacts/new_contact")
    public String createNewContacts(@Valid Model model) {

        // create entity object to hold the form data
        ContactEntity contactEntity = new ContactEntity();
        model.addAttribute("Contact", contactEntity);
        return "create_New_Contact";
    }

    @PostMapping("/contacts")
    public String saveContact(@ModelAttribute("Contact") contact_model contactModel) {
        contactServiceImpl.createNewContact(contactModel);
        return "redirect:/contacts";
    }

    @GetMapping("/Contacts/edit/{id}")
    public String getContactByID(@PathVariable long id, Model model) {
        model.addAttribute("Contact", contactServiceImpl.getContactById(id));
        return "edit_contact";
    }

    @PostMapping("/contacts/{id}")
    public String updateContact(@PathVariable long id, @ModelAttribute("Contact") contact_model contactModel, Model model){
        contactServiceImpl.updateContact(id, contactModel);
        return "redirect:/contacts";
    }

    @GetMapping("/Contacts/{id}")
    public String deleteContact(@PathVariable long id){
        contactServiceImpl.deleteContact(id);
        return "redirect:/contacts";
    }
}
