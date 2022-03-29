package com.example.practices.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.practices.dto.AddressUserDTO;
import com.example.practices.dto.UserAddressDTO;
import com.example.practices.dto.UserDTO;
import com.example.practices.dto.UserWithFieldsDTO;
import com.example.practices.entity.User;

public interface PractiseService {
	public Map<String , String> simple();
	
	public Optional<User>  simpleuser(Long id);
	
	public User getSimpleUser(UserDTO userDTO);
	
	public UserDTO simpleuserToUpdate(UserDTO userDTO);
	
	String simpleuserDelete(Long id);

	public User updateUser(Long id,UserDTO userDto);

	public User getuserByName(String name);

	public User getuserByNameAndMobileNumber(String name, String mobileNumber);

	public User createUserAddress(UserAddressDTO userDto);

	List<AddressUserDTO> getByAddress();

	List<UserWithFieldsDTO> getByJpaAddress();
}
