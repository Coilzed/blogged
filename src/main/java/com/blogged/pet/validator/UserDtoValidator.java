package com.blogged.pet.validator;

import com.blogged.pet.dto.UserRegistrationDto;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;


@Component
public class UserDtoValidator implements Validator<UserRegistrationDto> {

    @Override
    public boolean isValid(UserRegistrationDto dto) {
        return isEmailValid(dto) &&
                isPasswordValid(dto) &&
                isPasswordsMatch(dto);
    }

    private boolean isPasswordValid(UserRegistrationDto dto) {
        //Real regex put on finish
//        return Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", dto.getPassword());
        return Pattern.matches(".+", dto.getPassword());
    }

    private boolean isPasswordsMatch(UserRegistrationDto dto) {
        return dto.getPassword().equals(dto.getConfirmPassword());
    }

    private boolean isEmailValid(UserRegistrationDto dto) {
    //Real regex put on finish
    //return Pattern.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", dto.getEmail());
        return Pattern.matches(".+", dto.getEmail());
    }


}
