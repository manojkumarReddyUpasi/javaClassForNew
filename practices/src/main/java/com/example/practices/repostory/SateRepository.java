package com.example.practices.repostory;

import com.example.practices.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SateRepository extends JpaRepository<State,Long> {
    Optional<State> findByName(String state);
}
