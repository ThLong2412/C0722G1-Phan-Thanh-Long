package com.codegym.demo.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FacilityDto implements Validator {

    private Long id;
    private String name;
    private String area;
    private int maxPeople;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
