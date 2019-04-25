package com.ibm.developer.multidatasource.clinic;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "clinicEntityManagerFactory", transactionManagerRef = "clinicTransactionManager")
public class ClinicsDatasourceConfiguration {
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "clinics.datasource")
	public DataSource clinicsDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	PlatformTransactionManager clinicTransactionManager(
			@Qualifier("clinicEntityManagerFactory") LocalContainerEntityManagerFactoryBean clinicEntityManagerFactory) {
		return new JpaTransactionManager(clinicEntityManagerFactory.getObject());
	}

	@Bean
	LocalContainerEntityManagerFactoryBean clinicEntityManagerFactory(
			@Qualifier("clinicsDataSource") DataSource clinicsDatasource, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(clinicsDatasource).packages(Clinic.class).build();
	}
}