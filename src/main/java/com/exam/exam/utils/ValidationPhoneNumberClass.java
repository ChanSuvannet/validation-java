package com.exam.exam.utils;

import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidationPhoneNumberClass implements ConstraintValidator<ValidationPhoneNumber, String> {

    // Pattern for Cambodian phone numbers (mobile and landline)
    // Mobile numbers: 012-345-678, 089-123-456, etc.
    // Landline numbers: 023-123-456, etc.
    private static final String PHONE_PATTERN = "^(0(12|89|10|11|17|18|99))\\d{6}$|^(0(23|24|26|27|28|29))\\d{6}$";

    @Override
    public void initialize(ValidationPhoneNumber constraintAnnotation) {
        // Initialization logic (if needed)
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // You can modify this if you want null to be considered invalid.
        }

        // Check if the phone number matches the pattern for Cambodia
        return Pattern.matches(PHONE_PATTERN, value);
    }
}
