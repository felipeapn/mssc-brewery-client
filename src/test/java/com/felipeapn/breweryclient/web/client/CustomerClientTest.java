package com.felipeapn.breweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.felipeapn.breweryclient.web.model.CustomerDto;

@SpringBootTest
class CustomerClientTest {
	
	@Autowired
	CustomerClient client;

	@Test
	void testGetCustomerById() {
		CustomerDto dto = client.getCustomerById(UUID.randomUUID());
		
		assertNotNull(dto);
	}	

	@Test
	void testSaveNewBeer() {
		//given
		CustomerDto customerDto = CustomerDto.builder()
										.id(UUID.randomUUID())
										.name("Felipe")
										.build();
		
		URI uri = client.saveNewCustomer(customerDto);
		
		assertNotNull(uri);
		
		System.out.println(uri.toString());
	}

	@Test
	void testUpdateCustomer() {
		//given
		CustomerDto customerDto = CustomerDto.builder()
												.id(UUID.randomUUID())
												.name("Felipe")
												.build();
				
		client.updateCustomer(UUID.randomUUID(), customerDto);
	}

	@Test
	void testDeleteBeer() {
		client.deleteCustomer(UUID.randomUUID());
	}

}
