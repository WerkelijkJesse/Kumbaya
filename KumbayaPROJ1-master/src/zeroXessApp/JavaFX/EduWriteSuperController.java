package zeroXessApp.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import zeroXessApp.Classes.ButtonSwitch;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class EduWriteSuperController {

    public static String wrongAnswer = "Almost! Try checking the sentence one more time!";
    public static String rightAnswer = "Right!";

    int index = 0;
    long start;
    long end;
    boolean timeIsOn = false;

    public abstract void initialize(URL location, ResourceBundle resources);

    public void goBack (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduWriteSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void startTime(){
        start = System.currentTimeMillis();
        timeIsOn = true;
    }

    public static String getWrongAnswer() {
        return wrongAnswer;
    }

    public static String getRightAnswer() {
        return rightAnswer;
    }

}
