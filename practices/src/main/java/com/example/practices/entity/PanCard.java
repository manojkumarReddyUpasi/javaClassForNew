package com.example.practices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="panCard")
public class PanCard {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    @Column(name="panNumber" , nullable = false,unique = true)
    Long panNumber;
}
