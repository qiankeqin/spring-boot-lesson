package com.segmentfault.springbootlessonxiii.validator;


import com.segmentfault.springbootlessonxiii.domain.Person;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @see com.segmentfault.springbootlessonxiii.domain.Person
 * @see PersonValidator
 * @create: 2018-12-27 20:14
 **/
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = Person.class.cast(target);
        String name = person.getName();
        //具体的验证逻辑
        if(!StringUtils.hasLength(name)){
            errors.reject("person.name.not.null","人的名字不能为空");
        }
    }
}
