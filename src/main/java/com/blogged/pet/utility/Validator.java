package com.blogged.pet.utility;

public interface Validator<T> {

    boolean isAccountDtoValid(T dto);
}
