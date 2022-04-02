package com.example.practices.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.practices.dto.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.practices.entity.User;
import com.example.practices.service.PractiseService;

import javax.validation.Valid;

@RestController()
@RequestMapping("/user")
@Validated
public class PractiseController {
	
	
	@Autowired
	PractiseService practiseService;
	
	@GetMapping("/test")
	public ResponseEntity<Map>  simple(){
		
		System.out.println("space");
		return new ResponseEntity<Map>(practiseService.simple(),HttpStatus.OK);
	}
	@ApiOperation(value = "Find User ", response = Iterable.class, tags = "simpleuser")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "Not Authorized!"),
			@ApiResponse(code = 403, message = "Forbidden!"),
			@ApiResponse(code = 404, message = "Not Found!") })
	@GetMapping("/{id}")
	public ResponseEntity<?>  simpleuser(@PathVariable Long id){
		return new ResponseEntity<>(practiseService.simpleuser(id),HttpStatus.OK);
	}
	
	
	@PostMapping()
    public ResponseEntity<?>  simpleuser( @Valid  @RequestBody UserDTO userDto){


		return new ResponseEntity<>(practiseService.getSimpleUser(userDto),HttpStatus.OK);
	}
	
	@PutMapping()
    public ResponseEntity<?>  simpleuserToUpdate(@RequestParam Long id,@RequestBody UserDTO userDto){
		
		
		return new ResponseEntity<>(practiseService.updateUser(id,userDto),HttpStatus.OK);
	}


	@ApiOperation(value = "This Api will give one user by name ", response = Iterable.class, tags = "getUserByName")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "Not Authorized!"),
			@ApiResponse(code = 403, message = "Forbidden!"),
			@ApiResponse(code = 404, message = "Not Found!") })
	@GetMapping()
	public ResponseEntity<User>  getuserByName(@RequestParam(name = "name",required=true) String name){
		
	
		return new ResponseEntity<User>(practiseService.getuserByName(name),HttpStatus.OK);
	}

	@GetMapping("/all-users")
	public ResponseEntity<?>  getAllUsers(){


		return new ResponseEntity<>(practiseService.getUsers(),HttpStatus.OK);
	}
	@GetMapping("/mobile")
	public ResponseEntity<User>  getuserByNameAndMobileNumber(@RequestParam(name = "name",required=true) String name,@RequestParam(name = "mobileNumber",required=true) String mobileNumber){
		
	
		return new ResponseEntity<User>(practiseService.getuserByNameAndMobileNumber(name,mobileNumber),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?>  simpleuserDelete(@PathVariable Long id){
		
		
		return new ResponseEntity<>(practiseService.simpleuserDelete(id),HttpStatus.OK);
	}


	@PostMapping("/address")
	public ResponseEntity<?>  createUserAddress(@RequestBody UserAddressDTO userDto){
		return new ResponseEntity<>(practiseService.createUserAddress(userDto),HttpStatus.OK);
	}

	@GetMapping("/address")
	public ResponseEntity<?>  getByAddress(){


		return new ResponseEntity<>(practiseService.getByAddress(),HttpStatus.OK);
	}


	@GetMapping("/jpa/address/{addr}")
	public ResponseEntity<?>  getByJpaAddress(@PathVariable String addr ){
		return new ResponseEntity<>(practiseService.getByJpaAddress(addr),HttpStatus.OK);
	}


	@GetMapping("/list-address")
	public ResponseEntity<?>  listAddress(){
		return new ResponseEntity<>(practiseService.listAddress(),HttpStatus.OK);
	}


	@GetMapping("/state/name-district")
	public ResponseEntity<?>  nameOfDistrict(@RequestParam(name = "state")  String state){
		return new ResponseEntity<>(practiseService.nameOfDistrict(state),HttpStatus.OK);
	}


	@GetMapping("/state/simple/name-district")
	public ResponseEntity<?>  nameOfSimpleDistrict(@RequestParam(name = "state")  String state){
		return new ResponseEntity<>(practiseService.nameOfSimpleDistrict(state),HttpStatus.OK);
	}

	@PostMapping("/state/address")
	public ResponseEntity<?>  createAddressAndSate(@RequestBody List<SateDTO> addreAndstae){
		return new ResponseEntity<>(practiseService.createAddressAndSate(addreAndstae),HttpStatus.OK);
	}

}
