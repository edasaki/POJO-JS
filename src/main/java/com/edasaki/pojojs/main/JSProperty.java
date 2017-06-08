package com.edasaki.pojojs.main;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JSProperty {
    JSType value();

    enum JSType {
        STRING("string"),
        NUMBER("number");
        private final String name;

        JSType(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
