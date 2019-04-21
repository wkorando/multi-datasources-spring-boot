package com.developer.ibm.multidatasource.doctor;

import org.springframework.data.repository.CrudRepository;

public interface DoctorsRepo extends CrudRepository<Doctor, Long> {

}
