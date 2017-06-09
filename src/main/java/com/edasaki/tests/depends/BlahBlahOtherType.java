package com.edasaki.tests.depends;

import com.edasaki.pojojs.main.JSObject;
import com.edasaki.pojojs.main.JSProperty;

import static com.edasaki.pojojs.main.JSProperty.JSType;

@JSObject
public class BlahBlahOtherType {
    @JSProperty(JSType.NUMBER)
    public int testerino = 5;

    @JSProperty(JSType.NUMBER)
    public double testerino2 = 3.0;

    public BlahBlahOtherType() {

    }
}
