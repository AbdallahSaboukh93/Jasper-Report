package com.isfp.jasperserver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.isfp.jasperserver.entity.AddressEntity;
import com.isfp.jasperserver.entity.UserEntity;
import com.isfp.jasperserver.repository.AddressRepository;
import com.isfp.jasperserver.repository.UserRepository;

@SpringBootTest
class JasperTest {
	@Autowired
	UserRepository userRepository;
	@Autowired
	AddressRepository addressRepository ;

	@Test
	public void createUserTest() {

		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName("abdallah");
		userEntity.setLastName("saboukh");
		userEntity.setEmail("aahah@yhoo.com");
		userEntity.setUserId("1");
		userRepository.save(userEntity) ;
		AddressEntity addressEntity = new AddressEntity();

		addressEntity.setUserDetails(userEntity);
		addressRepository.save(addressEntity);
	}

}
