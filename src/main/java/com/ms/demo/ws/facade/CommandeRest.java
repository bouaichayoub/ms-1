package com.ms.demo.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.demo.bean.Commande;
import com.ms.demo.service.facade.CommandeService;

@RestController
@RequestMapping(value= "/api/commande")
public class CommandeRest {
	
	@Autowired
	private CommandeService commandeService; 
	
	@GetMapping("/ref/{ref}")
	public Commande findByRef(@PathVariable String ref) {
		return commandeService.findByRef(ref);
	}
	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(String ref) {
		return commandeService.deleteByRef(ref);
	}
	
	@PostMapping("/")
	public int save(@RequestBody Commande commande){
		return commandeService.save(commande);
	}
}
