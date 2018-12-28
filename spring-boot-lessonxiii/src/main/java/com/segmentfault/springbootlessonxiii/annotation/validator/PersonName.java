package com.segmentfault.springbootlessonxiii.annotation.validator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { PersonnameConstraintValidator.class })
public @interface PersonName {

}
