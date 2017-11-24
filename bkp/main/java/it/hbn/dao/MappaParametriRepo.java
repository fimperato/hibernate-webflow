package it.hbn.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import it.hbn.model.MappaParametri;

@Transactional
public interface MappaParametriRepo extends CrudRepository<MappaParametri, Integer> {
	
	//  Iterable<T> findAll();
	// 	https://docs.spring.io/spring-data/commons/docs/1.8.6.RELEASE/reference/html/repositories.html
		
}
