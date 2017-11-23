package it.hbn.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.hbn.dao.MappaParametriRepo;
import it.hbn.model.MappaParametri;

@Transactional
@Service("mappaParametriService")
public class MappaParametriService {
	
	private static Logger logger = LoggerFactory.getLogger(MappaParametriService.class);
	
	@Autowired
	MappaParametriRepo mappaParametriRepo;
	
	public Iterable<MappaParametri> getAllEntities() {
		return mappaParametriRepo.findAll();
	}
	
	public MappaParametri saveMappaParametri(MappaParametri entity) {
		entity = mappaParametriRepo.save(entity);
		logger.info("[Service] Save entity with id: "+entity.getCodParametro()+" completed.");
		return entity;
	}
	
	public Iterable<MappaParametri> saveMappaParametriList(List<MappaParametri> entities) {
		Iterable<MappaParametri> collection = mappaParametriRepo.save(entities);
		int size=0;
		if(entities!=null) {
			size=entities.size();
		}
		logger.info("[Service] Save n. "+size+" entities");
		return collection;
	}
	
	public void deleteMappaParametri(MappaParametri entity) {
		Integer id = entity.getCodParametro();
		mappaParametriRepo.delete(entity);
		logger.info("[Service] Delete entity with id: "+id+" completed");
	}
}
