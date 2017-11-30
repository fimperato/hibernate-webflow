package it.myst.swf.utility.business.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.myst.swf.utility.business.service.MappaParametriService;
import it.myst.swf.utility.domain.entity.MappaParametri;
import it.myst.swf.utility.repository.dao.MappaParametriRepo;

@Transactional
@Service("mappaParametriService")
public class MappaParametriServiceImpl implements MappaParametriService {
	
	private static Logger logger = LoggerFactory.getLogger(MappaParametriServiceImpl.class);
	
	@Autowired
	MappaParametriRepo mappaParametriRepo;
	
	@Override
	public Iterable<MappaParametri> getAllEntities() {
		return mappaParametriRepo.findAll();
	}
	
	@Override
	public MappaParametri saveMappaParametri(MappaParametri entity) {
		entity = mappaParametriRepo.save(entity);
		logger.info("[Service] Save entity with id: "+entity.getCodParametro()+" completed.");
		return entity;
	}
	
	@Override
	public Iterable<MappaParametri> saveMappaParametriList(List<MappaParametri> entities) {
		Iterable<MappaParametri> collection = mappaParametriRepo.save(entities);
		int size=0;
		if(entities!=null) {
			size=entities.size();
		}
		logger.info("[Service] Save n. "+size+" entities");
		return collection;
	}
	
	@Override
	public void deleteMappaParametri(MappaParametri entity) {
		Integer id = entity.getCodParametro();
		mappaParametriRepo.delete(entity);
		logger.info("[Service] Delete entity with id: "+id+" completed");
	}
}
