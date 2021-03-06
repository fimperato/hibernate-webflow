package it.hbn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import it.hbn.config.AppConfig;
import it.hbn.config.HibernateConfiguration;
import it.hbn.model.MappaParametri;
import it.hbn.service.MappaParametriService;

public class AppMain {
	
	private static Logger logger = LoggerFactory.getLogger(HibernateConfiguration.class);
	
	private static String APP_MAIN = "APP";

	public static void main(String args[]) {
		
		logger.info("Main class start");

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	 
		MappaParametriService mappaParametriService = (MappaParametriService) context.getBean("mappaParametriService");
	        
        /*
         * Create MappaParametri
         */
        MappaParametri mp0 = new MappaParametri();
        mp0.setCodParametro(100);
        mp0.setDesParametro("descrizione");
        mp0.setUser(AppMain.APP_MAIN);
        MappaParametri mp1 = new MappaParametri();
        mp1.setCodParametro(101);
        
        /*
         * Persist MappaParametri
         */
        mappaParametriService.saveMappaParametri(mp0);
        mappaParametriService.saveMappaParametri(mp1);
 
        /*
         * Get all mappaParametri list from database
         */
        boolean check=checkItems(mappaParametriService.getAllEntities());
        
        /*
         * Delete MappaParametri
         */
        if(check) {
        	Iterable<MappaParametri> mpList = mappaParametriService.getAllEntities();
	        for (MappaParametri mp : mpList) {
	            logger.info("Delete MappaParametri with code: "+mp.getCodParametro()+".");
	            mappaParametriService.deleteMappaParametri(mp);
	        }
	        // Check after delete:
	        checkItems(mappaParametriService.getAllEntities());
        }
        
        context.close();
	}

	private static boolean checkItems(Iterable<MappaParametri> mpList) {
		int i=0;
		if(mpList!=null) {
		    for (MappaParametri mp : mpList) {
		        logger.info("MappaParametri with code: "+mp.getCodParametro()+" is in DB.");
		        i++;
		    } 
		} else {
			logger.info("No items found");
		}
		return i>0?true:false;
	}
	 
}
