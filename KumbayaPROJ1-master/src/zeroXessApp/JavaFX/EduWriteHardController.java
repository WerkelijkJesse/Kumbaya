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

public class EduWriteHardController extends EduWriteSuperController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public TextArea hardAnswer;
    public Label hardQuestion;
    public Button hardCheck;
    public Label resultText;
    public Label timeLabel;
    public Label finishedSentence;

    public void answerCheck(){
        if (rightAnswer()){
            EduWriteController.setRightAnswer(resultText, hardAnswer);
            index++;
            hardQuestion.setText(arrays.getEasyWrite(index));
        } else {
            EduWriteController.setWrongAnswer(resultText);
        }
    }

    public boolean rightAnswer() {
        return Checker.writeAnswerCompare(hardQuestion.getText(), hardAnswer.getText(), timeIsOn);
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
        hardQuestion.setText(arrays.getHardWrite(index));
        Clock.initClockTime(timeLabel);
    }
}
