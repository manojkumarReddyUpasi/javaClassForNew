package com.example.practices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
@Data
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


}
