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

public class EduHomeController implements Initializable {

    public Label timeLabel;

    public void initialize(URL location, ResourceBundle resources) {
        Clock.initClockTime(timeLabel);
    }

    public void goBackClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomeSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void readClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduReadSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void writeClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduWriteSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void mathClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduMathSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }
}
