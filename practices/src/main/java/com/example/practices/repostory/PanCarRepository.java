package com.example.practices.repostory;

import com.example.practices.entity.PanCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanCarRepository extends JpaRepository<PanCard,Long> {
}
