package zeroXessApp.JavaFX;
import org.junit.Assert;
import org.junit.Test;

import javax.print.Doc;

import static org.junit.Assert.*;

public class DoctorControllerTest {
    DoctorController doctorController = new DoctorController();

    @Test
    public void hasAccesTest() {
        /*
         * Hier testen we of inderdaad alleen dokters en admins toegang hebben tot de dokterfunctionaliteit.
         */
        LoginController.setCurrentUser("Testacc");
        boolean actual = doctorController.hasAcces();
        Assert.assertFalse(actual);
        LoginController.setCurrentUser("Moderator");
        actual = doctorController.hasAcces();
        Assert.assertTrue(actual);
        LoginController.setCurrentUser("Carl");
        actual = doctorController.hasAcces();
        Assert.assertTrue(actual);
    }
}