package com.blogged.pet.repository;

import org.springframework.data.repository.CrudRepository;

import com.blogged.pet.domain.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByEmail(String email);
}
