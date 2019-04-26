package com.ibm.developer.multidatasource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibm.developer.multidatasource.MultiDatasourceApplication;
import com.ibm.developer.multidatasource.clinic.ClinicsRepo;
import com.ibm.developer.multidatasource.doctor.DoctorsRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MultiDatasourceApplication.class }, properties = {
		"clinics.datasource.url=jdbc:h2:mem:clinics-db;INIT=RUNSCRIPT FROM 'classpath:init-mysql.sql'", //
		"clinics.datasource.username=sa", //
		"clinics.datasource.password=sa",//
		"doctors.datasource.url=jdbc:h2:mem:doctors-db;INIT=RUNSCRIPT FROM 'classpath:init-postgres.sql'", //
		"doctors.datasource.username=sa", //
		"doctors.datasource.password=sa"
})
public class ITDatabaseConnections {

	@Autowired
	ClinicsRepo clinicsRepo;
	
	@Autowired
	DoctorsRepo doctorsRepo;

	@Test
	public void testReadingFromDatabase() {
		assertEquals(1, clinicsRepo.count());
		assertEquals(2, doctorsRepo.count());
	}

}
