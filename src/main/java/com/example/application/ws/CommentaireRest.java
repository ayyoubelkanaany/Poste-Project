package com.example.application.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.bean.Commentaire;
import com.example.application.service.facad.CommentaireService;
import com.example.application.service.impl.CommentaireServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("cette classe permet de gerer les Commentaires")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CommentaireRest {
	@Autowired
	private CommentaireService commentaireService;
	 @ApiOperation("cette methode permet de mettre a jour un commentaire")
	 @RequestMapping(value = "/commentaires/{idCommentaire}",method = RequestMethod.GET)
	public Commentaire getById(@PathVariable Long idCommentaire) {
		return commentaireService.getById(idCommentaire);
	}
	@ApiOperation("cette methode permet d'ajouter un commentaire")
	@RequestMapping(value = "/commentaires/{idPoste}",method = RequestMethod.POST)
	public Commentaire addCommentaire(@PathVariable Long idPoste,@RequestBody Commentaire commentaire) {
		return commentaireService.addCommentaire(idPoste,commentaire);
	}
    @ApiOperation("cette methode permet de supprimer un commentaire")
	@RequestMapping(value = "/commentaires/{id}",method = RequestMethod.DELETE)
	public boolean deleteCommentaire(@PathVariable Long id) {
		return commentaireService.deleteCommentaire(id);
	}
    @ApiOperation("cette methode permet de mettre a jour un commentaire")
	@RequestMapping(value = "/commentaires",method = RequestMethod.PUT)
	public Commentaire updateCommentaire(@RequestBody Commentaire commentaire) {
		return commentaireService.updateCommentaire(commentaire);
	}

}
