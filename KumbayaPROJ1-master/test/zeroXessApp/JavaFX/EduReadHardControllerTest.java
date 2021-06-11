package zeroXessApp.JavaFX;
import org.junit.Test;
import zeroXessApp.Classes.EduReadEasy;
import zeroXessApp.Classes.EduReadHard;
import zeroXessApp.Classes.EduReadMedium;
import static org.junit.Assert.*;

public class EduReadHardControllerTest {

    @Test
    public void checkAnswerHardTest() {
        /*
         * Testen of het programma het gegeven antwoord juist controleert. De gebruiker leest een vraag en moet vervolgens een vraag beantwoorden
         * door op een knop te drukken. Vervolgens controleert het programma het antwoord.
         */
        EduReadHard test = new EduReadHard("Question", "one", "two", "three", "four", "one");
        EduReadHard testtwo = new EduReadHard("Question", "one", "two", "three", "four", "two");
        EduReadHard testthree = new EduReadHard("Question", "one", "two", "three", "four", "three");
        EduReadHard testfour = new EduReadHard("Question", "one", "two", "three", "four", "four");

        assertEquals(test.getSpot1(), test.getAnswer());
        assertNotEquals(testtwo.getSpot1(), testtwo.getAnswer());
        assertNotEquals(test.getSpot2(), test.getAnswer());
        assertEquals(testtwo.getSpot2(), testtwo.getAnswer());
        assertNotEquals(test.getSpot3(), test.getAnswer());
        assertNotEquals(testtwo.getSpot3(), testtwo.getAnswer());
        assertNotEquals(test.getSpot4(), test.getAnswer());
        assertNotEquals(test.getSpot4(), test.getAnswer());
        assertNotEquals(testthree.getSpot1(), testthree.getAnswer());
        assertNotEquals(testfour.getSpot1(), testfour.getAnswer());
        assertNotEquals(testthree.getSpot2(), testthree.getAnswer());
        assertNotEquals(testfour.getSpot2(), testfour.getAnswer());
        assertEquals(testthree.getSpot3(), testthree.getAnswer());
        assertNotEquals(testfour.getSpot3(), testfour.getAnswer());
        assertNotEquals(testthree.getSpot4(), testthree.getAnswer());
        assertEquals(testfour.getSpot4(), testfour.getAnswer());
    }
}