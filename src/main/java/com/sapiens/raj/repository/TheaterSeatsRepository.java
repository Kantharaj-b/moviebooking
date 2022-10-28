package com.sapiens.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sapiens.raj.model.TheaterSeatsEntity;


@Repository
public interface TheaterSeatsRepository extends JpaRepository<TheaterSeatsEntity, Long>, JpaSpecificationExecutor<TheaterSeatsEntity> {

}