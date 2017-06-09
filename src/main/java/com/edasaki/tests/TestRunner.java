package com.edasaki.tests;


import com.edasaki.tests.detection.AnnotationFindingTests;
import com.edasaki.tests.detection.ClassReflectionTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ClassReflectionTests.class,
        AnnotationFindingTests.class
})
public final class TestRunner {
}
