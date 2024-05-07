package com.ContactManagement.ContactManagement.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contact_table")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contact_id;

    private String contact_name;

    private String contact_email;

    private String contact_number;

    private String contact_address;

}
