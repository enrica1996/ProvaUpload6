package com.sistemi.informativi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistemi.informativi.entity.Address;
import com.sistemi.informativi.entity.People;
import com.sistemi.informativi.service.PeopleAddressService;

@SpringBootApplication
public class SbJpaEsercizioOnetomanyApplication implements CommandLineRunner{
	
	@Autowired
	private PeopleAddressService peopleAddressService;

	public static void main(String[] args) {
		SpringApplication.run(SbJpaEsercizioOnetomanyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		People people = new People ("prova","Rino", "Rano", 33);
		peopleAddressService.checkAddPeople(people);
		
		Address address1 = new Address("via Alcesti", "00133", "Roma", "Italia");
		Address address2 = new Address("via Andria", "00132", "Roma", "Italia");
		
		
		address1.setPeople(people);
		address2.setPeople(people);
		
		peopleAddressService.checkAddAddress(address1);
		peopleAddressService.checkAddAddress(address2);
		
		peopleAddressService.checkFindAllAddressByFiscalCode("prova");
	}

}
