package zeroXessApp.JavaFX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.ClassObjects.Appointment;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.ResourceBundle;

public class PatientHomeController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    @FXML private TableView<Appointment> tableView;
    @FXML private TableColumn<Appointment, String> name;
    @FXML private TableColumn<Appointment, String> adress;
    @FXML private TableColumn<Appointment, String> date;
    @FXML private TableColumn<Appointment, String> time;
    public Label timeLabel;

    public void backClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DoctorSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void appointmentClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PatientPlanSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void pastClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PastAppointments.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void orderMedicineClick(ActionEvent event) throws IOException {
        String input = JOptionPane.showInputDialog("Please enter your age: ");
        try{
            if (!accesMedicine(Integer.parseInt(input))) {
                if (Integer.parseInt(input) < 0){
                    JOptionPane.showMessageDialog(null,"Please enter a possible age.");
                }
                else {
                    JOptionPane.showMessageDialog(null, "You are not allowed in here.");
                }
            }
            else if (accesMedicine(Integer.parseInt(input))){
                Parent root = FXMLLoader.load(getClass().getResource("PatientMedicine.fxml"));
                ButtonSwitch.switchMenus(event, root);
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Please enter a number.");
        }
    }

    public boolean accesMedicine(int input) {
        if (input >= 18) {
            return true;
        }
        return false;
    }

    @FXML
    public ObservableList<Appointment> getAppointments() {
        ObservableList<Appointment> appointments = FXCollections.observableArrayList();
        arrays.getAppointmentList().sort(Comparator.comparing(Appointment::getLocalDateTime));
        for (int i = 0; i< arrays.getAppointmentList().size(); i++) {
            if (arrays.getAppointment(i).getLocalDateTime().isAfter(LocalDateTime.now()) &&
                    arrays.getAppointment(i).getPatientUser().equals(LoginController.getCurrentUser())) {
                appointments.add(arrays.getAppointment(i));
            }
        }
        return appointments;
    }

    public int upcomingAppointmentsListSize() {
        getAppointments();
        int index = 0;
        for (int i = 0; i< getAppointments().size(); i++) {
            index++;
        }
        return index;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<Appointment, String>("Name"));
        adress.setCellValueFactory(new PropertyValueFactory<Appointment, String>("Adress"));
        date.setCellValueFactory(new PropertyValueFactory<Appointment, String>("Date"));
        time.setCellValueFactory(new PropertyValueFactory<Appointment, String>("Time"));
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.setItems(getAppointments());
        tableView.setEditable(false);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY );
        GridPane.setColumnSpan(tableView, GridPane.REMAINING);
        Clock.initClockTime(timeLabel);
    }
}
