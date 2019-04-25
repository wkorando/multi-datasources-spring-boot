package com.ibm.developer.multidatasource.doctor;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "doctorEntityManagerFactory", //
		transactionManagerRef = "doctorTransactionManager") //
public class DoctorsDatasourceConfiguration {
	@Bean
	@ConfigurationProperties(prefix = "doctors.datasource")
	DataSource doctorsDatasource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	PlatformTransactionManager doctorTransactionManager(
			@Qualifier("doctorEntityManagerFactory") LocalContainerEntityManagerFactoryBean doctorEntityManagerFactory) {
		return new JpaTransactionManager(doctorEntityManagerFactory.getObject());
	}

	@Bean
	LocalContainerEntityManagerFactoryBean doctorEntityManagerFactory(
			@Qualifier("doctorsDatasource") DataSource doctorsDatasource, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(doctorsDatasource).packages(Doctor.class).build();
	}
}