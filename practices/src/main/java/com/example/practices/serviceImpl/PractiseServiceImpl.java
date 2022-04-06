package com.example.practices.serviceImpl;

import java.util.*;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.example.practices.dto.*;
import com.example.practices.entity.AddressEntity;
import com.example.practices.entity.PanCard;
import com.example.practices.entity.State;
import com.example.practices.exception.PracticeNotFound;
import com.example.practices.repostory.AddressEntityRepository;
import com.example.practices.repostory.PanCarRepository;
import com.example.practices.repostory.SateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practices.entity.User;
import com.example.practices.repostory.UserRepository;
import com.example.practices.service.PractiseService;
@Service
public class PractiseServiceImpl implements PractiseService {

	
	@Autowired
	UserRepository userRepository;
	@Autowired
	AddressEntityRepository addressEntityRepository;

	@Autowired
	SateRepository sateRepository;

	@Autowired
	PanCarRepository  panCardRepositor;
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
	public List<UserWithFieldsDTO> getByJpaAddress(String addr) {

		return userRepository.findByJpaAddreaa(addr);
	}

	@Override
	public List<AddressEntity> listAddress() {
		return addressEntityRepository.findAll();
	}

	@Override
	public List<AddressEntity> nameOfDistrict(String state) {

		Optional<State> st=sateRepository.findByName(state);

		if(st.isPresent()){
			State states=st.get();
			return addressEntityRepository.findByStateEquals(states);
		}else{
			throw new RuntimeException("state is not found");
		}

	}

	@Override
	public List<AddressEntity> nameOfSimpleDistrict(String state) {
		return addressEntityRepository.findByState_Name(state);
	}

	@Override
	@Transactional
	public String createAddressAndSate(List<SateDTO> addreAndstae) {

		for( SateDTO  state: addreAndstae){  // to get list states
			sateRepository.findByName(state.getName()).ifPresentOrElse( // find states
					(stateObj)->{

						state.getDistricts().forEach(dist->{
							Optional<AddressEntity> adr=addressEntityRepository.findByDistrictName(dist);
						  if(adr.isPresent()){
							  AddressEntity adrk=adr.get();
							  adrk.setState(stateObj);
							  addressEntityRepository.save(adrk);
						  }else {
							  AddressEntity neAdd=new AddressEntity();
							  neAdd.setDistrictName(dist);
							  neAdd.setState(stateObj);
							  addressEntityRepository.save(neAdd);
						  }

						});


			} ,
					()->{

                    State st=new State();  // new state
					st.setName(state.getName());
					State str=sateRepository.save(st);


						state.getDistricts().forEach(dist->{

							Optional<AddressEntity> adr=addressEntityRepository.findByDistrictName(dist);
							if(adr.isPresent()){
								AddressEntity adrk=adr.get();
								adrk.setState(str);
								addressEntityRepository.save(adrk);
							}else {
								AddressEntity neAdd=new AddressEntity();
								neAdd.setDistrictName(dist);
								neAdd.setState(str);
								addressEntityRepository.save(neAdd);
							}

						});
					});
		}

		return "success";
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<PanCard> listOfPanCards() {
      return  panCardRepositor.findAll();
	}

	@Override
	public User userPanCard(Long userId, Long panId) {

		User user=userRepository.findById(userId).orElseThrow(()-> new PracticeNotFound("user not found"));
        PanCard panCard=panCardRepositor.findById(panId).orElseThrow(()-> new PracticeNotFound("pan card is not found"));
		user.setPanCard(panCard);

		return userRepository.save(user);
	}

	@Override
	@Transactional
	public String deletpan(Long panId) {

		PanCard pan=panCardRepositor.findById(panId).orElseThrow(()-> new PracticeNotFound("pan card is not found"));

		List<User> users=userRepository.findByPanCard(pan);

		List<User> listUsers =users.stream().map(us->{

			us.setPanCard(null);
			return us;
		}).collect(Collectors.toList());
		userRepository.saveAll(listUsers);
		panCardRepositor.delete(pan);
		return "sucess";
	}

	@Override
	public PanCard createpan(Map<String, Long> mpPan) {

        Optional<PanCard> pans=panCardRepositor.findByPanNumber(mpPan.get("panNumber"));
		if(pans.isPresent()){
			throw new PracticeNotFound("pan is alredy ter");
		}else {
			PanCard pan=new PanCard();
			pan.setPanNumber(mpPan.get("panNumber"));
			return panCardRepositor.save(pan);
		}

	}

}
