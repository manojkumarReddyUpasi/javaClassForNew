package com.example.practices.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class AddressDTO {

    @NotEmpty
    @Size(min = 2, message = "name should have at least 2 characters")
    String districtName;

}
