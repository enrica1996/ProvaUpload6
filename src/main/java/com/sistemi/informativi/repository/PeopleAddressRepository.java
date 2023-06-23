package com.sistemi.informativi.repository;

import java.util.List;

import com.sistemi.informativi.entity.Address;
import com.sistemi.informativi.entity.People;

public interface PeopleAddressRepository {

	public void addPeople(People people);

	public void addAddress(Address address);
	
	public People findPeopleById(String fiscalCode);

	public List<Address> findAllAddressByPeople(People people);


}
