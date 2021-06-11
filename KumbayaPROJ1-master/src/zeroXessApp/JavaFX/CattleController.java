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

public class CattleController implements Initializable {

    public Label timeLabel;

    public void initialize(URL location, ResourceBundle resources) {
        Clock.initClockTime(timeLabel); }

    public void addClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CattleAddSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void viewClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CattleViewSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void goBack (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomeSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }
}

