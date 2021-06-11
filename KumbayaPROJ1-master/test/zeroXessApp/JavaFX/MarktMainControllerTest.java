package zeroXessApp.JavaFX;
import org.junit.Assert;
import org.junit.Test;
import zeroXessApp.ClassObjects.Animals;
import zeroXessApp.ClassObjects.Goat;
import zeroXessApp.ClassObjects.Pig;
import zeroXessApp.ClassObjects.Sheep;
import zeroXessApp.Classes.ArrayLists;

public class MarktMainControllerTest {
    MarktMainController marktMainController = new MarktMainController();
    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    @Test
    public void testMarketCattleListSize(){
        /*
         * Al het vee dat door alle gebruikers aan de marktplaats toegevoegd word, moet in de tabel terecht komen.
         */
        LoginController.setCurrentUser("Moderator");
        int actual = marktMainController.marketCattleListSize();
        Assert.assertEquals(0, actual);

        Pig Bella = new Pig("Pig", "Bella", "Female", "Pink", 80, "Moderator");
        Sheep Stacy = new Sheep("Sheep", "Stacy", "Female", "Brown", 72, "Moderator");
        arrays.addToMarket(Bella); arrays.addToMarket(Stacy);
        actual = marktMainController.marketCattleListSize();
        Assert.assertEquals(2, actual);

        Goat goat1 = new Goat("Goat", "Goat1", "Male", "White", 102, "Jake");
        Goat goat2 = new Goat("Goat", "Goat1", "Male", "White", 102, "Will");
        arrays.addToMarket(goat1); arrays.addToMarket(goat2);
        actual = marktMainController.marketCattleListSize();
        Assert.assertEquals(4, actual);

    }
}
