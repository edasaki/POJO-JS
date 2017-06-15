package com.edasaki.tests.detection;

import com.edasaki.pojojs.main.TSOutputBuilder;
import com.edasaki.pojojs.main.pojojs;
import com.edasaki.tests.depends.AType;
import com.edasaki.tests.depends.BType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class AnnotationFindingTests {

    private Set<Class<?>> toSet(Class<?>... classes) {
        Set<Class<?>> set = new HashSet<>();
        for (Class<?> c : classes) {
            set.add(c);
        }
        return set;
    }

    @Test
    public void testAType() {
        TSOutputBuilder builder = pojojs.build(toSet(AType.class));
    }

}
