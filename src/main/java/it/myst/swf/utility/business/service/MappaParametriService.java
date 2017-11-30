package it.myst.swf.utility.business.service;

import java.util.List;

import it.myst.swf.utility.domain.entity.MappaParametri;

public interface MappaParametriService {

	Iterable<MappaParametri> getAllEntities();
	
	MappaParametri saveMappaParametri(MappaParametri entity);
	
	Iterable<MappaParametri> saveMappaParametriList(List<MappaParametri> entities);
	
	void deleteMappaParametri(MappaParametri entity);
	
}
