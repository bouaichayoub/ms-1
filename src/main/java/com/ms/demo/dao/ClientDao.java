package com.ms.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.demo.bean.Client;

@Repository
public interface ClientDao extends JpaRepository<Client, Long>{
	
	Client findByRaisonSociale(String raisonSociale);
	
	List<Client> findByVille(String ville);
}
