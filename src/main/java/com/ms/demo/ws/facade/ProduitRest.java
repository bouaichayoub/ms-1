package com.ms.demo.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.demo.bean.Produit;
import com.ms.demo.service.facade.ProduitService;

@RestController
@RequestMapping(value= "api/produit")
public class ProduitRest {
	
	@Autowired
	private ProduitService produitService; 
	
	@GetMapping("/ref/{ref}")
	public Produit findByRef(@PathVariable String ref) {
		return produitService.findByRef(ref);
	}
	@GetMapping("/nom/{nom}")
	public Produit findByNom(@PathVariable String nom) {
		return produitService.findByNom(nom);
	}
	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(String ref) {
		return produitService.deleteByRef(ref);
	}
	
	@PostMapping("/")
	public int save(@RequestBody Produit Produit){
		return produitService.save(Produit);
	}
}
