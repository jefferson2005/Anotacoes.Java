package com.projeto.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.school.domain.Area;
import com.projeto.school.repository.AreaRepository;

@RestController
@RequestMapping("/api/v1/area")
public class AreaController {

	
	@Autowired
	private AreaRepository areaRepo;
	
	@GetMapping("/listar")
	public List<Area> listar(){
		return areaRepo.findAll();
	}
}
