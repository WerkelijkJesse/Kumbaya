package zeroXessApp.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Checker;
import zeroXessApp.Classes.Clock;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private static String currentUser;
    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public PasswordField passField;
    public TextField userField;
    public Label incorrectLabel;
    public Label timeLabel;

    public void initialize(URL location, ResourceBundle resources) {
        Clock.initClockTime(timeLabel); }

    public void loginButtonClick(ActionEvent event) throws IOException {
        if (Checker.checkLogin(arrays.getAccountList(), userField.getText(), passField.getText())) {
            incorrectLabel.setText("");
            currentUser = userField.getText();
            Parent root = FXMLLoader.load(getClass().getResource("HomeSample.fxml"));
            ButtonSwitch.switchMenus(event, root);
        }
        else {
            incorrectLabel.setText("Incorrect information.");
        }
    }

    public void newClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NewAccSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void forgotClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ForgotPassSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public static void setCurrentUser(String user) {
        currentUser = user;
    }

    public void exitClick() {
        System.exit(1);
    }

    public static String getCurrentUser() {
        return currentUser;
    }
}
