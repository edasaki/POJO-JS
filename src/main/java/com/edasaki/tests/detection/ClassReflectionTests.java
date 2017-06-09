package com.edasaki.tests.detection;

import com.edasaki.pojojs.main.pojojs;
import com.edasaki.tests.depends.AType;
import com.edasaki.tests.depends.BType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class ClassReflectionTests {

    private Set<Class<?>> classes;

    @Before
    public void init() {
        classes = pojojs.getJSObjectClasses("com.edasaki.tests.depends");
    }

    @Test
    public void testFindsAType() {
        Assert.assertTrue(classes.contains(AType.class));
    }

    @Test
    public void testFindsBType() {
        Assert.assertTrue(classes.contains(BType.class));
    }
}
