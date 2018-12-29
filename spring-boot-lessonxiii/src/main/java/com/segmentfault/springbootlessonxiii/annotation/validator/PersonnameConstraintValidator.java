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

    private String prefix;

    @Override
    public void initialize(PersonName personName) {
        this.prefix = personName.prefix();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        if(name.startsWith(prefix)){
            return true;
        }
        constraintValidatorContext.disableDefaultConstraintViolation();
        ConstraintValidatorContext.ConstraintViolationBuilder builder
                = constraintValidatorContext.buildConstraintViolationWithTemplate("人的姓名必须以\"" + prefix + "\"开头！");
        builder.addConstraintViolation();//激活

        return false;
    }
}
