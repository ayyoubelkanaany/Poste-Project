package com.example.application.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.application.bean.Poste;
import com.example.application.bean.Reaction;
import com.example.application.bean.Utilisateur;
import com.example.application.dao.PosteDao;
import com.example.application.service.facad.PosteService;
@Service
public class PosteServiceImpl implements PosteService{
	@Autowired
    private PosteDao posteDao;
    //////////////////////////////////////////////////////////les postes
    
	@Override
	public Poste getById(Long id) {
		return this.posteDao.findById(id).get();
	}
	@Override
	public Poste addPoste(Poste poste) {
		
		return this.posteDao.save(poste);
	}
	@Override
	public boolean deletePoste(Long id) {
		try {
			this.posteDao.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}
	@Override
	public Poste updatePoste(Poste poste) {
		
		return this.posteDao.save(poste);
	}
	@Override
	public List<Poste> getAllPoste() {
		
		return this.posteDao.findAll();
	}
	@Override
	public int countRactionsLike(Long id) {
		int  count = 0;
		Poste loadedPosteDao = this.posteDao.findById(id).get();
		List<Reaction> loadedReactions = loadedPosteDao.getReactions();
			for(int i =0;i<loadedReactions.size();i++) {
				if(loadedReactions.get(i).getType().equals("like")) {
				count++;
			}
		}
		return count;
	}
	@Override
	public int countRactionsDislike(Long id) {
		int  count = 0;
		Poste loadedPosteDao = this.posteDao.findById(id).get();
		List<Reaction> loadedReactions = loadedPosteDao.getReactions();
			for(int i =0;i<loadedReactions.size();i++) {
				if(loadedReactions.get(i).getType().equals("dislike")) {
				count++;
			}
		}
		return count;
	}
	@Override
	public int countCommentaires(Long id) {
		Poste loadedPosteDao = this.posteDao.findById(id).get();
		return loadedPosteDao.getCommentaires().size();
	}
	private String newDate() {
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String stringDate= DateFor.format(date);
		return stringDate;
	}
}
