package com.ms.demo.service.facade;

import java.util.List;

import com.ms.demo.bean.Produit;

public interface ProduitService {
	
	Produit findByNom(String nom);
	
	Produit findByRef(String ref);
	
	List<Produit> findAll();
	
	int save(Produit Produit);
	
	Produit findById(Long id);

	int deleteByRef(String ref);
}
