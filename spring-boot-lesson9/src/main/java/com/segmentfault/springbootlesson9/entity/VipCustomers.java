package com.segmentfault.springbootlesson9.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-03 13:13
 **/
@Inheritance
@Entity
public class VipCustomers extends Customer{

}
