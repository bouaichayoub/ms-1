package com.ms.demo.ws.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.demo.bean.Client;
import com.ms.demo.service.facade.ClientService;

@RestController
@RequestMapping(value="/api/client")
public class ClientRest {
	@Autowired
	ClientService clientService;
	
	@GetMapping("/raisonsocial/{raisonSociale}")
	public Client findByRaisonSociale(@PathVariable String raisonSociale) {
		return clientService.findByRaisonSociale(raisonSociale);
	}
	@GetMapping("/ville/{ville}")
	public List<Client> findByVille(@PathVariable  String ville){
		return clientService.findByVille(ville);
	}
	
	@PostMapping("/")
	public int save(@RequestBody Client client){
		return clientService.save(client);
	}
	@GetMapping("/")
	public List<Client> findAll(){
		return clientService.findAll();
	}
}
