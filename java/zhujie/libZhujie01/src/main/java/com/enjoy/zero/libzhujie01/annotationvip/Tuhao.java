package com.enjoy.zero.libzhujie01.annotationvip;

import com.enjoy.zero.libzhujie01.InheritedTest;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Tuhao {

    String value() default "土豪";
}
