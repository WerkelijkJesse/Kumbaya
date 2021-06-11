package zeroXessApp.Classes;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivideCalculationTest {
    @Test
    public void calculationTest() {
        /*
         * Hier testen we voor de zekerheid of de methode bestand is tegen het delen door nul.
         */
        DivideCalculation divideCalculation = new DivideCalculation();
        int actual = divideCalculation.calculation(10, 0);
        Assert.assertEquals(0, actual);
        actual = divideCalculation.calculation(10, 5);
        Assert.assertEquals(2, actual);
    }
}