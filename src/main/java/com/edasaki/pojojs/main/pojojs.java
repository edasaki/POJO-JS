package com.edasaki.pojojs.main;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.Field;
import java.util.Set;

@SuppressWarnings("SpellCheckingInspection")
public class pojojs {

    /**
     * Create a builder out of all annotated @JSProperty fields
     * in the provided classes.
     *
     * @param annotated the set of classes to check for @JSProperty fields
     * @return a builder built from the provided properties and classes
     */
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

    /**
     * Get all classes annotated with @JSObject in the given package.
     *
     * @param packageName the package to look in
     * @return a set of classes annotated with @JSObject found in the given package
     */
    public static Set<Class<?>> getJSObjectClasses(String packageName) {
        Reflections reflections = new Reflections(packageName, new TypeAnnotationsScanner(), new SubTypesScanner());
        return reflections.getTypesAnnotatedWith(JSObject.class);
    }

    /**
     * Fully process a given package.
     *
     * @param packageName the package to process
     */
    public static void process(String packageName) {
        TSOutputBuilder builder = build(getJSObjectClasses(packageName));
        String res = builder.getOutput();
        System.out.println(res);
    }

    /**
     * For calling from the command line.
     * Processes all provided packages separately.
     * If no packages are provided, then processes
     * com.edasaki by default.
     *
     * @param args the packages to process
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{"com.edasaki"};
        }
        for (String s : args) {
            process(s);
        }
    }
}
