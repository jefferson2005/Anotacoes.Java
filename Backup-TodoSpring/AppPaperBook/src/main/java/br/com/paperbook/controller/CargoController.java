package br.com.paperbook.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.paperbook.domain.Cargo;
import br.com.paperbook.domain.Categoria;
import br.com.paperbook.repository.CargoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/cargo")
public class CargoController {

	@Autowired
	private CargoRepository cargoRepo;
	
	@GetMapping("/listar")
	public List<Cargo> listar(){
		return cargoRepo.findAll();
	}
	
	@GetMapping("/buscar/{id}")
	public Optional<Cargo> buscar(@PathVariable Integer id) {
			return cargoRepo.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody Cargo cargo) {
		cargoRepo.save(cargo);
		return "Cargo cadastrado";
	}
	
	@PutMapping("/atualizar/{id}") 
	public String atualizar(@PathVariable Integer id,@RequestBody Cargo cargo) {
		Optional<Cargo> ct = cargoRepo.findById(id);
		String msg = "";
		
		if(ct.isPresent()) {
			
			Cargo c = new Cargo();
			c.setIdcargo(id);
			c.setBeneficio(cargo.getBeneficio());
			c.setCargahoraria(cargo.getCargahoraria());
			c.setSalario(cargo.getSalario());
			c.setTitulocargo(cargo.getTitulocargo());
			cargoRepo.save(c);
			
			msg = "Cargo atualizado";
		} else {
			msg = "Cargo não localizado.";
		}
		return msg;
	}
	
	@DeleteMapping("/apagar/{id}")
	public String apagar(@PathVariable Integer id) {
		cargoRepo.deleteById(id);
	
	return "Cargo Apagado";
		
	}
	
}
