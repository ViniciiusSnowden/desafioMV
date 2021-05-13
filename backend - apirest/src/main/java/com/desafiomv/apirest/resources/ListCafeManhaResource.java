package com.desafiomv.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiomv.apirest.repository.ListCafeManhaRepository;


import com.desafiomv.apirest.models.ListCafeManha;

@RestController
@RequestMapping(value="/api")
public class ListCafeManhaResource {

	@Autowired
	ListCafeManhaRepository listCafeManhaRepository;

	@GetMapping("/lista")
	public List<ListCafeManha> lista(){
		return listCafeManhaRepository.findAll();
	}
	
}
