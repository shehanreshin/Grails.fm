package edu.personal.grailsfm.artistservice.util.validator.annotation;

import edu.personal.grailsfm.artistservice.util.validator.PhoneNumberValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumber {
}
