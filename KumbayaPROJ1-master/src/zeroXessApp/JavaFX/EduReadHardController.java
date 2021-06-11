package zeroXessApp.JavaFX;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.Clock;

import java.net.URL;
import java.util.ResourceBundle;

public class EduReadHardController extends EduReadSuperController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public Label timeLabelHard;
    public Label questionLabelHard;
    public Button button1Hard;
    public Button button2Hard;
    public Button button3Hard;
    public Button button4Hard;
    public Label rightHard;
    public Label wrongHard;

    public void initialize(URL location, ResourceBundle resources) {
        Clock.initClockTime(timeLabelHard);
        question();
        getCurrent();
    }

    public int getCurrent() {
        int current = random.nextInt(arrays.getEduReadHardList().size());
        return current;
    }

    public void question() {
        button1Hard.setText(arrays.getEduReadHard(current).getSpot1());
        button2Hard.setText(arrays.getEduReadHard(current).getSpot2());
        button3Hard.setText(arrays.getEduReadHard(current).getSpot3());
        button4Hard.setText(arrays.getEduReadHard(current).getSpot4());
        questionLabelHard.setText(arrays.getEduReadHard(current).getQuestion());
    }

    public void setRandom() {
        int randomnummber = random.nextInt(arrays.getEduReadHardList().size());
        while(current==randomnummber) {
            randomnummber = random.nextInt(arrays.getEduReadHardList().size());
        }
        current=randomnummber;

    }

    public void checkAnswer1() {
        if (button1Hard.getText().equals(arrays.getEduReadHard(current).getAnswer())) {
            rightAnswer();
        } else {
            wrongAnswer();
        }
    }

    public void checkAnswer2() {
        if (button2Hard.getText().equals(arrays.getEduReadHard(current).getAnswer())) {
            rightAnswer();
        } else {
            wrongAnswer();
        }
    }

    public void checkAnswer3() {
        if (button3Hard.getText().equals(arrays.getEduReadHard(current).getAnswer())) {
            rightAnswer();
        } else {
            wrongAnswer();
        }
    }

    public void checkAnswer4() {
        if (button4Hard.getText().equals(arrays.getEduReadHard(current).getAnswer())) {
            rightAnswer();
        } else {
            wrongAnswer();
        }
    }

    public void rightAnswer() {
        reset();
        rightHard.setText("Thats a correct answer!");
    }

    public void wrongAnswer() {
        reset();
        wrongHard.setText("Thats a wrong answer");
    }

    public void reset() {
        wrongHard.setText("");
        rightHard.setText("");
    }
}

