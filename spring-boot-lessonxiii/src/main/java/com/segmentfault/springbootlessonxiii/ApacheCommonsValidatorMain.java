package com.segmentfault.springbootlessonxiii;

import org.apache.commons.validator.routines.IntegerValidator;

import java.util.Locale;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-27 19:55
 **/
public class ApacheCommonsValidatorMain {

    public static void main(String[] args) {
        IntegerValidator validator = new IntegerValidator();
        //校验
        Integer value = validator.validate("10");
        //通过：显示具体的值
        System.out.println(value);
        //不通过：显示null
        value = validator.validate("A");

        System.out.println(value);

        //格式化
        System.out.println(validator.format(10000000, Locale.ENGLISH));

    }
}
