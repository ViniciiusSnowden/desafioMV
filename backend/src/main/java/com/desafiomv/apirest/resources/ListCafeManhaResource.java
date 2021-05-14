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

@RestController
@RequestMapping(value="/api")
@Api(value="API REST ListaCafeManha")
@CrossOrigin(origins="")
public class ListCafeManhaResource {

	@Autowired
	ListCafeManhaRepository listCafeManhaRepository;

	@GetMapping("/lista")
	@ApiOperation(value="Retorna Lista do café da manha")
	public List<ListCafeManha> lista(){
		return listCafeManhaRepository.findAll();
		
	}
	
	@GetMapping("/lista/{id}")
	@ApiOperation(value="Retorna Lista do café da manha pelo id")
	public ListCafeManha listUnico(@PathVariable(value="id")long id){
		return listCafeManhaRepository.findById(id);
		
	}
	@PostMapping("/insert")
	@ApiOperation(value="Inserir um novo item")
	public ListCafeManha saveList(@RequestBody ListCafeManha listCafeManha) {
		return listCafeManhaRepository.save(listCafeManha);
	}
	
	@DeleteMapping("/delete")
	@ApiOperation(value="Deletar um item")
	public void deleteListCafeManha(@RequestBody ListCafeManha listCafeManha) {
		listCafeManhaRepository.delete(listCafeManha);
	}
	
	@PutMapping("/update")
	@ApiOperation(value="Atualiza um item")
	public ListCafeManha updateList(@RequestBody ListCafeManha listCafeManha) {
		return listCafeManhaRepository.save(listCafeManha);
	}
	
	
}
