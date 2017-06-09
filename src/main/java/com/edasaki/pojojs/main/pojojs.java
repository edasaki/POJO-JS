package com.edasaki.pojojs.main;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.Field;
import java.util.Set;

@SuppressWarnings("SpellCheckingInspection")
public class pojojs {

    public static TSOutputBuilder build(Set<Class<?>> annotated) {
        TSOutputBuilder builder = new TSOutputBuilder();
        for (Class<?> c : annotated) {
            boolean init = false;
            for (Field f : c.getDeclaredFields()) {
                if (!f.isAnnotationPresent(JSProperty.class))
                    continue;
                if (!init) {
                    builder.withType(c.getSimpleName());
                    init = true;
                }
                JSProperty.JSType type = f.getAnnotation(JSProperty.class).value();
                builder.with(f.getName(), type);
            }
        }
        return builder;
    }

    public static Set<Class<?>> getClasses(String packageName) {
        Reflections reflections = new Reflections(packageName, new TypeAnnotationsScanner(), new SubTypesScanner());
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(JSObject.class);
        return annotated;
    }

    public static void process(String packageName) {
        TSOutputBuilder builder = build(getClasses(packageName));
        String res = builder.getOutput();
        System.out.println(res);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{"com.edasaki"};
        }
        for (String s : args) {
            process(s);
        }
    }
}
