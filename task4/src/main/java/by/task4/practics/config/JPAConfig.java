package by.task4.practics.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "by.task4.practics")
@EnableTransactionManagement
public class JPAConfig {

	@Bean
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("persistence");
    }
	 
	  @Bean
	  public PlatformTransactionManager transactionManager() {
	    JpaTransactionManager result = new JpaTransactionManager();
	    result.setEntityManagerFactory(entityManagerFactory());
	    return result;
	  }
	
}