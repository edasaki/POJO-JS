package com.edasaki.pojojs.main;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JSObject {
    /**
     * @return the filename to getOutput
     */
    String value() default "";
}
