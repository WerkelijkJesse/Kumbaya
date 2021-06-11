package zeroXessApp.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EduMathController implements Initializable {

    public Label timeLabel;

    public void initialize(URL location, ResourceBundle resources) {
        Clock.initClockTime(timeLabel);
    }

    public void backClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduHomeSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void plusClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduMathPlusSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void minusClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduMathMinusSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void multiplyClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduMathMultiplySample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void divideClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduMathDivideSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void shuffleClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduMathShuffleSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }
}
