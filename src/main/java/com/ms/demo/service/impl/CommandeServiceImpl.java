package com.ms.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ms.demo.bean.Client;
import com.ms.demo.bean.Commande;
import com.ms.demo.dao.CommandeDao;
import com.ms.demo.service.facade.ClientService;
import com.ms.demo.service.facade.CommandeService;


@Service
public class CommandeServiceImpl implements CommandeService{

	Logger logger= LoggerFactory.getLogger(CommandeService.class);
	@Autowired
	private CommandeDao commandeDao;
	
	@Autowired
	private ClientService clientService;
	
	@Override
	public Commande findByRef(String ref) {
		logger.info("find By Ref : "+ref);
		return commandeDao.findByRef(ref);
	}

	@Override
	@Transactional
	public int deleteByRef(String ref) {
		return commandeDao.deleteByRef(ref);
	}

	@Override
	public int save(Commande commande) {
		if(findByRef(commande.getRef()) != null) {
			return -1;
		}
		Client client = clientService.findById(commande.getClient().getId());
		if(client == null || client.getId() == null){
			client = clientService.findByRaisonSociale(commande.getClient().getRaisonSociale());
		}
		if(client == null || client.getId() == null){
			return -2;
		}else {
			commandeDao.save(commande);
			return 1;
		}
	}

}
