package com.github.kingready.library.model.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { ZipCodeValidator.class })
public @interface ZipCode {
    String message() default "Attributwert ist keine Postleitzahl!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
