package com.dawes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.ConcejoVO;

@Repository
public interface ConcejoRepo extends JpaRepository<ConcejoVO, Integer> {
	
	

}
