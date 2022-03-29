package com.example.practices.dto;

public class UserWithFieldsDTO {

    String name;
    String districtName;

    public UserWithFieldsDTO(String name, String districtName) {
        this.name = name;
        this.districtName = districtName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
