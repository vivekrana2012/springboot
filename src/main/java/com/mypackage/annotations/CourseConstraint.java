package com.mypackage.annotations;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Component
@Documented
@Constraint(validatedBy = CourseValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseConstraint {
    String message() default "Invalid Course Name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
