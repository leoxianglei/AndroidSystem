package com.zero.lambdademo.stream;


import com.zero.lambdademo.lamdba.lamdba3.Person;

import java.util.Arrays;
import java.util.List;

public class Stream1 {

    List<Person> persons = Arrays.asList(
            new Person("CJK",19,90),
            new Person("BODUO",20,80),
            new Person("JZ",21,70),
            new Person("anglebabby",18,60),
            new Person("huangxiaoming",5,50),
            new Person("Deer",18,99)
    );

    //取出所有大于18岁人的姓名，按字典排序，并输出到控制台
    public  void test1() {
        persons.stream().filter(x->x.getAge()>=18).map(Person::getName).sorted().forEach(System.out::println);
    }
}
