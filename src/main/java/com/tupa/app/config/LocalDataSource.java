package com.tupa.app.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tupa.app.data.Bank;

@PropertySource("classpath:/application.properties")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.tupa.app.repository")
@ComponentScan
public class LocalDataSource {
	
	@Bean(name="dataSource")
	public DataSource dataSource(Environment env) throws Exception{

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) throws Exception{

		HibernateJpaVendorAdapter jpaVendor = new HibernateJpaVendorAdapter();
		jpaVendor.setDatabase(Database.MYSQL);
		jpaVendor.setShowSql(true);
		jpaVendor.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setJpaVendorAdapter(jpaVendor);
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setPackagesToScan(Bank.class.getPackage().getName());
		return entityManagerFactory;
	}

	@Bean
	public PlatformTransactionManager transactionManager (
			EntityManagerFactory entityManagerFactory, DataSource dataSource)throws Exception {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory(dataSource).getObject());
		return transactionManager;

	}

}
