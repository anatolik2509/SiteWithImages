package ru.itis.antonov.images.site.validators;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EqualsPasswordValidator implements ConstraintValidator<EqualsPasswords, Object> {

    private String passwordField;
    private String passwordRepeatField;


    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object password = new BeanWrapperImpl(o).getPropertyValue(passwordField);
        Object passwordRepeat = new BeanWrapperImpl(o).getPropertyValue(passwordRepeatField);

        return password != null && password.equals(passwordRepeat);

    }

    @Override
    public void initialize(EqualsPasswords constraintAnnotation) {
        passwordField = constraintAnnotation.password();
        passwordRepeatField = constraintAnnotation.passwordRepeat();
    }
}
