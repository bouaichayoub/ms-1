package com.ms.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.demo.bean.Client;
import com.ms.demo.dao.ClientDao;
import com.ms.demo.service.facade.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

	Logger logger= LoggerFactory.getLogger(ClientService.class);
	@Autowired
	private ClientDao clientDao;
	
	@Override
	public Client findByRaisonSociale(String raisonSociale) {
		return clientDao.findByRaisonSociale(raisonSociale);
	}

	@Override
	public List<Client> findByVille(String ville) {
		logger.debug("find By Ville :"+ville);
		return clientDao.findByVille(ville);
	}

	@Override
	public int save(Client client) {
		if(findByRaisonSociale(client.getRaisonSociale()) != null) {
			return -1;
		}else {
			clientDao.save(client);
			return 1;
		}
	}

	@Override
	public List<Client> findAll() {
		return clientDao.findAll();
	}

	@Override
	public Client findById(Long id) {
		return clientDao.getById(id);
	}

}
