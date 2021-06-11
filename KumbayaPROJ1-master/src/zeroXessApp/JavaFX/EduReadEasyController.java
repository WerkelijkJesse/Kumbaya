package zeroXessApp.JavaFX;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.Clock;

import java.net.URL;
import java.util.ResourceBundle;

public class EduReadEasyController extends EduReadSuperController implements Initializable  {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public Label timeLabel;
    public Label questionLabel;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Label right;
    public Label wrong;

    public void initialize(URL location, ResourceBundle resources) {
        Clock.initClockTime(timeLabel);
        question();
        getCurrent();
    }

    public int getCurrent() {
        int current = random.nextInt(arrays.getEduReadEasyList().size());
        return current;
    }

    public void question() {
        button1.setText(arrays.getEduReadEasy(current).getSpot1());
        button2.setText(arrays.getEduReadEasy(current).getSpot2());
        button3.setText(arrays.getEduReadEasy(current).getSpot3());
        button4.setText(arrays.getEduReadEasy(current).getSpot4());
        questionLabel.setText(arrays.getEduReadEasy(current).getQuestion());
    }

    public void setRandom() {
        int randomnummber = random.nextInt(arrays.getEduReadEasyList().size());
        while(current==randomnummber) {
            randomnummber = random.nextInt(arrays.getEduReadEasyList().size());
        }
        current=randomnummber;

    }

    public void checkAnswer1() {
        if (button1.getText().equals(arrays.getEduReadEasy(current).getAnswer())) {
            rightAnswer();
        } else {
            wrongAnswer();
        }
    }

    public void checkAnswer2() {
        if (button2.getText().equals(arrays.getEduReadEasy(current).getAnswer())) {
            rightAnswer();
        } else {
            wrongAnswer();
        }
    }

    public void checkAnswer3() {
        if (button3.getText().equals(arrays.getEduReadEasy(current).getAnswer())) {
            rightAnswer();
        } else {
            wrongAnswer();
        }
    }

    public void checkAnswer4() {
        if (button4.getText().equals(arrays.getEduReadEasy(current).getAnswer())) {
            rightAnswer();
        } else {
            wrongAnswer();
        }
    }

    public void rightAnswer() {
        reset();
        right.setText("Thats a correct answer!");
    }

    public void wrongAnswer() {
        reset();
        wrong.setText("Thats a wrong answer");
    }

    public void reset() {
        wrong.setText("");
        right.setText("");
    }
}




