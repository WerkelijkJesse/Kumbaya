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

public class EduReadController implements Initializable {

    public Label timeLabel;

    public void initialize(URL location, ResourceBundle resources) {
        Clock.initClockTime(timeLabel);
    }

    public void easyClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduReadEasySample.fxml"));
        ButtonSwitch.switchMenus(event, root);}

    public void mediumClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduReadMediumSample.fxml"));
        ButtonSwitch.switchMenus(event, root);}

    public void hardClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduReadHardSample.fxml"));
        ButtonSwitch.switchMenus(event, root);}

    public void readAndPickClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ReadAndPickSample.fxml"));
        ButtonSwitch.switchMenus(event, root);}

    public void goBack (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduHomeSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }



}
