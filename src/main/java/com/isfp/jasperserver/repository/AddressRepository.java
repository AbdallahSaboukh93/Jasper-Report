package com.isfp.jasperserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isfp.jasperserver.entity.AddressEntity;
@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long> {

}
