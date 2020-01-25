package com.blogged.pet.validator;

public interface Validator<T> {

    boolean isValid(T dto);
}
