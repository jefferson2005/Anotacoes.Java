package br.com.paperbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paperbook.domain.Cliente;
import br.com.paperbook.repository.ClienteRepository;


@RequestMapping("/api/v1/cliente")
@RestController
@CrossOrigin(origins="*")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@GetMapping("/listar")
	public List<Cliente> listar(){
		
		return clienteRepo.findAll();	
		}

}
