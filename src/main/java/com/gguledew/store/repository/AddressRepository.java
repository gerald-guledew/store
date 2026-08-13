package com.gguledew.store.repository;

import com.gguledew.store.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}