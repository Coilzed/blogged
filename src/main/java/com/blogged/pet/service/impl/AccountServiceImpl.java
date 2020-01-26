package com.blogged.pet.service.impl;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.blogged.pet.domain.Account;
import com.blogged.pet.domain.Role;
import com.blogged.pet.dto.AccountRegistrationDto;
import com.blogged.pet.dto.PersonalInfoDto;
import com.blogged.pet.repository.AccountRepository;
import com.blogged.pet.service.UserService;
import com.blogged.pet.utility.AccountValidator;
import com.blogged.pet.utility.Validator;

@Service
public class AccountServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private Validator<AccountRegistrationDto> validator;

    @Autowired
    private AccountValidator accountValidator;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email);
        if (account == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User
                (account.getEmail(), account.getPassword(), mapRolesToAuthorities(account.getRole()));
    }

    @Override
    public Account createAccount(AccountRegistrationDto userDto) {
        if (!validator.isAccountDtoValid(userDto)) {
            LOG.debug("Invalid user");
            return null;
        }
        Account account = new Account();
        account.setEmail(userDto.getEmail());
        account.setPassword(passwordEncoder.encode(userDto.getPassword()));
        account.setRegisterDate(LocalDate.now());
        account.setRole(Role.USER);
        LOG.debug("User was created: " + account);
        return accountRepository.save(account);
    }

    @Override
    public Account changeUserInfo(PersonalInfoDto info, String email) {
        Account account = findByEmail(email);
        if (accountValidator.isEmailValid(info.getEmail())
                && Objects.isNull(findByEmail(info.getEmail()))) {
            account.setEmail(info.getEmail());
        }
        if (accountValidator.isNameValid(info.getFirstName())) {
            account.setFirstName(info.getLastName().trim());
        }
        if (accountValidator.isNameValid(info.getLastName())) {
            account.setLastName(info.getLastName().trim());
        }
        String newPassword = info.getNewPassword();
        if (accountValidator.isPasswordValid(newPassword)
                && accountValidator.isPasswordsMatch(newPassword, info.getNewPasswordConfirm())) {
            String oldPassword = findByEmail(email).getPassword();
            if (oldPassword.equals(info.getOldPassword()) && oldPassword.equals(newPassword)) {
                account.setPassword(newPassword);
            }
        }
        return accountRepository.save(account);
    }

    @Override
    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Role role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role.toString()));
    }
}
