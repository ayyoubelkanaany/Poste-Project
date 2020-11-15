package com.example.application.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.bean.Utilisateur;
import com.example.application.service.impl.UtilisateurServiceImpl;

@RestController
public class UtilisateurRest {
	@Autowired
	private UtilisateurServiceImpl utilisateurServiceImpl;
	 @RequestMapping(value = "/Utilisateurs/all",method = RequestMethod.GET)
	public List<Utilisateur> findAll() {
		return utilisateurServiceImpl.findAll();
	}
	@RequestMapping(value = "/Utilisateurs",method = RequestMethod.POST)
    public Utilisateur save(@RequestBody Utilisateur utilisateur) {
		return utilisateurServiceImpl.save(utilisateur);
	}
    @RequestMapping(value = "/Utilisateurs/id/{id}",method = RequestMethod.GET)
	public Utilisateur findById(@PathVariable String id) {
		return utilisateurServiceImpl.findById(id);
	}
	@RequestMapping(value = "/Utilisateurs/nom/{nom}",method = RequestMethod.GET)
	public List<Utilisateur> getByNom(@PathVariable String nom) {
		return utilisateurServiceImpl.getByNom(nom);
	}

}
