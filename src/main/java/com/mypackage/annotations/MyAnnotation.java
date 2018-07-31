package com.mypackage.annotations;

import org.springframework.stereotype.Component;

@Component
public @interface MyAnnotation {
    // default String someValue(){};
    String value() default "";
}
