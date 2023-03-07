package lab1.expansion;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class SecTaylorTest {
    @Test
    @Parameters({
            "0.1, 0.01",
            "-0.12, 0.001",
            "0.314, 0.0001",
            "0.414, 0.0001",
            "0, 0.00001",
    })
    public void sec(double x, double delta) {
        double computedSec = SecTaylor.compute(x);
        double realSec = 1 / Math.cos(x);
        assertEquals(computedSec, realSec, delta);
    }
}
