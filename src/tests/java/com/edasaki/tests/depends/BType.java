package com.edasaki.tests.depends;

import com.edasaki.pojojs.main.JSObject;
import com.edasaki.pojojs.main.JSProperty;

import static com.edasaki.pojojs.main.JSProperty.*;

@JSObject
public class BType {
    @JSProperty(JSType.STRING)
    public String blah = "hi";

    @JSProperty(JSType.NUMBER)
    public int someVal = 5;

    @JSProperty(JSType.NUMBER)
    public double someDouble = 3.0;

    public BType() {

    }
}
