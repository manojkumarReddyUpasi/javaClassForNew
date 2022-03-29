package com.example.practices.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Set;
@Data
@ToString
public class UserAddressDTO {

    private   String name;
    private String email;
    private String fullName;
    private String mobileNumber;
    private Set<AddressDTO> address;


}
