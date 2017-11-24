package it.test.config.h2;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

//@Configuration
//@EnableTransactionManagement
//@PropertySource({ "classpath:persistence.properties" })
//@ComponentScan({ "it.myst.swf.utility.domain" })
public class PersistenceConfig {
 
//   @Autowired
   private Environment env;
 
//   @Bean
   public LocalSessionFactoryBean sessionFactory() {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(restDataSource());
      sessionFactory.setPackagesToScan(
        new String[] { "it.myst.swf.utility.domain.entity" });
      sessionFactory.setHibernateProperties(hibernateProperties());
 
      return sessionFactory;
   }
 
//   @Bean
   public DataSource restDataSource() {
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(env.getProperty("db.driverClassName"));
      dataSource.setUrl(env.getProperty("db.url"));
      dataSource.setUsername(env.getProperty("db.user"));
      dataSource.setPassword(env.getProperty("db.pass"));
 
      return dataSource;
   }
 
//   @Bean
//   @Autowired
   public HibernateTransactionManager transactionManager(
     SessionFactory sessionFactory) {
  
      HibernateTransactionManager txManager= new HibernateTransactionManager();
      txManager.setSessionFactory(sessionFactory);
 
      return txManager;
   }
 
//   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
      return new PersistenceExceptionTranslationPostProcessor();
   }
 
   Properties hibernateProperties() {
      return new Properties() {
         {
            setProperty("hibernate.hbm2ddl.auto",
              env.getProperty("hibernate.hbm2ddl.auto"));
            setProperty("hibernate.dialect",
              env.getProperty("hibernate.dialect"));
            setProperty("hibernate.globally_quoted_identifiers",
             "true");
         }
      };
   }
}

