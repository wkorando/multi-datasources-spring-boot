package com.ibm.developer.multidatasource.clinic;

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
@EnableJpaRepositories(entityManagerFactoryRef = "clinicEntityManagerFactory", //
		transactionManagerRef = "clinicTransactionManager")
@ConfigurationProperties(prefix = "clinics-db.datasource")
public class ClinicsDatasourceConfiguration {

	private String url;
	private String username;
	private String password;
	private boolean generateDdl;

	private DataSource clinicsDatasource() {
		return DataSourceBuilder.create().url(url).username(username).password(password).build();
	}

	@Bean
	PlatformTransactionManager clinicTransactionManager(
			@Qualifier("clinicEntityManagerFactory") LocalContainerEntityManagerFactoryBean clinicEntityManagerFactory) {
		return new JpaTransactionManager(clinicEntityManagerFactory.getObject());
	}

	@Bean
	LocalContainerEntityManagerFactoryBean clinicEntityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(generateDdl);
		vendorAdapter.setShowSql(true);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(clinicsDatasource());
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan(Clinic.class.getPackage().getName());
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

	public void setGenerateDdl(boolean generateDdl) {
		this.generateDdl = generateDdl;
	}
}