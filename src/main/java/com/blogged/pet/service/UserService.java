package com.blogged.pet.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.blogged.pet.domain.Account;
import com.blogged.pet.dto.AccountRegistrationDto;
import com.blogged.pet.dto.PersonalInfoDto;

public interface UserService extends UserDetailsService {

    Account findByEmail(String email);

    Account createAccount(AccountRegistrationDto userDto);

    Account changeUserInfo(PersonalInfoDto personalInfoDto, String email);
}
