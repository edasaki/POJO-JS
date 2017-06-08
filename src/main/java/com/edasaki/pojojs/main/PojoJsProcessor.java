package com.edasaki.pojojs.main;

import com.edasaki.tests.SomeObject;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.Field;
import java.util.Set;

public class PojoJsProcessor {
    public static void process(String packageName, Object o) {
        Reflections reflections = new Reflections(packageName, new TypeAnnotationsScanner(), new SubTypesScanner());
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(JSObject.class);
        for (Class<?> c : annotated) {
            JSOutputBuilder builder = new JSOutputBuilder();
            for (Field f : c.getDeclaredFields()) {
                if (!f.isAnnotationPresent(JSProperty.class))
                    continue;
                JSProperty.JSType type = f.getAnnotation(JSProperty.class).value();
                builder.with(f.getName(), type);
            }
            System.out.println(builder.output(c.getSimpleName()));
            JSObject obj = c.getAnnotation(JSObject.class);
            String fileName = obj.value().length() == 0 ? c.getSimpleName() : obj.value();
            System.out.println(fileName + ".ts");
        }
    }

    public static void main(String[] args) {
        process("com.edasaki", new SomeObject());
    }
}
