package zeroXessApp.JavaFX;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.Clock;

import java.net.URL;
import java.util.ResourceBundle;

public class EduReadMediumController extends EduReadSuperController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public Label timeLabelMedium;
    public Label questionLabelMedium;
    public Button button1Medium;
    public Button button2Medium;
    public Button button3Medium;
    public Button button4Medium;
    public Label rightMedium;
    public Label wrongMedium;

    public void initialize(URL location, ResourceBundle resources) {
        Clock.initClockTime(timeLabelMedium);
        question();
        getCurrent();
    }

    public int getCurrent() {
        int current = random.nextInt(arrays.getEduReadMediumList().size());
        return current;
    }

    public void question() {
        button1Medium.setText(arrays.getEduReadMedium(current).getSpot1());
        button2Medium.setText(arrays.getEduReadMedium(current).getSpot2());
        button3Medium.setText(arrays.getEduReadMedium(current).getSpot3());
        button4Medium.setText(arrays.getEduReadMedium(current).getSpot4());
        questionLabelMedium.setText(arrays.getEduReadMedium(current).getQuestion());
    }

    public void setRandom() {
        int randomnummber = random.nextInt(arrays.getEduReadMediumList().size());
        while(current==randomnummber) {
            randomnummber = random.nextInt(arrays.getEduReadMediumList().size());
        }
        current=randomnummber;

    }

    public void checkAnswer1() {
        if (button1Medium.getText().equals(arrays.getEduReadMedium(current).getAnswer())) {
            rightAnswer();
        } else {
            wrongAnswer();
        }
    }

    public void checkAnswer2() {
        if (button2Medium.getText().equals(arrays.getEduReadMedium(current).getAnswer())) {
            rightAnswer();
        } else {
            wrongAnswer();
        }
    }

    public void checkAnswer3() {
        if (button3Medium.getText().equals(arrays.getEduReadMedium(current).getAnswer())) {
            rightAnswer();
        } else {
            wrongAnswer();
        }
    }

    public void checkAnswer4() {
        if (button4Medium.getText().equals(arrays.getEduReadMedium(current).getAnswer())) {
            rightAnswer();
        } else {
            wrongAnswer();
        }
    }

    public void rightAnswer() {
        reset();
        rightMedium.setText("Thats a correct answer!");
    }

    public void wrongAnswer() {
        reset();
        wrongMedium.setText("Thats a wrong answer");
    }

    public void reset() {
        wrongMedium.setText("");
        rightMedium.setText("");
    }
}

