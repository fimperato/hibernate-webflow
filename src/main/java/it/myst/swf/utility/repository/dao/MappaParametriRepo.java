package it.myst.swf.utility.repository.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.myst.swf.utility.domain.entity.MappaParametri;

@Transactional
public interface MappaParametriRepo extends CrudRepository<MappaParametri, Integer> {
	
	//  Iterable<T> findAll();
	// 	https://docs.spring.io/spring-data/commons/docs/1.8.6.RELEASE/reference/html/repositories.html
		
}
