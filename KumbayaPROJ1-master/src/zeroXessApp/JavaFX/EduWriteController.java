package zeroXessApp.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EduWriteController extends EduWriteSuperController implements Initializable {

    public Label timeLabel;

    public static void setWrongAnswer(Label text){
        text.setTextFill(Color.web("#FF0000"));
        text.setText(wrongAnswer);
    }

    public static void setRightAnswer(Label text, TextArea antwoord){
        text.setTextFill(Color.web("#12f612"));
        text.setText(rightAnswer);
        antwoord.setText("");
    }

    public void goBack (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduHomeSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void goEasy (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduWriteEasySample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void goMedium (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduWriteMedSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void goHard (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduWriteHardSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void goNew (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduWriteWordsSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void initialize(URL location, ResourceBundle resources) {
        Clock.initClockTime(timeLabel);
    }
}
