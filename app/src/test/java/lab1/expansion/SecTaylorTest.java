package lab1.expansion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecTaylorTest {
    @Test
    public void checkCalculator() {
        assertTrue("Check calculator failed", SecTaylor.checkCalculator(0, 5));
    }
}
