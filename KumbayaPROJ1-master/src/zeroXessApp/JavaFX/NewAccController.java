package zeroXessApp.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import zeroXessApp.Classes.*;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;
import zeroXessApp.ClassObjects.Accounts;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewAccController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public TextField yobField;
    public TextField countryField;
    public TextField userField;
    public TextField adressField;
    public TextField secretField;
    public TextField phoneField;
    public PasswordField passField;
    public Label succesLabel;
    public Label wrongLabel;
    public Label timeLabel;

    public void initialize(URL location, ResourceBundle resources) {
        Clock.initClockTime(timeLabel); }

    public void createClick(ActionEvent event) throws IOException {
        if ((yobField.getText().equals("") || countryField.getText().equals("") || userField.getText().equals("") || adressField.getText().equals("")
           ||secretField.getText().equals("") || phoneField.getText().equals("") || passField.getText().equals(""))) {
             wrongLabel.setText("Please fill in every field."); }

        else if (!Checker.checkAge(Integer.parseInt(yobField.getText()))) {
            wrongLabel.setText("Too young, sorry.");
        }

        else {
            succesLabel.setText("");
            wrongLabel.setText("");
            if (Checker.checkUsername(arrays.getAccountList(), userField.getText())) {
                Accounts account = new Accounts(adressField.getText(), Integer.parseInt(yobField.getText()), userField.getText(),
                        countryField.getText(), passField.getText(), secretField.getText(), phoneField.getText());
                arrays.addAccount(account);
                succesLabel.setText("New account created. Price: €" + Checker.checkPrice(Integer.parseInt(yobField.getText()))); }
            else { wrongLabel.setText("This username is already in use."); } }
    }

    public void goBackButtonClick(ActionEvent event) throws IOException {
        wrongLabel.setText("");
        succesLabel.setText("");
        Parent root = FXMLLoader.load(getClass().getResource("LoginSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }
}
