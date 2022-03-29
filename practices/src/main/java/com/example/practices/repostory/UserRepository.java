package com.example.practices.repostory;

import java.util.List;
import java.util.Optional;

import com.example.practices.dto.AddressUserDTO;
import com.example.practices.dto.UserWithFieldsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.practices.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

	User findByName(String name);
	User  findByNameAndMobileNumber(String name,String mobilenumber);

	@Query(value = "select  distinct ad.district_name , us.name from user us  INNER JOIN  user_address ua on us.id = ua.user_id inner JOIN address ad on ad.district_name='bangalor'",nativeQuery = true)
	List<AddressUserDTO> findByAddress();

	@Query(value = "select new com.example.practices.dto.UserWithFieldsDTO(u.name,ad.districtName) from User u  join u.address ad on ad.districtName='bangalor'")
	List<UserWithFieldsDTO>  findByJpaAddreaa();



}
