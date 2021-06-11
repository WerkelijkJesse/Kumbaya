package zeroXessApp.JavaFX;
import org.junit.Assert;
import org.junit.Test;
import zeroXessApp.ClassObjects.Animals;
import zeroXessApp.ClassObjects.Goat;
import zeroXessApp.ClassObjects.Pig;
import zeroXessApp.ClassObjects.Sheep;
import zeroXessApp.Classes.ArrayLists;

public class CattleViewControllerTest {
    CattleViewController cattleViewController = new CattleViewController();
    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    @Test
    public void testCattleListSize(){
        /*
         * Alleen vee dat de gebruiker zelf toevoegd, mag in de tabel terechtkomen.
         */
        LoginController.setCurrentUser("Moderator");
        int actual = cattleViewController.cattleListSize();
        Assert.assertEquals(0, actual);

        Pig Bella = new Pig("Pig", "Bella", "Female", "Pink", 80, "Moderator");
        Sheep Stacy = new Sheep("Sheep", "Stacy", "Female", "Brown", 72, "Moderator");
        arrays.addCattle(Bella); arrays.addCattle(Stacy);
        actual = cattleViewController.cattleListSize();
        Assert.assertEquals(2, actual);

        Goat goat1 = new Goat("Goat", "Goat1", "Male", "White", 102, "Jake");
        Goat goat2 = new Goat("Goat", "Goat1", "Male", "White", 102, "Will");
        arrays.addCattle(goat1); arrays.addCattle(goat2);
        actual = cattleViewController.cattleListSize();
        Assert.assertEquals(2, actual);

    }
}
