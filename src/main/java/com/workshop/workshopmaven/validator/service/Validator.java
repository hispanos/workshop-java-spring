package com.workshop.workshopmaven.validator.service;

public abstract class Validator<T> {
    public abstract boolean validateRow(T object);
    public abstract String getType();

}
