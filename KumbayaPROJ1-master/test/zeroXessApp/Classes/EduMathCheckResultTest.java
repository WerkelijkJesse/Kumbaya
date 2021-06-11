package zeroXessApp.Classes;
import org.junit.Assert;
import org.junit.Test;

public class EduMathCheckResultTest {
    @Test
    public void checkTest() {
        /*
         * Pairwise testing: Alle combinaties van 3 parameters zijn getest (getal1, getal2, Calculation). De laatste parameter is het resultaat
         * die de gebruiker in moet vullen, die vullen wij nu voor hem in.
         */
        String actual = EduMathCheckResult.check(10, 5, new PlusCalculation(), "15");
        String actual0 = EduMathCheckResult.check(20, 10, new PlusCalculation(), "30");
        String actual1 = EduMathCheckResult.check(10, 10, new MinusCalculation(), "0");
        String actual2 = EduMathCheckResult.check(20, 5, new MinusCalculation(), "15");
        String actual3 = EduMathCheckResult.check(10, 5, new DivideCalculation(), "2");
        String actual4 = EduMathCheckResult.check(20, 10, new DivideCalculation(), "2");
        String actual5 = EduMathCheckResult.check(10, 10, new MultiplyCalculation(), "100");
        String actual6 = EduMathCheckResult.check(20, 5, new MultiplyCalculation(), "100");

        Assert.assertEquals("Excellent!", actual);
        Assert.assertEquals("Excellent!", actual0);
        Assert.assertEquals("Excellent!", actual1);
        Assert.assertEquals("Excellent!", actual2);
        Assert.assertEquals("Excellent!", actual3);
        Assert.assertEquals("Excellent!", actual4);
        Assert.assertEquals("Excellent!", actual5);
        Assert.assertEquals("Excellent!", actual6);

    }

    @Test
    /*
     * Hieronder testen we nog een aantal keer waarbij het verwachtte resultaat incorrect is.
     */
    public void plusTest() {
        String actual = EduMathCheckResult.plus(10, 5, "20");
        String actual1 = EduMathCheckResult.plus(20, 5, "20");
        Assert.assertEquals("Incorrect!", actual);
        Assert.assertEquals("Incorrect!", actual1);
    }

    @Test
    public void minusTest() {
        String actual = EduMathCheckResult.minus(10, 5, "15");
        String actual1 = EduMathCheckResult.minus(20, 5, "25");
        Assert.assertEquals("Incorrect!", actual);
        Assert.assertEquals("Incorrect!", actual1);
    }

    @Test
    public void multiplyTest() {
        String actual = EduMathCheckResult.multiply(10, 5, "15");
        String actual1 = EduMathCheckResult.multiply(20, 5, "25");
        Assert.assertEquals("Incorrect!", actual);
        Assert.assertEquals("Incorrect!", actual1);
    }

    @Test
    public void divideTest() {
        String actual = EduMathCheckResult.minus(10, 5, "15");
        String actual1 = EduMathCheckResult.minus(20, 5, "25");
        Assert.assertEquals("Incorrect!", actual);
        Assert.assertEquals("Incorrect!", actual1);
    }
}