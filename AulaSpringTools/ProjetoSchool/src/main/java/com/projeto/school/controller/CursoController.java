package com.projeto.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.school.domain.Curso;
import com.projeto.school.repository.CursoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/curso")
public class CursoController {

	
	@Autowired
	private CursoRepository cursoRepo;
	
	@GetMapping("/listar")
	public List<Curso> listar(){
		return cursoRepo.findAll();
	}
}