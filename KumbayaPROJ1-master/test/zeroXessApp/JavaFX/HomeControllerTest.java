package zeroXessApp.JavaFX;
import org.junit.Assert;
import zeroXessApp.ClassObjects.Appointment;
import zeroXessApp.Classes.ArrayLists;

import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.Test;

public class HomeControllerTest{

    HomeController homeController = new HomeController();
    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    @Test
    public void testHomeAppointments() {
        /*
         * Alleen afspraken van de gebruiker, die in de toekomst plaatsvinden, worden toegevoegd aan de observable list (die zichzelf automatisch bijwerkt) en dit verschijnt weer in de tabel.
         * Zodra we een nieuwe afspraak maken, wordt die automatisch aan de observable list toegevoegd.
         */
        LoginController.setCurrentUser("Moderator");

        int actual = homeController.firstAppointmentsListSize();
        Assert.assertEquals(0, actual);

        Appointment appointment0 = new Appointment("Tracey", "TVS24", "Moderator", "Test", LocalDate.of(2021, 10, 12), LocalTime.of(9, 30));
        Appointment appointment = new Appointment("Donald", "TVS24", "Moderator", "Test", LocalDate.of(2021, 9, 9), LocalTime.of(9, 30));
        arrays.addAppointment(appointment0); arrays.addAppointment(appointment);
        actual = homeController.firstAppointmentsListSize();
        Assert.assertEquals(2, actual);

        Appointment appointment1 = new Appointment("Carl", "HHS23", "Moderator", "Test2", LocalDate.of(2020, 4, 9), LocalTime.of(14, 0));
        Appointment appointment2 = new Appointment("Donald", "TVS24", "Moderator", "Test", LocalDate.of(2020, 3, 9), LocalTime.of(9, 30));
        arrays.addAppointment(appointment1); arrays.addAppointment(appointment2);
        actual = homeController.firstAppointmentsListSize();
        Assert.assertEquals(2, actual);

        Appointment appointment3 = new Appointment("Tracey", "TVS24", "Klaas", "Test", LocalDate.of(2021, 10, 12), LocalTime.of(9, 30));
        Appointment appointment4 = new Appointment("Carl", "HHS23", "Joop", "Test2", LocalDate.of(2022, 2, 9), LocalTime.of(14, 0));
        arrays.addAppointment(appointment3); arrays.addAppointment(appointment4);
        actual = homeController.firstAppointmentsListSize();
        Assert.assertEquals(2, actual);
    }
}
