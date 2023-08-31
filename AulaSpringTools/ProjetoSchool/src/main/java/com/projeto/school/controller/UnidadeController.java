package com.projeto.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.school.domain.Unidade;
import com.projeto.school.repository.UnidadeRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/unidade")
public class UnidadeController {

	
	@Autowired
	private UnidadeRepository unidadeRepo;
	
	@GetMapping("/listar")
	public List<Unidade> listar(){
		return unidadeRepo.findAll();
	}
}
