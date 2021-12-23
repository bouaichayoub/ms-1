package com.ms.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.demo.bean.Commande;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long>{
	Commande findByRef(String ref);
	
	int deleteByRef(String ref);
}
