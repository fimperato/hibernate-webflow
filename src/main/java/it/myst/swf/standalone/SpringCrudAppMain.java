package it.myst.swf.standalone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import it.myst.swf.core.config.AppConfig;
import it.myst.swf.utility.business.service.MappaParametriService;
import it.myst.swf.utility.domain.entity.MappaParametri;


public class SpringCrudAppMain {
	
	private static Logger logger = LoggerFactory.getLogger(SpringCrudAppMain.class);
	
	private static String APP_MAIN = "APP";

	public static void main(String args[]) {
		
		logger.info("SpringCrudAppMain class start");

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MappaParametriService mappaParametriService = (MappaParametriService) context.getBean("mappaParametriService");
	        
        /*
         * Create MappaParametri
         */
        MappaParametri mp0 = new MappaParametri();
        mp0.setCodParametro(100);
        mp0.setDesParametro("descrizione");
        mp0.setUser(SpringCrudAppMain.APP_MAIN);
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
