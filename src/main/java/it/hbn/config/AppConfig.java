package it.hbn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;

@Configuration
@ComponentScan(basePackages = "it.hbn")
@Import(value= {HibernateConfiguration.class, PersistenceContextConfiguration.class})
public class AppConfig {

}
