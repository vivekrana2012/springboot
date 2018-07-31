package com.mypackage.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.ArrayList;

public class CourseValidator implements ConstraintValidator<CourseConstraint, String> {

    static ArrayList<String> courses = new ArrayList<>();

    static {
        courses.add("computer science");
        courses.add("sciences");
        courses.add("physics");
        courses.add("IT");
        courses.add("doctor");
    }

    @Override
    public void initialize(CourseConstraint courseConstraint) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return courses.contains(s);
    }
}
