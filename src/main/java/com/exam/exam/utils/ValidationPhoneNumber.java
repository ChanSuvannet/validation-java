package com.exam.exam.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidationPhoneNumberClass.class)
public @interface ValidationPhoneNumber {
    String message() default "Invalid phone number format for Cambodia";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
