package zeroXessApp.JavaFX;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EduWriteWordsControllerTest {
    EduWriteWordsController edu = new EduWriteWordsController();

    /* In deze test wordt een hypothetische quiz gemaakt. Elke keer dat correctCheck() aangeroepen wordt is er een goed antwoord gegeven en
     * gaat de gebruiker 1 punt omhoog. Bij 10 punten is de gebruiker klaar en dit wordt aangegeven door de opgegeven tekst. Alle punten boven de 10 geven dezelfde uitslag.
     * Als de gebruiker het fout heeft wordt mistakeCheck() aangeroepen, een gebruiker heeft 3 levens en bij elke aanroeping gaat er 1 af.
     * Als de gebruiker 0 levens heeft krijgt hij het bericht dat het hem niet gelukt is. Als het aantal levens onder de 0 komt zegt hij hetzelfde.
     * de methode getCurrentScore geeft aan wat de huidige score is, dit is handig om midden in de quiz te checken of de punten goed bijgehouden worden.
     * De eerste testmethode is een voorbeeld waar de gebruiker niet alle dieren kan raden en uiteindelijk de quiz niet haalt.
     */
    @Test
    public void testQuizFail(){
        Assert.assertEquals("Correct! You have 1 out of 10 correct answers!", edu.correctCheck());      // 1 goed
        Assert.assertEquals("Wrong! You have 2 tries left.", edu.mistakeCheck());                       // 1 fout
        Assert.assertEquals(1, edu.getCurrentScore());
        Assert.assertNotEquals(2, edu.getCurrentScore());
        Assert.assertNotEquals("Correct! You have 1 out of 10 correct answers!", edu.correctCheck()); // 2 goed
        Assert.assertEquals("Correct! You have 3 out of 10 correct answers!", edu.correctCheck());      // 3 goed
        edu.correctCheck();                                                                                     // 4 goed
        edu.correctCheck();                                                                                     // 5 goed
        Assert.assertEquals("Correct! You have 6 out of 10 correct answers!", edu.correctCheck());      // 6 goed
        edu.mistakeCheck();                                                                                     // 2 fout
        edu.mistakeCheck();                                                                                     // 3 fout (gefaald)
        Assert.assertEquals("You failed! Try again?", edu.mistakeCheck());                              // 4 fout (onmogelijk, maar geeft dezelfde uitslag als 3 fout)
    }

    /*
     * Deze tweede testmethode is een voorbeeld waar de gebruiker alle dieren weet te raden en hij de quiz wel haalt.
     */
    @Test
    public void testQuizWin(){
        Assert.assertEquals("Correct! You have 1 out of 10 correct answers!", edu.correctCheck());      // 1 goed
        Assert.assertEquals("Wrong! You have 2 tries left.", edu.mistakeCheck());                       // 1 fout
        Assert.assertEquals(1, edu.getCurrentScore());
        Assert.assertNotEquals(2, edu.getCurrentScore());
        Assert.assertNotEquals("Correct! You have 1 out of 10 correct answers!", edu.correctCheck()); // 2 goed
        Assert.assertEquals("Correct! You have 3 out of 10 correct answers!", edu.correctCheck());      // 3 goed
        edu.correctCheck();                                                                                     // 4 goed
        edu.correctCheck();                                                                                     // 5 goed
        Assert.assertEquals("Correct! You have 6 out of 10 correct answers!", edu.correctCheck());      // 6 goed
        edu.mistakeCheck();                                                                                     // 2 fout
        edu.correctCheck();                                                                                     // 7 goed
        edu.correctCheck();                                                                                     // 8 goed
        edu.correctCheck();                                                                                     // 9 goed
        Assert.assertEquals("You did it! You remembered all of the animals!!", edu.correctCheck());        // 10 goed en klaar
        }
    }


