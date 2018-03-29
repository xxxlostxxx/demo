package com.anno;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Vaild {
    boolean validate() default true;

}
