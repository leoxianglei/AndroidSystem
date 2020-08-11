package com.enjoy.zero.libzhujie01.annotationvip;

import java.lang.annotation.Repeatable;


@interface Persons{
    Person[] value();
}

@Repeatable(Persons.class)
@interface Person{
    String role() default "";//八种基本的类型 Class 注解
//    Lance test();
}

@Person(role = "第一骚")
@Person(role = "闷骚")
@Person(role = "温文雅尔")
public class Human {

    private String name ="Av";
}
