package com.ms.demo.service.facade;

import com.ms.demo.bean.Commande;

public interface CommandeService {

	Commande findByRef(String ref);
	
	int deleteByRef(String ref);
	
	int save(Commande commande);
}
