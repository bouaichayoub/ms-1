package com.ms.demo.service.facade;

import java.util.List;

import com.ms.demo.bean.Client;

public interface ClientService {
	
	Client findByRaisonSociale(String raisonSociale);
	
	List<Client> findByVille(String ville);
	
	List<Client> findAll();
	
	int save(Client client);
	
	Client findById(Long id);
}
