package edu.personal.grailsfm.artistservice.util.validator;

import edu.personal.grailsfm.artistservice.util.validator.annotation.ContactNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements ConstraintValidator<ContactNumber, String> {
    @Override
    public void initialize(ContactNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }
        return value.matches("^[0-9]{10}$");
    }
}
