package com.enjoy.zero.libzhujie01.annotationvip;


public class ChildLance extends Lance {
    public ChildLance(String name) {
        super(name);
    }

    public static void main(String... args) {
        //TODO:
        //获取child类的class对象
        Class<ChildLance> childInheritedClass = ChildLance.class;

        if (childInheritedClass.isAnnotationPresent(Tuhao.class)) {//判断InheritedTest类是不是Child的父注解类
            Tuhao inheritedTest = childInheritedClass.getAnnotation(Tuhao.class);
            String value = inheritedTest.value();
            System.out.println("classTest value: " + value);
        }
    }
}
