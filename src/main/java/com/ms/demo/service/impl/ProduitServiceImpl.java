package com.ms.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.demo.bean.Produit;
import com.ms.demo.dao.ProduitDao;
import com.ms.demo.service.facade.ProduitService;

@Service
public class ProduitServiceImpl implements ProduitService{

	@Autowired
	private ProduitDao produitDao;
	
	@Override
	@Transactional
	public int deleteByRef(String ref) {
		return produitDao.deleteByRef(ref);
	}
	
	@Override
	public int save(Produit produit) {
		if(findByNom(produit.getNom()) != null) {
			return -1;
		}else {
			produitDao.save(produit);
			return 1;
		}
	}

	@Override
	public Produit findByNom(String nom) {
		return produitDao.findByNom(nom);
	}

	@Override
	public Produit findByRef(String ref) {
		return produitDao.findByRef(ref);
	}

	@Override
	public List<Produit> findAll() {
		return produitDao.findAll();
	}

	@Override
	public Produit findById(Long id) {
		return produitDao.getById(id);
	}
}
