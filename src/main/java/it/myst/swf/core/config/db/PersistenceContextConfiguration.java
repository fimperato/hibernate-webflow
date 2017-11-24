package it.myst.swf.core.config.db;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource(value = { "classpath:persistence.properties" })
public class PersistenceContextConfiguration {
	
	@Autowired
    private Environment env;
	
	@Autowired
    private DataSource dataSource;
	
	/*
     * JPA Config Section:
     */
	
	@Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, 
                                                                Environment env) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("it.myst.swf.utility.domain");
 
        Properties jpaProperties = new Properties();
     
        //Configures the used database dialect. This allows Hibernate to create SQL
        //that is optimized for the used database.
        jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
 
        //Specifies the action that is invoked to the database when the Hibernate
        //SessionFactory is created or closed.
//        jpaProperties.put("hibernate.hbm2ddl.auto", 
//                env.getRequiredProperty("hibernate.hbm2ddl.auto")
//        );
 
        //Configures the naming strategy that is used when Hibernate creates
        //new database objects and schema elements
        jpaProperties.put("hibernate.ejb.naming_strategy", 
                env.getRequiredProperty("hibernate.ejb.naming_strategy")
        );
//        jpaProperties.put("spring.jpa.hibernate.naming_strategy", 
//                env.getRequiredProperty("spring.jpa.hibernate.naming_strategy")
//        );
 
        //If the value of this property is true, Hibernate writes all SQL
        //statements to the console.
        jpaProperties.put("hibernate.show_sql", 
                env.getRequiredProperty("hibernate.show_sql")
        );
 
        //If the value of this property is true, Hibernate will format the SQL
        //that is written to the console.
        jpaProperties.put("hibernate.format_sql", 
                env.getRequiredProperty("hibernate.format_sql")
        );
 
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
 
        return entityManagerFactoryBean;
    }
	
	@Bean
    public PlatformTransactionManager transactionManager() {
       JpaTransactionManager transactionManager = new JpaTransactionManager();
       transactionManager.setEntityManagerFactory(entityManagerFactory(dataSource, env).getObject());
       return transactionManager;
    }
    
	@Bean
    public DataSource getDataSource() {
		 final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		 dsLookup.setResourceRef(true);
		 DataSource dataSource = dsLookup.getDataSource("java:jboss/datasources/LocaleWebDS");
		 return dataSource;
    }
	
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
//        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
//        lef.setDataSource(dataSource);
//        lef.setJpaVendorAdapter(jpaVendorAdapter);
//        lef.setPackagesToScan("it.myst.swf.utility.domain");
//        return lef;
//    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(false);
        hibernateJpaVendorAdapter.setDatabase(Database.ORACLE);
        return hibernateJpaVendorAdapter;
    }
     
    //Add the other beans here
	
}
