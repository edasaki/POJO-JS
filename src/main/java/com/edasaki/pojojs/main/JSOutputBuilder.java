package com.edasaki.pojojs.main;

import java.util.Map;
import java.util.TreeMap;

public class JSOutputBuilder {

    private TreeMap<String, JSProperty.JSType> vals;

    public JSOutputBuilder() {
        this.vals = new TreeMap<>();
    }

    public JSOutputBuilder with(String name, JSProperty.JSType type) {
        this.vals.put(name, type);
        return this;
    }

    public String output(String interfaceName) {
        StringBuilder sb = new StringBuilder();
        sb.append("interface ");
        sb.append(interfaceName);
        sb.append(' ');
        sb.append('{');
        sb.append('\n');
        for (Map.Entry<String, JSProperty.JSType> entry : vals.entrySet()) {
            sb.append("    ");
            sb.append(entry.getKey());
            sb.append(':');
            sb.append(' ');
            sb.append(entry.getValue().toString());
            sb.append(',');
            sb.append('\n');
        }
        sb.append('}');
        return sb.toString();
    }

    @Override
    public String toString() {
        return vals.toString();
    }
}
