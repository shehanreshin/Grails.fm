package edu.personal.grailsfm.artistservice.util.validator.annotation;

import edu.personal.grailsfm.artistservice.util.validator.ContactNumberValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ContactNumberValidator.class)
public @interface ContactNumber {
}
