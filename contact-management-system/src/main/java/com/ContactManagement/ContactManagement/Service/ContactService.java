package com.ContactManagement.ContactManagement.Service;

import com.ContactManagement.ContactManagement.Model.contact_model;

import java.util.List;

public interface ContactService {
    // get ALL Contacts
    List<contact_model> getAllContacts();

    contact_model getContactById(long id);

    // create New Contact
    contact_model createNewContact(contact_model newContact);

    // delete Contact
    String deleteContact(long id);

    // Update Contact
    contact_model updateContact(long id, contact_model updateContact);


}
