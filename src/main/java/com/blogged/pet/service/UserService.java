package com.blogged.pet.service;

import com.blogged.pet.domain.User;
import com.blogged.pet.dto.UserRegistrationDto;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto userDto);
}
