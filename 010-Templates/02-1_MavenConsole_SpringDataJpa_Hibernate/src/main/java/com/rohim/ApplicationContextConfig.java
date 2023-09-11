package com.rohim;

import org.hibernate.dialect.Oracle12cDialect;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
		dataSource.setUrl("jdbc:oracle:thin:@//XXXXXXXXXX:1521/orcl");
		dataSource.setUsername("XXXXXXXXXX");
		dataSource.setPassword("XXXXXXXXXX");
		return dataSource;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		vendorAdapter.setDatabasePlatform(Oracle12cDialect.class.getName()); // org.hibernate.dialect.Oracle12cDialect

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.rohim");
		factory.setDataSource(dataSource());
		Map<String, Object> jpaProperties = new HashMap<>();
		jpaProperties.put("hibernate.physical_naming_strategy", new SpringPhysicalNamingStrategy()); // tableName -> table_name
		jpaProperties.put("hibernate.implicit_naming_strategy", new SpringImplicitNamingStrategy());
		jpaProperties.put("hibernate.format_sql", true);
		// optional: for debugging
		jpaProperties.put("hibernate.generate_statistics", true);
		factory.setJpaPropertyMap(jpaProperties);
		factory.afterPropertiesSet();

		return factory.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
}
