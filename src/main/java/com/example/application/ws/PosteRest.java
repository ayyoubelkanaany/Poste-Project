package com.example.application.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.application.bean.Poste;
import com.example.application.service.facad.PosteService;

import io.swagger.annotations.ApiOperation;

public class PosteRest {
	@Autowired
    private PosteService posteService;
	
	@ApiOperation("cette methode permet d'ajouter un poste ")
	@RequestMapping(value = "/postes",method = RequestMethod.POST)
	public Poste addPoste(@RequestBody Poste poste) {
		return posteService.addPoste(poste);
	}
    @ApiOperation("cette methode permet de supprimer un poste")
	@RequestMapping(value = "/Utilisateurs/poste",method = RequestMethod.DELETE)
	public boolean deletePoste(@PathVariable Long id) {
		return posteService.deletePoste(id);
	}
    @ApiOperation("cette methode permet de mettre a jour un poste")
	@RequestMapping(value = "/Utilisateurs/poste",method = RequestMethod.PUT)
	public Poste updatePoste(@RequestBody Poste poste) {
		return posteService.updatePoste(poste);
	}
    
    
    
    @ApiOperation("cette methode permet de retourner le nombre de reaction de type like pour un poste")
 	@RequestMapping(value = "/postes/countlikeReactions",method = RequestMethod.GET)
    public int countRactionsLike(@PathVariable Long id) {
		return posteService.countRactionsLike(id);
	}
    @ApiOperation("cette methode permet de retourner le nombre de reaction de type Dislike pour un poste")
 	@RequestMapping(value = "/psote/countdislikeReactions",method = RequestMethod.GET)
    public int countRactionsDislike(@PathVariable Long id) {
		return posteService.countRactionsDislike(id);
	}
    @ApiOperation("cette methode permet de retourner le nombre de commentaire pour un poste")
 	@RequestMapping(value = "/poste/commentaire",method = RequestMethod.GET)
	public int countCommentaires(@PathVariable Long id) {
		return posteService.countCommentaires(id);
	}
	
}
