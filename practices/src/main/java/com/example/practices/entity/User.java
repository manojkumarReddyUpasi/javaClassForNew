package com.example.practices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Set<AddressEntity> getAddress() {
		return address;
	}

	public void setAddress(Set<AddressEntity> address) {
		this.address = address;
	}
}
