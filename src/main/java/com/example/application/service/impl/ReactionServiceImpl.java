package com.example.application.service.impl;

import org.springframework.stereotype.Service;

import com.example.application.bean.Reaction;
import com.example.application.dao.ReactionDao;
import com.example.application.service.facad.ReactionService;
@Service
public class ReactionServiceImpl implements ReactionService {
    private ReactionDao reactionDao;
	@Override
	public Reaction addReaction(Reaction reaction) {
		
		return this.reactionDao.save(reaction);
	}

	@Override
	public boolean deleteReaction(Long id) {
		try {
			this.reactionDao.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public Reaction updateReaction(Reaction reaction) {
		
		return this.reactionDao.save(reaction);
	}

	@Override
	public Reaction getByReactionId(Long id) {
		
		return this.reactionDao.findById(id).get();
	}

	
}
