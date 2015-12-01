package com.github.kingready.library.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {
    @Override
    public void initialize(ZipCode constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.length() >= 4 && value.startsWith("4");
    }
}
