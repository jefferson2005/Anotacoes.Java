package br.com.school.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.school.domain.Area;
import br.com.school.repository.AreaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/area")
public class AreaController {

	@Autowired
	private AreaRepository areaRepo;
	@GetMapping("/listar")
	
	public List<Area> listar(){
		return areaRepo.findAll();
	}
	
	@GetMapping("/buscar/{id}")
	public Optional<Area> buscar(@PathVariable Integer id){
		return areaRepo.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public Area cadastrar(@RequestBody Area area) {
		return areaRepo.save(area);
	}
}
