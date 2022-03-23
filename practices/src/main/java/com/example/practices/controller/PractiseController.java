package com.example.practices.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.practices.dto.UserDTO;
import com.example.practices.entity.User;
import com.example.practices.service.PractiseService;

@RestController
public class PractiseController {
	
	
	@Autowired
	PractiseService practiseService;
	
	@GetMapping("/test")
	public ResponseEntity<Map>  simple(){
		return new ResponseEntity<Map>(practiseService.simple(),HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?>  simpleuser(@PathVariable Long id){
		return new ResponseEntity<>(practiseService.simpleuser(id),HttpStatus.OK);
	}
	
	
	@PostMapping("/user")
    public ResponseEntity<?>  simpleuser(@RequestBody UserDTO userDto){
		return new ResponseEntity<>(practiseService.getSimpleUser(userDto),HttpStatus.OK);
	}
	
	@PutMapping("/user")
    public ResponseEntity<?>  simpleuserToUpdate(@RequestParam Long id,@RequestBody UserDTO userDto){
		
		
		return new ResponseEntity<>(practiseService.updateUser(id,userDto),HttpStatus.OK);
	}
	
	
	@GetMapping("/user")
	public ResponseEntity<User>  getuserByName(@RequestParam(name = "name",required=true) String name){
		
	
		return new ResponseEntity<User>(practiseService.getuserByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/user/mobile")
	public ResponseEntity<User>  getuserByNameAndMobileNumber(@RequestParam(name = "name",required=true) String name,@RequestParam(name = "mobileNumber",required=true) String mobileNumber){
		
	
		return new ResponseEntity<User>(practiseService.getuserByNameAndMobileNumber(name,mobileNumber),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/user/{id}")
    public ResponseEntity<?>  simpleuserDelete(@PathVariable Long id){
		
		
		return new ResponseEntity<>(practiseService.simpleuserDelete(id),HttpStatus.OK);
	}

}
