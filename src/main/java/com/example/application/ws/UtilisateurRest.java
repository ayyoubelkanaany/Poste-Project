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
    
   
	@ApiOperation("cette methode permet d'ajouter un poste pour un utilisateur")
	@RequestMapping(value = "/Utilisateurs/poste/{idUtilisateur}",method = RequestMethod.POST)
	public Poste addPoste(@PathVariable Long idUtilisateur,@RequestBody Poste poste) {
		return utilisateurServiceImpl.addPoste(poste, idUtilisateur);
	}
    @ApiOperation("cette methode permet de supprimer un poste pour un utilisateur")
	@RequestMapping(value = "/Utilisateurs/poste",method = RequestMethod.DELETE)
	public boolean deletePoste(@RequestParam("idUtilisateur") Long id,@RequestParam("datePoste") String datePoste) {
		return utilisateurServiceImpl.deletePoste(id, datePoste);
	}
    @ApiOperation("cette methode permet de mettre a jour un poste pour un utilisateur")
	@RequestMapping(value = "/Utilisateurs/poste",method = RequestMethod.PUT)
	public Poste updatePoste(@RequestParam("idUtilisateur") Long idUtilisateur,@RequestBody Poste poste) {
		return utilisateurServiceImpl.updatePoste(idUtilisateur, poste);
	}
    
    
    
    @ApiOperation("cette methode permet d'ajouter un commentaire pour poste pour un utilisateur")
	@RequestMapping(value = "/Utilisateurs/commentaire",method = RequestMethod.POST)
	public Commentaire addCommentaire(@RequestParam("idUtilisateur") Long idUtilisateur,@RequestParam("datePoste") String datePoste,@RequestBody Commentaire commentaire) {
		return utilisateurServiceImpl.addCommentaire(idUtilisateur, datePoste, commentaire);
	}
    @ApiOperation("cette methode permet de supprimer un commentaire pour poste pour un utilisateur")
	@RequestMapping(value = "/Utilisateurs/commentaire",method = RequestMethod.DELETE)
	public boolean deleteCommentaire(@RequestParam("idUtilisateur") Long idUtilisateur,@RequestParam("dateCommentaire") String dateCommentaire) {
		return utilisateurServiceImpl.deleteCommentaire(idUtilisateur, dateCommentaire);
	}
    @ApiOperation("cette methode permet de mettre a jour un commentaire pour poste pour un utilisateur")
	@RequestMapping(value = "/Utilisateurs/commentaire",method = RequestMethod.PUT)
	public Commentaire updateCommentaire(@RequestParam("idUtilisateur")Long idUtilisateur, @RequestParam("dateCommentaire")String dateCommentaire,@RequestBody Commentaire commentaire) {
		return utilisateurServiceImpl.updateCommentaire(idUtilisateur, dateCommentaire, commentaire);
	}
    
    
    @ApiOperation("cette methode permet de retourner le nombre de reaction de type like pour un poste")
 	@RequestMapping(value = "/Utilisateurs/countlikeReactions",method = RequestMethod.GET)
    public int countRactionsLike(@RequestParam("idUtilisateur") Long idUtilisateur,@RequestParam("datePoste") String datePoste) {
		return utilisateurServiceImpl.countRactionsLike(idUtilisateur, datePoste);
	}
    @ApiOperation("cette methode permet de retourner le nombre de reaction de type Dislike pour un poste ")
 	@RequestMapping(value = "/Utilisateurs/countdislikeReactions",method = RequestMethod.GET)
    public int countRactionsDislike(@RequestParam("idUtilisateur") Long idUtilisateur,@RequestParam("datePoste") String datePoste) {
		return utilisateurServiceImpl.countRactionsDislike(idUtilisateur, datePoste);
	}
    @ApiOperation("cette methode permet de retourner le nombre de commentaire pour un poste")
 	@RequestMapping(value = "/Utilisateurs/commentaire",method = RequestMethod.GET)
	public int countCommentaires(@RequestParam("idUtilisateur") Long idUtilisateur, @RequestParam("datePoste") String datePoste) {
		return utilisateurServiceImpl.countCommentaires(idUtilisateur, datePoste);
	}
	
    
    
    
    @ApiOperation("cette methode permet d'ajouter une reaction pour poste pour un utilisateur")
	@RequestMapping(value = "/Utilisateurs/reaction",method = RequestMethod.POST)
	public Reaction addReaction(@RequestParam("idUtilisateur") Long idUtilisateur,@RequestParam("datePoste") String datePoste,@RequestBody Reaction reaction) {
		return utilisateurServiceImpl.addReaction(idUtilisateur, datePoste, reaction);
	}
    @ApiOperation("cette methode permet de supprimer une reaction pour poste pour un utilisateur")
	@RequestMapping(value = "/Utilisateurs/reaction",method = RequestMethod.DELETE)
	public boolean deleteReaction(@RequestParam("idUtilisateur")Long idUtilisateur,@RequestParam("dateReaction") String dateReaction) {
		return utilisateurServiceImpl.deleteReaction(idUtilisateur, dateReaction);
	}
    @ApiOperation("cette methode permet de mettre a jour une reaction pour poste pour un utilisateur")
	@RequestMapping(value = "/Utilisateurs/reaction",method = RequestMethod.PUT)
	public Reaction updateReaction(@RequestParam("idUtilisateur") Long idUtilisateur,@RequestParam("dateReaction") String dateReaction,@RequestBody Reaction reaction) {
		return utilisateurServiceImpl.updateReaction(idUtilisateur, dateReaction, reaction);
	}

    
    

    @ApiOperation("cette methode permet de retourner un utilisateur depuid son id")
	@RequestMapping(value = "/Utilisateurs/poste/{idUtilisateur}",method = RequestMethod.GET)
	public List<Poste> getAllUserPoste(@PathVariable Long idUtilisateur) {
		return utilisateurServiceImpl.getAllUserPoste(idUtilisateur);
	}
    
    
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
	public Utilisateur findById(@PathVariable Long id) {
		return utilisateurServiceImpl.findById(id);
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