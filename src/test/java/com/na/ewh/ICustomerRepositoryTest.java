package com.na.ewh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.na.ewh.model.AddressInfo;
import com.na.ewh.model.ContactInfo;
import com.na.ewh.model.CustomerInfo;
import com.na.ewh.repositroy.ICustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ICustomerRepositoryTest {
	@Autowired 
	ICustomerRepository customerRepository;

	@Test
	public void testIfCustomerRepoIsNonNull(){
		assertThat(customerRepository).isNotNull();
	}

	@Test
	public void testSaveAndPrintCustomer() {
		ContactInfo contact = new ContactInfo();

		AddressInfo address = new AddressInfo();

		CustomerInfo customer = new CustomerInfo();
		contact.setCustomer(customer);
		address.setCustomer(customer);

		customer.setInitial("Mr");
		customer.setCustomerType("Trader");
		customer.setFirstName("Mohan");
		customer.setMiddleName("Lal");
		customer.setLastName("Bagwaan");
		customer.setAddress(address);
		customer.setContact(contact);

		CustomerInfo savedCustomer = customerRepository.save(customer);
		assertThat(savedCustomer).isNotNull();
		System.out.println(savedCustomer);
	}
}