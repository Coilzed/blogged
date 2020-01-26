package com.blogged.pet.utility;

import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.blogged.pet.dto.AccountRegistrationDto;

@Component
public class AccountValidator implements Validator<AccountRegistrationDto> {

    @Override
    public boolean isAccountDtoValid(AccountRegistrationDto dto) {
        return isEmailValid(dto.getEmail()) &&
                isPasswordValid(dto.getPassword()) &&
                isPasswordsMatch(dto.getPassword(), dto.getConfirmPassword());
    }

    public boolean isPasswordValid(String password) {
        //Real regex put on finish
//        return Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", password);
        return Objects.nonNull(password) && Pattern.matches(".+", password);
    }

    public boolean isPasswordsMatch(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public boolean isEmailValid(String email) {
        //Real regex put on finish
        //return Pattern.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", email);
        return Objects.nonNull(email) && Pattern.matches(".+", email);
    }


    public boolean isNameValid(String name) {
        //Real regex put on finish
        //return Pattern.matches("^[a-zA-Z]$", name);
        return Objects.nonNull(name) && Pattern.matches(".+", name);
    }
}
