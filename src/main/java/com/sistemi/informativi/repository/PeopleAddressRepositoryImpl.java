package com.sistemi.informativi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sistemi.informativi.entity.Address;
import com.sistemi.informativi.entity.People;

@Repository
@Transactional
public class PeopleAddressRepositoryImpl implements PeopleAddressRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void addPeople(People people) {
		em.persist(people);
	}

	@Override
	public void addAddress(Address address) {
		em.persist(address);
	}

	@Override
	public People findPeopleById(String fiscalCode) {
		return em.find(People.class, fiscalCode);
	}

	@Override
	public List<Address> findAllAddressByPeople(People people) {
		return people.getAddress();
	}

}
