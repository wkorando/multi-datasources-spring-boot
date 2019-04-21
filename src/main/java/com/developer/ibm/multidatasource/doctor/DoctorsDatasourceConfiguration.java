package com.developer.ibm.multidatasource.doctor;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "doctorEntityManagerFactory", //
		transactionManagerRef = "doctorTransactionManager") //
@ConfigurationProperties(prefix = "doctors-db.datasource")
public class DoctorsDatasourceConfiguration {
	private String url;
	private String username;
	private String password;
	private String database;
	private boolean generateDdl;

	private DataSource doctorsDatasource() {
		return DataSourceBuilder.create().url(url).username(username).password(password).build();
	}

	@Bean
	PlatformTransactionManager doctorTransactionManager(
			@Qualifier("doctorEntityManagerFactory") LocalContainerEntityManagerFactoryBean doctorEntityManagerFactory) {
		return new JpaTransactionManager(doctorEntityManagerFactory.getObject());
	}

	@Bean
	LocalContainerEntityManagerFactoryBean doctorEntityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(generateDdl);
		vendorAdapter.setDatabase(Database.valueOf(database));

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setDataSource(doctorsDatasource());
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan(Doctor.class.getPackage().getName());
		return factoryBean;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public void setGenerateDdl(boolean generateDdl) {
		this.generateDdl = generateDdl;
	}
}