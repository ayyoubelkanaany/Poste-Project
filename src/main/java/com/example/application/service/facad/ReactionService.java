package com.example.application.service.facad;

import com.example.application.bean.Reaction;

public interface ReactionService {
	///add,delete and update Reaction
	  public Reaction addReaction(Reaction reaction);
	  public boolean deleteReaction(Long id);
	  public Reaction updateReaction(Reaction reaction);
	  public Reaction getByReactionId(Long id);
}
