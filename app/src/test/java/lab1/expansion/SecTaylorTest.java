package lab1.expansion;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class SecTaylorTest {
    @Test
    public void checkCalculator() {
        assertTrue("Check calculator failed", SecTaylor.checkCalculator(0, 5));
    }
}
