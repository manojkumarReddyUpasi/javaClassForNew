package com.example.practices.repostory;

import com.example.practices.entity.AddressEntity;
import com.example.practices.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AddressEntityRepository extends JpaRepository<AddressEntity,Long> {

    Optional<AddressEntity> findByDistrictName(String districtName);
  @Query("select ad from AddressEntity ad where ad.state=:state")
    List<AddressEntity> findByStateEquals(State state);

    List<AddressEntity> findByState_Name(String state);
}
