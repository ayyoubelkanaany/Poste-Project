package com.example.application.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.bean.Poste;
import com.example.application.service.facad.PosteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api("cette classe permet de gerer les Postes")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PosteRest {
	@Autowired
    private PosteService posteService;
	
	@ApiOperation("cette methode permet d'ajouter un poste ")
	@RequestMapping(value = "/postes",method = RequestMethod.POST)
	public Poste addPoste(@RequestBody Poste poste) {
		return posteService.addPoste(poste);
	}
    @ApiOperation("cette methode permet de supprimer un poste")
	@RequestMapping(value = "/postes/{idPoste}",method = RequestMethod.DELETE)
	public boolean deletePoste(@PathVariable Long idPoste) {
		return posteService.deletePoste(idPoste);
	}
    @ApiOperation("cette methode permet de mettre a jour un poste")
	@RequestMapping(value = "/postes",method = RequestMethod.PUT)
	public Poste updatePoste(@RequestBody Poste poste) {
		return posteService.updatePoste(poste);
	}
    
    
    @ApiOperation("cette methode permet de retourner le nombre de reaction de type like pour un poste")
 	@RequestMapping(value = "/postes/count/like/{idPoste}",method = RequestMethod.GET)
    public int countRactionsLike(@PathVariable Long idPoste) {
		return posteService.countRactionsLike(idPoste);
	}
    @ApiOperation("cette methode permet de retourner le nombre de reaction de type Dislike pour un poste")
 	@RequestMapping(value = "/postes/count/dislike/{idPoste}",method = RequestMethod.GET)
    public int countRactionsDislike(@PathVariable Long idPoste) {
		return posteService.countRactionsDislike(idPoste);
	}
    @ApiOperation("cette methode permet de retourner le nombre de commentaire pour un poste")
 	@RequestMapping(value = "/postes/count/commentaire/{idPoste}",method = RequestMethod.GET)
	public int countCommentaires(@PathVariable Long idPoste) {
		return posteService.countCommentaires(idPoste);
	}
	
}
