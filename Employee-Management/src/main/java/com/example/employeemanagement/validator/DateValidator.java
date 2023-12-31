package com.example.employeemanagement.validator;

import com.example.employeemanagement.constant.CommonConstant;
import com.example.employeemanagement.validator.annotation.ValidDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator implements ConstraintValidator<ValidDate, String> {

    @Override
    public void initialize(ValidDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String target, ConstraintValidatorContext constraintValidatorContext) {
        if (target == null) return true;

        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        if (!target.matches(regex)) {
            return false;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(CommonConstant.PATTERN_DATE);
        dateFormat.setLenient(false);

        try {
            Date date = dateFormat.parse(target);

            if (!target.equals(dateFormat.format(date))) {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }

        return true;
    }
}
