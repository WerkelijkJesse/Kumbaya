package zeroXessApp.Classes;
import org.junit.Assert;
import org.junit.Test;
import zeroXessApp.ClassObjects.Accounts;
import zeroXessApp.ClassObjects.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CheckerTest {

    Checker check = new Checker();
    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();


    @Test
    public void checkAppointmentTest() {
        /*
         * Hier testen we of de methode goed werkt en hij inderdaad zorgt dat er geen dubbele afspraken gemaakt kunnen worden.
         */
        Appointment appointment = new Appointment("Carl", "test", "Moderator", "", LocalDate.of(2020, 7, 20), LocalTime.of(12, 0));
        Appointment appointment2 = new Appointment("Matt", "test", "Moderator", "", LocalDate.of(2020, 7, 20), LocalTime.of(12, 0));
        arrays.addAppointment(appointment); arrays.addAppointment(appointment2);

        boolean actual = Checker.checkAppointment("Carl", LocalDate.of(2020, 7, 20), LocalTime.of(12, 0));
        Assert.assertFalse(actual);
        actual = Checker.checkAppointment("Matt", LocalDate.of(2020, 7, 20), LocalTime.of(12, 0));
        Assert.assertFalse(actual);
        actual = Checker.checkAppointment("Tracey", LocalDate.of(2020, 7, 20), LocalTime.of(12, 0));
        Assert.assertTrue(actual);
        actual = Checker.checkAppointment("Donald", LocalDate.of(2020, 7, 20), LocalTime.of(12, 0));
        Assert.assertTrue(actual);
    }

    @Test
    public void writeAnswerCompareTest() {
        /*
         * Hier testen we of de methode writeAnswerCompare op de juiste wijze controleert of de gebruiker een zin correct heeft over getypt.
         */
        boolean actual1 = Checker.writeAnswerCompare("Vraag", "Antwoord", true);
        boolean actual2 = Checker.writeAnswerCompare("Vraag", "Antwoord", false);
        boolean actual3 = Checker.writeAnswerCompare("vraag", "vraag", false);
        boolean actual4 = Checker.writeAnswerCompare("Vraag", "Vraag", true);
        boolean actual5 = Checker.writeAnswerCompare("Vraag", "vraag", true);
        boolean actual6 = Checker.writeAnswerCompare("Vraag", "vraag", false);
        Assert.assertFalse(actual1);
        Assert.assertFalse(actual2);
        Assert.assertFalse(actual3);
        Assert.assertTrue(actual4);
        Assert.assertFalse(actual5);
        Assert.assertFalse(actual6);
    }

    @Test
    public void checkAgeTest() {
        boolean actual;
        /*
         * Equivalence classes + boundary value testing: beide uitkomsten van de methode zijn getest (equivalence classes)
         * en de randwaarden zijn getest (boundary value analysis).
         */
        actual = Checker.checkAge(2017);
        assertFalse(actual);
        actual = Checker.checkAge(2016);
        assertFalse(actual);
        actual = Checker.checkAge(2015);
        assertTrue(actual);
    }

    @Test
    public void checkPriceTest() {
        int actual;
        /*
         * Equivalence classes + boundary value testing: alle drie de uitkomsten van de methode zijn getest (equivalence classes)
         * en de randwaarden zijn getest (boundary value analysis).
         */
         actual = Checker.checkPrice(2016);
         Assert.assertEquals(1, actual);
         actual = Checker.checkPrice(2015);
         Assert.assertEquals(1, actual);
         actual = Checker.checkPrice(2010);
         Assert.assertEquals(5, actual);
         actual = Checker.checkPrice(2009);
         Assert.assertEquals(5, actual);
         actual = Checker.checkPrice(2000);
         Assert.assertEquals(10, actual);
         actual = Checker.checkPrice(1999);
         Assert.assertEquals(10, actual);
    }

    @Test
    public void checkUsernameTest() {
        /*
         * Geen specifieke testvorm, maar een nuttige test. Het is belangrijk te weten of deze methode werkt.
         */
        arrays.addAccount(new Accounts("TVS23", 1960, "Moderator",
                "The Netherlands", "123", "4567", "0653129198"));
        Assert.assertFalse(Checker.checkUsername(arrays.getAccountList(), "Moderator"));
        Assert.assertTrue(Checker.checkUsername(arrays.getAccountList(), "Joe"));
    }

    @Test
    public void checkLoginTest() {
        arrays.addAccount(new Accounts("TVS23", 1960, "Moderator",
                "The Netherlands", "123", "4567", "0653129198"));
        /*
         * Condition coverage: elke uitkomst van elke conditie is één keer getest.
         */

        Assert.assertFalse(Checker.checkLogin(arrays.getAccountList(), "Moderator", "124"));
        Assert.assertFalse(Checker.checkLogin(arrays.getAccountList(), "Moderator2", "123"));

        /*
         * Decision coverage: elke uitkomst van de beslissing is één keer getest.
         */
        Assert.assertTrue(Checker.checkLogin(arrays.getAccountList(), "Moderator", "123"));
        Assert.assertFalse(Checker.checkLogin(arrays.getAccountList(), "Moderator2", "124"));
    }

    @Test
    public void checkForgotTest() {
        arrays.addAccount(new Accounts("TVS23", 1960, "Moderator",
                "The Netherlands", "123", "4567", "0653129198"));

        /*
         * Modified condition / decision coverage. Elke parameter van de check-methode bepaalt minstens een keer de uitkomst.
         * Ook is er een geval waarbij alle gegevens kloppen (een neutrale waarde hebben).
         * Het is belangrijk om te testen of deze methode goed werkt, vandaar er in het volgende stukje code ook gebruik is gemaakt van
         * pairwise testing.
         */
        Assert.assertTrue(check.checkForgot(arrays.getAccountList(), "Moderator", 1960, "4567"));
        Assert.assertFalse(check.checkForgot(arrays.getAccountList(), "Moderator2", 1960, "4567"));
        Assert.assertFalse(check.checkForgot(arrays.getAccountList(), "Moderator", 1961, "4567"));
        Assert.assertFalse(check.checkForgot(arrays.getAccountList(), "Moderator", 1960, "4568"));

        /*
         * Pairwise testing: Alle combinaties van 2 parameters zijn getest.
         */
        Assert.assertTrue(check.checkForgot(arrays.getAccountList(), "Moderator", 1960, "4567"));
        Assert.assertFalse(check.checkForgot(arrays.getAccountList(), "Moderator", 1961, "5678"));
        Assert.assertFalse(check.checkForgot(arrays.getAccountList(), "Moderator2", 1960, "5678"));
        Assert.assertFalse(check.checkForgot(arrays.getAccountList(), "Moderator2", 1961, "4567"));
    }
}
