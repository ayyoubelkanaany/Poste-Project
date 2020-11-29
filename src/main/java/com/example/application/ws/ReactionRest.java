package com.example.application.ws;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.application.bean.Reaction;
import com.example.application.dao.ReactionDao;
import com.example.application.service.facad.ReactionService;

import io.swagger.annotations.ApiOperation;

public class ReactionRest {
	private ReactionService reactionService;
	
	
	@ApiOperation("cette methode permet de retourner une reaction  poste")
	@RequestMapping(value = "/reactions",method = RequestMethod.GET)
    public Reaction getByReactionId(Long id) {
		return reactionService.getByReactionId(id);
	}
	@ApiOperation("cette methode permet d'ajouter une reaction pour poste")
	@RequestMapping(value = "/reactions",method = RequestMethod.POST)
	public Reaction addReaction(@RequestBody Reaction reaction) {
		return reactionService.addReaction(reaction);
	}
    @ApiOperation("cette methode permet de supprimer une reaction pour poste")
	@RequestMapping(value = "/Utilisateurs/reaction",method = RequestMethod.DELETE)
	public boolean deleteReaction(@PathVariable Long id) {
		return reactionService.deleteReaction(id);
	}
    @ApiOperation("cette methode permet de mettre a jour une reaction")
	@RequestMapping(value = "/Utilisateurs/reaction",method = RequestMethod.PUT)
	public Reaction updateReaction(@RequestBody Reaction reaction) {
		return reactionService.updateReaction(reaction);
	}


}
