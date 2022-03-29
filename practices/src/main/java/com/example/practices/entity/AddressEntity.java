package com.example.practices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @Column(name = "district_name",unique = true,nullable = false)
    private String districtName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
