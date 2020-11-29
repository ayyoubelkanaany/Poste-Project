package com.example.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.bean.Commentaire;
import com.example.application.dao.CommentaireDao;
import com.example.application.service.facad.CommentaireService;
@Service
public class CommentaireServiceImpl implements CommentaireService{
	@Autowired
    private CommentaireDao commentaireDao;
	@Override
	public Commentaire addCommentaire(Commentaire commentaire) {
		
		return this.commentaireDao.save(commentaire);
	}

	@Override
	public boolean deleteCommentaire(Long id) {
		try {
			this.commentaireDao.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Commentaire updateCommentaire(Commentaire commentaire) {
		
		return this.commentaireDao.save(commentaire);
	}

	@Override
	public Commentaire getById(Long id) {
		return this.commentaireDao.findById(id).get();
	}

}
