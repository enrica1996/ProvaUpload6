package com.sistemi.informativi.service;

import com.sistemi.informativi.entity.Address;
import com.sistemi.informativi.entity.People;

public interface PeopleAddressService {

	public void checkAddPeople(People people);

	public void checkAddAddress(Address address);

	public void checkFindAllAddressByFiscalCode(String FiscalCode);

}
