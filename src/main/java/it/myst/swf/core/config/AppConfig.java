package it.myst.swf.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import it.myst.swf.core.config.db.HibernateConfiguration;
import it.myst.swf.core.config.db.PersistenceContextConfiguration;

@Configuration
@ComponentScan({ "it.myst.swf.utility.domain", "it.myst.swf.utility.repository.dao", 
	"it.myst.swf.utility.business.service", 
	"it.myst.swf.core.web.backingbean", "it.myst.swf.core.backingbean", 
	"it.myst.swf.web.backingbean", "it.myst.swf.web.controllerbean", "it.myst.swf.core.spring.utils" })
@Import(value={
		HibernateConfiguration.class,
		PersistenceContextConfiguration.class,
		WebMvcConfig.class, 
		WebFlowConfig.class,
		WebBeanConfig.class,
		BeanConfig.class
	})
public class AppConfig {

	
}
