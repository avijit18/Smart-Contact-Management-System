package com.ContactManagement.ContactManagement.Service;

import com.ContactManagement.ContactManagement.Entity.ContactEntity;
import com.ContactManagement.ContactManagement.Model.contact_model;
import com.ContactManagement.ContactManagement.Repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<contact_model> getAllContacts() {
        List<ContactEntity> contactEntityList = contactRepository.findAll();
        List<contact_model> contactModels = new ArrayList<>();
        for (ContactEntity contactEntity : contactEntityList) {
            contact_model contactModel = new contact_model();
            BeanUtils.copyProperties(contactEntity, contactModel);
            contactModels.add(contactModel);
        }
        return contactModels;
    }

    @Override
    public contact_model getContactById(long id) {
        ContactEntity contactEntity = contactRepository.findById(id).get();
        contact_model contacts = new contact_model();
        BeanUtils.copyProperties(contactEntity, contacts);
        return contacts;
    }

    @Override
    public contact_model createNewContact(contact_model newContact) {
        ContactEntity contactEntity = new ContactEntity();
        BeanUtils.copyProperties(newContact, contactEntity);
        contactRepository.save(contactEntity);
        return newContact;
    }

    @Override
    public String deleteContact(long id) {
        Optional<ContactEntity> contactEntityOptional = contactRepository.findById(id);
        if (!contactEntityOptional.isPresent()) return "No Contact Found";
        else {
            ContactEntity contactEntity = contactEntityOptional.get();
            contactRepository.delete(contactEntity);
            return "Delete Successfully";
        }
    }

    @Override
    public contact_model updateContact(long id, contact_model updateContact) {
        ContactEntity ExistingcontactEntity = contactRepository.findById(id).get();
        ExistingcontactEntity.setContact_name(updateContact.getContact_name());
        ExistingcontactEntity.setContact_email(updateContact.getContact_email());
        ExistingcontactEntity.setContact_number(updateContact.getContact_number());
        ExistingcontactEntity.setContact_address(updateContact.getContact_address());
        contactRepository.save(ExistingcontactEntity);
        return updateContact;
    }
}
