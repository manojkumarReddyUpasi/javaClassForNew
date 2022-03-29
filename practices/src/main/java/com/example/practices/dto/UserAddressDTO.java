package com.example.practices.dto;

import java.util.Set;

public class UserAddressDTO {

    private   String name;
    private String email;
    private String fullName;
    private String mobileNumber;
    private Set<AddressDTO> address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Set<AddressDTO> getAddress() {
        return address;
    }

    public void setAddress(Set<AddressDTO> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserAddressDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", address=" + address +
                '}';
    }
}
