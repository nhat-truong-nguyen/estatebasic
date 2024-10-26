package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.RentAreaEntity;

@Repository
public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long>{
}
