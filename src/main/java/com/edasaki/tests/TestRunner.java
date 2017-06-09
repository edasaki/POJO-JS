package com.edasaki.tests;


import com.edasaki.tests.detection.DetectionTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DetectionTests.class
})
public final class TestRunner {
}
