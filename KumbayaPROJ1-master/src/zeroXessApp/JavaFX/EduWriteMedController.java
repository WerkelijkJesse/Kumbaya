package zeroXessApp.JavaFX;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.Checker;
import zeroXessApp.Classes.Clock;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class EduWriteMedController extends EduWriteSuperController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public Label timeLabel;
    public TextArea medAnswer;
    public Label medQuestion;
    public Button medCheck;
    public Label resultText;
    public Label finishedSentence;

    public void answerCheck(){
        if (rightAnswer()){
            EduWriteController.setRightAnswer(resultText, medAnswer);
            index++;
            medQuestion.setText(arrays.getEasyWrite(index));
        } else {
            EduWriteController.setWrongAnswer(resultText);
        }
    }

    public boolean rightAnswer() {
        return Checker.writeAnswerCompare(medQuestion.getText(), medAnswer.getText(), timeIsOn);
    }

    public void stopTime(){
        end = System.currentTimeMillis();
        float timeElapsed = (end - start)/1000F;
        DecimalFormat df = new DecimalFormat("###.##");
        String eindzin = "Finished! It took you " + df.format(timeElapsed) + " seconds!";
        finishedSentence.setTextFill(Color.web("#12f612"));
        finishedSentence.setText(eindzin);
    }

    public void initialize(URL location, ResourceBundle resources) {
        medQuestion.setText(arrays.getMediumWrite(index));
        Clock.initClockTime(timeLabel);
    }
}
