package com.example.application.ws;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.application.bean.Commentaire;
import com.example.application.bean.Poste;
import com.example.application.bean.Reaction;
import com.example.application.bean.Utilisateur;
import com.example.application.service.impl.UtilisateurServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api("cette classe permet de gerer la collection utilisateur")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UtilisateurRest {
	@Autowired
	private UtilisateurServiceImpl utilisateurServiceImpl;
        
    
    @ApiOperation("cette methode permet d'ajouter un utilisateur")
	@RequestMapping(value = "/Utilisateurs",method = RequestMethod.POST)
    public Utilisateur save(@RequestBody Utilisateur utilisateur) {
    	
		return utilisateurServiceImpl.save(utilisateur);
	}
    @ApiOperation("cette methode permet de recuperer la liste des utilisateurs")
	@RequestMapping(value = "/Utilisateurs",method = RequestMethod.GET)
	public List<Utilisateur> findAll() {
		return utilisateurServiceImpl.findAll();
	}
    @ApiOperation("cette methode permet de recuperer un utilisateur depuis son id")	
    @RequestMapping(value = "/Utilisateurs/id/{id}",method = RequestMethod.GET)
	public Utilisateur findById(@PathVariable Long idUtilisateur) {
		return utilisateurServiceImpl.findById(idUtilisateur);
	}
    @ApiOperation("cette methode permet de recuperer un utilisateur depuis son mail")	
    @RequestMapping(value = "/Utilisateurs/mail/{mail}",method = RequestMethod.GET)
	public Utilisateur findByMail(@PathVariable String mail) {
		return utilisateurServiceImpl.findByMail(mail);
	}
    @ApiOperation("cette methode permet de recuperer un utilisateur depuis son nom")	
	@RequestMapping(value = "/Utilisateurs/nom/{nom}",method = RequestMethod.GET)
	public List<Utilisateur> getByNom(@PathVariable String nom) {
		return utilisateurServiceImpl.getByNom(nom);
	}
    @ApiOperation("cette methode permet de recuperer un utilisateur depuis le domaine de ces poste")	
	@RequestMapping(value = "/Utilisateurs/poste/categorie/{categorie}",method = RequestMethod.GET)
	public List<Utilisateur> getByPostesCategorie(@PathVariable String categorie) {
		return utilisateurServiceImpl.getByPostesCategorie(categorie);
	}
    @ApiOperation("cette methode permet de recuperer un utilisateur depuis la date de ces poste")	
	@RequestMapping(value = "/Utilisateurs/poste/datePoste/{datePoste}",method = RequestMethod.GET)
	public List<Utilisateur> getByPostesDatePoste(@PathVariable String datePoste) {
		return utilisateurServiceImpl.getByPostesCategorie(datePoste);
	}
    
    @ApiOperation("cette methode permet de recuperer un utilisateur depuis la date de ces poste")	
   	@RequestMapping(value = "/Utilisateurs/count",method = RequestMethod.GET)
   	public List<Utilisateur> getUtilisateurByOrderByCountByPostesAsc() {
   		return utilisateurServiceImpl.getUtilisateurByOrderByCountByPostesAsc();
   	}
   
}