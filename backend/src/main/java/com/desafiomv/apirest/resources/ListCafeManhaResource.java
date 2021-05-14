package com.desafiomv.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiomv.apirest.repository.ListCafeManhaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.desafiomv.apirest.models.ListCafeManha;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value="API REST ListaCafeManha")
public class ListCafeManhaResource {

	@Autowired
	ListCafeManhaRepository listCafeManhaRepository;

	
	@ApiOperation(value="Retorna Lista do café da manha")
	@GetMapping("/lista")
	public List<ListCafeManha> lista(){
		return listCafeManhaRepository.findAll();
		
	}
	
	
	@ApiOperation(value="Retorna Lista do café da manha pelo id")
	@GetMapping("/lista/{id}")
	public ListCafeManha listUnico(@PathVariable(value="id")long id){
		return listCafeManhaRepository.findById(id);
		
	}
	@ApiOperation(value="Inserir um novo item")
	@PostMapping("/insert")
	public ListCafeManha saveList(@RequestBody ListCafeManha listCafeManha) {
		return listCafeManhaRepository.save(listCafeManha);
	}
	
	@ApiOperation(value="Deletar um item")
	@DeleteMapping("/delete")
	public void deleteListCafeManha(@RequestBody ListCafeManha listCafeManha) {
		listCafeManhaRepository.delete(listCafeManha);
	}
	@ApiOperation(value="Atualiza um item")
	@PutMapping("/update")
	public ListCafeManha updateList(@RequestBody ListCafeManha listCafeManha) {
		return listCafeManhaRepository.save(listCafeManha);
	}
	
	
}
