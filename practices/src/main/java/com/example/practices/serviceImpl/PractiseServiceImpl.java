package com.example.practices.serviceImpl;

import java.util.*;

import javax.transaction.Transactional;

import com.example.practices.dto.AddressUserDTO;
import com.example.practices.dto.UserAddressDTO;
import com.example.practices.dto.UserWithFieldsDTO;
import com.example.practices.entity.AddressEntity;
import com.example.practices.repostory.AddressEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practices.dto.UserDTO;
import com.example.practices.entity.User;
import com.example.practices.repostory.UserRepository;
import com.example.practices.service.PractiseService;
@Service
public class PractiseServiceImpl implements PractiseService {

	
	@Autowired
	UserRepository userRepository;
	@Autowired
	AddressEntityRepository addressEntityRepository;
	
	@Override
	public Map<String, String> simple() {
		Map<String , String> st=new HashMap<>();
		st.put("name", "manoj");
		st.put("course", "java");
		st.put("be", "cool");
		return st;
	}

	@Override
	public Optional<User> simpleuser(Long id) {
		return userRepository.findById(id);
	}

	@Override
	@Transactional
	public User getSimpleUser(UserDTO userDTO) {
		 User user=new User();
		 user.setName(userDTO.getName());
		 user.setEmail(userDTO.getEmail());
		 user.setMobileNumber(userDTO.getMobileNumber());
		 user.setFullName(userDTO.getFullName());
		return userRepository.save(user);
	}

	@Override
	public UserDTO simpleuserToUpdate(UserDTO userDto) {
		userDto.setName("kalayan");
		return userDto;
	}

	@Override
	public String simpleuserDelete(Long id) {
		Optional<User> user=userRepository.findById(id);
		if(user.isPresent()) {
			User users=user.get();
			 userRepository.delete(users);
			 
			 return "success";
		}else {
			return "no user to delete";
		}
		
	}

	@Override
	public User updateUser(Long id,UserDTO userDto) {
		
		Optional<User> user=userRepository.findById(id);
		if(user.isPresent()) {
			
			User userEnt=user.get();
			userEnt.setFullName(userDto.getFullName());
			userEnt.setEmail(userDto.getEmail());
			return userRepository.save(userEnt);
			
		}else {
			 User users=new User();
			 users.setName(userDto.getName());
			 users.setEmail(userDto.getEmail());
			 users.setMobileNumber(userDto.getMobileNumber());
			 users.setFullName(userDto.getFullName());
			return userRepository.save(users);
			
		}
	}

	@Override
	public User getuserByName(String name) {
		
		return userRepository.findByName(name);
		
		
	}

	@Override
	public User getuserByNameAndMobileNumber(String name, String mobileNumber) {
		
		return userRepository.findByNameAndMobileNumber(name, mobileNumber);
	}

	@Override
	public User createUserAddress(UserAddressDTO userDto) {

		User user=userRepository.findByName(userDto.getName());
		if(user!=null && user.getName()!=null){
			user.setName(userDto.getName());
			user.setEmail(userDto.getEmail());
			user.setFullName(userDto.getFullName());
			Set<AddressEntity> addressEn = new HashSet<>();
			userDto.getAddress().forEach(item -> {
				Optional<AddressEntity> addressEntity=addressEntityRepository.findByDistrictName(item.getDistrictName());
				if(addressEntity.isPresent()){
					AddressEntity addrEn=addressEntity.get();
					addressEn.add(addrEn);
				}else {
					AddressEntity add1 = new AddressEntity();
					add1.setDistrictName(item.getDistrictName());
					addressEn.add(add1);
				}


			});
			user.setMobileNumber(userDto.getMobileNumber());
			user.setAddress(addressEn);
			return userRepository.save(user);
		}else {
			User userEntity = new User();
			userEntity.setName(userDto.getName());
			userEntity.setEmail(userDto.getEmail());
			userEntity.setFullName(userDto.getFullName());
			Set<AddressEntity> addressEn = new HashSet<>();
			userDto.getAddress().forEach(item -> {
				Optional<AddressEntity> addressEntity=addressEntityRepository.findByDistrictName(item.getDistrictName());
				if(addressEntity.isPresent()){
					AddressEntity addrEn=addressEntity.get();
					addressEn.add(addrEn);
				}else {
					AddressEntity add1 = new AddressEntity();
					add1.setDistrictName(item.getDistrictName());
					addressEn.add(add1);
				}

			});

			userEntity.setMobileNumber(userDto.getMobileNumber());
			userEntity.setAddress(addressEn);

			return userRepository.save(userEntity);
		}
	}

	@Override
	public List<AddressUserDTO> getByAddress() {
		return userRepository.findByAddress();

	}

	@Override
	public List<UserWithFieldsDTO> getByJpaAddress() {

		return userRepository.findByJpaAddreaa();
	}

}
