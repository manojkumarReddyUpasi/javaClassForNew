package com.example.practices.repostory;

import com.example.practices.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressEntityRepository extends JpaRepository<AddressEntity,Long> {

    Optional<AddressEntity> findByDistrictName(String districtName);
}
