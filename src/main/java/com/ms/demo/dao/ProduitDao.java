package com.ms.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.demo.bean.Produit;

@Repository
public interface ProduitDao extends JpaRepository<Produit, Long>{
	Produit findByNom(String ref);
	
	Produit findByRef(String nom);
	
	int deleteByRef(String ref);
}