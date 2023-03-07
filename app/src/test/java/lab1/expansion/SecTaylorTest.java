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
            "0, 0.01",
            "1, 0.01",
            "3.14, 0.01",
            "42, 0.01",
    })
    public void sec(double x, double delta) {
        double computedSec = SecTaylor.compute(0);
        double realSec = 1 / Math.cos(0);
        assertEquals(computedSec, realSec, delta);
    }
}
