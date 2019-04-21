package com.ibm.developer.multidatasource.doctor;

import org.springframework.data.repository.CrudRepository;

public interface DoctorsRepo extends CrudRepository<Doctor, Long> {

}
