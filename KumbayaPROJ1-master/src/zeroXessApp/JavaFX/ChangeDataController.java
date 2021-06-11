package zeroXessApp.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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

public class ChangeDataController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();
    private static int index;
    public Label timeLabel;
    public Label currentCountry;
    public Label currentAdress;
    public Label currentUsername;
    public Label currentPassword;
    public Label currentNumber;
    public Label inUseLabel;

    public TextField countryField;
    public TextField adressField;
    public TextField userField;
    public TextField phoneField;
    public PasswordField passField;
    public Button backButton;

    public void Click(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomeSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void initialize(URL location, ResourceBundle resources) {
        Clock.initClockTime(timeLabel);
        initVariables();
    }

    private void initVariables() {
        for (int i = 0; i< arrays.getAccountList().size(); i++) {
            if (arrays.getAccount(i).getUsername().equalsIgnoreCase(LoginController.getCurrentUser())) {
                index = i;
                currentCountry.setText(arrays.getAccount(i).getCountry());
                currentAdress.setText(arrays.getAccount(i).getAdress());
                currentUsername.setText(arrays.getAccount(i).getUsername());
                currentPassword.setText(arrays.getAccount(i).getPassword());
                currentNumber.setText(arrays.getAccount(i).getPhoneNumber()); } }
    }

    public void changeCountry() {
        arrays.getAccount(index).setCountry(countryField.getText());
        currentCountry.setText(arrays.getAccount(index).getCountry()); }

    public void changeAdress() {
        arrays.getAccount(index).setAdress(adressField.getText());
        currentAdress.setText(arrays.getAccount(index).getAdress()); }

    public void changeUsername() {
        if (Checker.checkUsername(arrays.getAccountList(), userField.getText())) {
            arrays.getAccount(index).setUsername(userField.getText());
            currentUsername.setText(arrays.getAccount(index).getUsername());
            inUseLabel.setText(""); }

        else {
            inUseLabel.setText("Username already in use. Please choose another one."); } }

    public void changePassword() {
        arrays.getAccount(index).setPassword(passField.getText());
        currentPassword.setText(arrays.getAccount(index).getPassword()); }

    public void changeNumber() {
        arrays.getAccount(index).setNumber(phoneField.getText());
        currentNumber.setText(arrays.getAccount(index).getPhoneNumber()); }
}
