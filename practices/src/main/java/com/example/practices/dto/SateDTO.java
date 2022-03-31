package com.example.practices.dto;

import lombok.Data;

import java.util.List;
@Data
public class SateDTO {

    String name;
    List<AddressAndStateDTO> districts;

}
