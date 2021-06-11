package zeroXessApp.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Checker;
import zeroXessApp.Classes.Clock;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ForgotPassController implements Initializable {

    Checker checker = new Checker();
    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public TextField userField;
    public TextField yobField;
    public TextField bankField;
    public Label showLabel;
    public Label showLabel2;
    public Label wrongLabel;
    public Label timeLabel;

    public void checkButtonClick(ActionEvent event) throws IOException {
        reset();

        if ((userField.getText().equals("") || yobField.getText().equals("") || bankField.getText().equals(""))) {
            wrongLabel.setText("Please fill in every field");}

        else {
            if (checker.checkForgot(arrays.getAccountList(), userField.getText(),
                    Integer.parseInt(yobField.getText()), bankField.getText())) {
                showLabel.setText("Your password is:");
                showLabel2.setText(checker.getPassword()); }
            else {
                wrongLabel.setText("Incorrect information."); }}
    }

    public void goBackButtonClick(ActionEvent event) throws IOException {
        reset();
        Parent root = FXMLLoader.load(getClass().getResource("LoginSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void reset() {
        showLabel.setText("");
        showLabel2.setText("");
        wrongLabel.setText("");
    }

    public void initialize(URL location, ResourceBundle resources) {
        Clock.initClockTime(timeLabel); }
}
