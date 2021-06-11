package zeroXessApp.JavaFX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import zeroXessApp.Classes.*;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;
import zeroXessApp.ClassObjects.Appointment;
import zeroXessApp.ClassObjects.Doctor;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PatientPlanController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();
    private static final ArrayList<RadioButton> buttons = new ArrayList<>();
    private static final ArrayList<Label> appointments = new ArrayList<>();
    private Doctor doctor;
    private String time;

    @FXML private TableView<Doctor> tableView;
    @FXML private TableColumn<Doctor, String> realName;
    @FXML private TableColumn<Doctor, Boolean> ear;
    @FXML private TableColumn<Doctor, Boolean> eyes;
    @FXML private TableColumn<Doctor, Boolean> skin;
    @FXML private TableColumn<Doctor, Boolean> general;

    public ChoiceBox choiceBox;
    public Label timeLabel;
    public DatePicker datePicker;
    public TextArea textArea;
    public Button createButton;

    public void makeAppointment(ActionEvent event) throws IOException {
        for (int i = 0; i< arrays.getDoctorList().size(); i++) {
            if (arrays.getDoctor(i).getRealName().equals(choiceBox.getValue().toString())) {
                doctor = arrays.getDoctor(i); } }

        for (int i=0; i<buttons.size(); i++) {
            if (buttons.get(i).isSelected()) {
                time = buttons.get(i).getText(); } }

        if (Checker.checkAppointment(doctor.getRealName(), datePicker.getValue(), LocalTime.parse(time))) {
            Appointment appointment = new Appointment(doctor.getRealName(), doctor.getAdress(),
            LoginController.getCurrentUser(), textArea.getText(), datePicker.getValue(), LocalTime.parse(time));
            arrays.addAppointment(appointment);
            backClick(event);
        }

        else if (choiceBox.getItems() == null) {
            createButton.setText("Please choose a doctor.");
        }
        else {
            createButton.setText("Doctor unavailable at this time.");
        }
    }

    public void checkAppointmentData(){
        for (int i = 0; i< arrays.getDoctorList().size(); i++) {
            if (arrays.getDoctor(i).getRealName().equals(choiceBox.getValue().toString())) {
                doctor = arrays.getDoctor(i); } }

        for (int i=0; i<appointments.size(); i++){
            if(Checker.checkAppointment(doctor.getRealName(), datePicker.getValue(), LocalTime.parse(buttons.get(i).getText()))) {
                appointments.get(i).setText(""); }
            else {
                appointments.get(i).setText("X"); }
        }
    }

    public void backClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PatientHomeSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    @FXML
    public ObservableList<Doctor> getDoctor() {
        ObservableList<Doctor> doctor = FXCollections.observableArrayList();
        for (int i = 0; i< arrays.getDoctorList().size(); i++) {
                doctor.add(arrays.getDoctor(i)); }
        return doctor;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setValue("Doctors");

        for (int i = 0; i< arrays.getDoctorList().size(); i++) {
            choiceBox.getItems().add(arrays.getDoctor(i).getRealName());
        }
        datePicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                setDisable(empty || date.compareTo(today) < 0 );
            }
        });
        realName.setCellValueFactory(new PropertyValueFactory<Doctor, String>("realName"));
        ear.setCellValueFactory(new PropertyValueFactory<Doctor, Boolean>("Ear"));
        eyes.setCellValueFactory(new PropertyValueFactory<Doctor, Boolean>("Eyes"));
        skin.setCellValueFactory(new PropertyValueFactory<Doctor, Boolean>("Skin"));
        general.setCellValueFactory(new PropertyValueFactory<Doctor, Boolean>("General"));
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.setItems(getDoctor());
        tableView.setEditable(false);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY );
        Clock.initClockTime(timeLabel);
        addButtonsToList();
        addXToList();
    }

    public RadioButton b1;
    public RadioButton b2;
    public RadioButton b3;
    public RadioButton b4;
    public RadioButton b5;
    public RadioButton b6;
    public RadioButton b7;
    public RadioButton b8;
    public RadioButton b9;
    public RadioButton b10;
    public RadioButton b11;
    public RadioButton b12;
    public RadioButton b13;
    public RadioButton b14;
    public RadioButton b15;
    public RadioButton b16;

    public Label x1;
    public Label x2;
    public Label x3;
    public Label x4;
    public Label x5;
    public Label x6;
    public Label x7;
    public Label x8;
    public Label x9;
    public Label x10;
    public Label x11;
    public Label x12;
    public Label x13;
    public Label x14;
    public Label x15;
    public Label x16;

    public void addButtonsToList() {
        buttons.add(b1); buttons.add(b2); buttons.add(b3); buttons.add(b4);
        buttons.add(b5); buttons.add(b6); buttons.add(b7); buttons.add(b8);
        buttons.add(b9); buttons.add(b10); buttons.add(b11); buttons.add(b12);
        buttons.add(b13); buttons.add(b14); buttons.add(b15); buttons.add(b16);
    }

    public void addXToList(){
        appointments.add(x1); appointments.add(x2); appointments.add(x3); appointments.add(x4);
        appointments.add(x5); appointments.add(x6); appointments.add(x7); appointments.add(x8);
        appointments.add(x9); appointments.add(x10); appointments.add(x11); appointments.add(x12);
        appointments.add(x13); appointments.add(x14); appointments.add(x15); appointments.add(x16);
    }
}
