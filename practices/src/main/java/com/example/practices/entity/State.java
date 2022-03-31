package com.example.practices.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "state")
@Data
public class State {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name",unique = true,nullable = false)
    String name;

}