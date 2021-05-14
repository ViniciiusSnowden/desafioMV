package com.desafiomv.apirest.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiomv.apirest.models.ListCafeManha;


public interface ListCafeManhaRepository extends JpaRepository<ListCafeManha, Long>{

	ListCafeManha findById(long id);
	

}
