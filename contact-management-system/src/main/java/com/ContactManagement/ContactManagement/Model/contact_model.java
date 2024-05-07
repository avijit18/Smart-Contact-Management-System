package com.ContactManagement.ContactManagement.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class contact_model {
    private long contact_id;

    @NotEmpty(message = "Name is Required")
    private String contact_name;

    @Email(message = "Please Enter a valid Email address")
    private String contact_email;

    @NotEmpty
    private String contact_number;

    @NotEmpty
    private String contact_address;
}
