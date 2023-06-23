package com.sistemi.informativi.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.TransactionRequiredException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sistemi.informativi.entity.Address;
import com.sistemi.informativi.entity.People;
import com.sistemi.informativi.repository.PeopleAddressRepository;

@Service
public class PeopleAddressServiceImpl implements PeopleAddressService {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PeopleAddressRepository peopleAddressRepository;

	@Value("${message.people.success}")
	private String peopleSuccess;
	@Value("${message.people.error}")
	private String peopleError;

	@Value("${message.address.success}")
	private String addressSuccess;
	@Value("${message.address.error}")
	private String addressError;

	@Value("${message.people.list.error}")
	private String peopleListError;

	@Value("${message.people.find.error}")
	private String peopleFindError;

	@Override
	public void checkAddPeople(People people) {
		try {
			peopleAddressRepository.addPeople(people);
			log.info(peopleSuccess);
		} catch (IllegalArgumentException | EntityExistsException | TransactionRequiredException e) {
			e.printStackTrace();
			log.info(peopleError);
		}

	}

	@Override
	public void checkAddAddress(Address address) {
		try {
			peopleAddressRepository.addAddress(address);
			log.info(addressSuccess);
		} catch (IllegalArgumentException | EntityExistsException | TransactionRequiredException e) {
			e.printStackTrace();
			log.info(addressError);
		}

	}

	@Override
	public void checkFindAllAddressByFiscalCode(String fiscalCode) {

		List<Address> addresses = new ArrayList<>();

		People people = peopleAddressRepository.findPeopleById(fiscalCode);

		if (people != null) {
			addresses = peopleAddressRepository.findAllAddressByPeople(people);
			if (!addresses.isEmpty()) {
				addresses.forEach(address -> log.info(address.toString()));
			} else {
				log.info(peopleListError);
			}
		} else {
			log.info(peopleFindError);
		}

	}

}
