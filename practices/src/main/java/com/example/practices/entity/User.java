package com.example.practices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Data
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	Long id;
	@Column(name="name",unique = true,nullable = false)
	String name;
	@Column(name="fullName")
	String fullName;
	@Column(name="email")
	String email;
	@Column(name="mobile",unique = true)
	String mobileNumber;

	@ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<AddressEntity> address;


}
