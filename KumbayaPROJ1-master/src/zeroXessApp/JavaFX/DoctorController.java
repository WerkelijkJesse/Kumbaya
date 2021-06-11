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

public class DoctorController implements Initializable {

    public Label timeLabel;
    public Label noDoctor;

    public void initialize(URL location, ResourceBundle resources) {
        Clock.initClockTime(timeLabel);
    }

    public void backClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomeSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void faqClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FAQSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void doctorClick(ActionEvent event) throws IOException {
        if(hasAcces()){
            Parent root = FXMLLoader.load(getClass().getResource("DoctorHomeSample.fxml"));
            ButtonSwitch.switchMenus(event, root);
        }
        else{
            noDoctor.setText("This is only allowed for Doctors");
        }
    }

    public boolean hasAcces() {
        if (LoginController.getCurrentUser().matches("Moderator|Tracey|Matt|Carl|Donald|Jack")) {
            return true;
        }
        return false;
    }

    public void patientClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PatientHomeSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }
}
