package it.hbn.model.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.hbn.constants.ConstantsApp;
import it.hbn.model.MappaParametri;

public class MappaParametriListener {
	
	private static Logger logger = LoggerFactory.getLogger(MappaParametriListener.class);
	
	@PrePersist
	public void entityPrePersist(MappaParametri entity) {
		logger.info("Listening Entity Pre Persist : " + entity.getCodParametro());
		if (entity.getUser() == null) { 
			entity.setUser(ConstantsApp.USER_DEFAULT); 
		}
	}
	
	@PostPersist
	public void entityPostPersist(MappaParametri entity) {
		logger.info("Listening Entity Post Persist : " + entity.getCodParametro());
	}
	
	@PostLoad
	public void entityPostLoad(MappaParametri entity) {
		logger.info("Listening Entity Post Load : " + entity.getCodParametro());
	}	
	
	@PreUpdate
	public void entityPreUpdate(MappaParametri entity) {
		logger.info("Listening Entity Pre Update : " + entity.getCodParametro());
	}
	
	@PostUpdate
	public void entityPostUpdate(MappaParametri entity) {
		logger.info("Listening Entity Post Update : " + entity.getCodParametro());
	}
	
	@PreRemove
	public void entityPreRemove(MappaParametri entity) {
		logger.info("Listening Entity Pre Remove : " + entity.getCodParametro());
	}
	
	@PostRemove
	public void entityPostRemove(MappaParametri entity) {
		logger.info("Listening Entity Post Remove : " + entity.getCodParametro());
	}
	
} 
