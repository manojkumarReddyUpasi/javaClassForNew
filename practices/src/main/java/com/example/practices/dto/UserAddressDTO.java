package com.example.practices.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;
@Data
@ToString
public class UserAddressDTO {

    @NotEmpty
    @Size(min = 2, message = "name should have at least 2 characters")
    private   String name;

    @Email(message = "not well formed email")
    private String email;

    @NotEmpty
    @Size(min = 2, message = "fullName should have at least 2 characters")
    private String fullName;


    private String mobileNumber;
    private Set<AddressDTO> address;


}
