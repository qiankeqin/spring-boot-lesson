package com.segmentfault.springbootlessonxiii.annotation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * {@link PersonName}
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-28 13:24
 **/
public class PersonnameConstraintValidator implements ConstraintValidator<PersonName,String>{
    @Override
    public void initialize(PersonName personName) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
