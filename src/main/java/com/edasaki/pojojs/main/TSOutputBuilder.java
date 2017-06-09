package com.edasaki.pojojs.main;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * A builder that represents a set of TypeScript interfaces.
 */
public class TSOutputBuilder {

    private Map<String, TreeMap<String, JSProperty.JSType>> interfaces;
    private String curr = null;

    /**
     * Create a new empty TSOutputBuilder.
     */
    public TSOutputBuilder() {
        this.interfaces = new LinkedHashMap<>();
    }

    /**
     * Add a field to the current interface of this builder.
     *
     * @param name the name of the field
     * @param type the JSType it should have
     * @return this
     */
    public TSOutputBuilder with(String name, JSProperty.JSType type) {
        if (curr == null) {
            throw new IllegalArgumentException("Must initialize type before calling with()");
        }
        this.interfaces.get(curr).put(name, type);
        return this;
    }

    /**
     * Add a new interface type to the builder and switch to it.
     *
     * @param typeName the type to add to the builder - will be used as an interface name
     */
    public void withType(String typeName) {
        curr = typeName;
        if (!interfaces.containsKey(curr)) {
            interfaces.put(curr, new TreeMap<>());
        }
    }

    /**
     * @return the typescript interface composed by this builder
     */
    public String getOutput() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, TreeMap<String, JSProperty.JSType>> type : interfaces.entrySet()) {
            sb.append('\n');
            sb.append("interface ");
            sb.append(type.getKey());
            sb.append(' ');
            sb.append('{');
            sb.append('\n');
            for (Map.Entry<String, JSProperty.JSType> entry : type.getValue().entrySet()) {
                sb.append("    ");
                sb.append(entry.getKey());
                sb.append(':');
                sb.append(' ');
                sb.append(entry.getValue().toString());
                sb.append(',');
                sb.append('\n');
            }
            sb.append('}');
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return interfaces.toString();
    }
}
