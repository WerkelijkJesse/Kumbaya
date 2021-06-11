package zeroXessApp.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;
import zeroXessApp.ClassObjects.Medicine;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DoctorHomeController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public ChoiceBox choiceBox;
    public TextArea textBox;
    public Label timeLabel;
    public Label succesLabel;
    public Label failLabel;
    public String doctor;

    public RadioButton rb1;
    public RadioButton rb2;
    public RadioButton rb3;
    public RadioButton rb4;
    public RadioButton rb5;
    public RadioButton rb6;
    public RadioButton rb7;
    public RadioButton rb8;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setValue("Accounts");
        for (int i = 0; i< arrays.getAccountList().size(); i++) {
            if (!arrays.getAccount(i).getUsername().equals(LoginController.getCurrentUser())) {
                choiceBox.getItems().add(arrays.getAccount(i).getUsername());
            }
        }
        Clock.initClockTime(timeLabel);
    }

    public void checkData(){
        String b1 = "";
        String b2 = "";
        String b3 = "";
        String b4 = "";
        String b5 = "";
        String b6 = "";
        String b7 = "";
        String b8 = "";
        doctor = choiceBox.getValue().toString();
        if (rb1.isSelected()) {
            b1 = "X"; }
        if (rb2.isSelected()) {
            b2 = "X"; }
        if (rb3.isSelected()) {
            b3 = "X"; }
        if (rb4.isSelected()) {
            b4 = "X"; }
        if (rb5.isSelected()) {
            b5 = "X"; }
        if (rb6.isSelected()) {
            b6 = "X"; }
        if (rb7.isSelected()) {
            b7 = "X"; }
        if (rb8.isSelected()) {
            b8 = "X"; }
        Medicine medicine = new Medicine(doctor, LoginController.getCurrentUser(), b1, b2, b3, b4, b5, b6, b7, b8);
        arrays.addMedicine(medicine);
    }

    public void textAreaUpdate() {
        succesLabel.setText("");
        for (int i = 0; i< arrays.getAccountList().size(); i++) {
            if (arrays.getAccount(i).getUsername().equals(choiceBox.getValue().toString())) {
                textBox.setText(arrays.getAccount(i).getDiseaces()); }
        }
    }

    public void backClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DoctorSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void removeCurrentMedication(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DoctorRemoveMedicationSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void saveClick() {
        if(choiceBox.getValue().equals("Accounts")){
            succesLabel.setText("Please select an Patient");
        }
        else{
            for (int i = 0; i < arrays.getAccountList().size(); i++) {
                if (arrays.getAccount(i).getUsername().equals(choiceBox.getValue().toString())) {
                    arrays.getAccount(i).setDiseaces(textBox.getText());
                    succesLabel.setText("Succes!"); } }
            checkData();
        }
        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(false);
        rb4.setSelected(false);
        rb5.setSelected(false);
        rb6.setSelected(false);
        rb7.setSelected(false);
        rb8.setSelected(false);
    }
}
