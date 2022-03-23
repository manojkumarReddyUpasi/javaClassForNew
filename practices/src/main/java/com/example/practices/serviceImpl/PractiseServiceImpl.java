package com.example.practices.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.practices.dto.UserDTO;
import com.example.practices.entity.User;
import com.example.practices.repostory.UserRepository;
import com.example.practices.service.PractiseService;
@Service
public class PractiseServiceImpl implements PractiseService {

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Map<String, String> simple() {
		Map<String , String> st=new HashMap<>();
		st.put("name", "manoj");
		st.put("course", "java");
		st.put("be", "cool");
		System.out.println("hey commit");
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

}
