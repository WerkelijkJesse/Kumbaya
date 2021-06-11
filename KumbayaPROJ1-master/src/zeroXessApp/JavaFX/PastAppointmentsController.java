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
import zeroXessApp.ClassObjects.Appointment;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.ResourceBundle;

public class PastAppointmentsController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    @FXML private TableView<Appointment> tableView1;
    @FXML private TableColumn<Appointment, String> name1;
    @FXML private TableColumn<Appointment, String> adress1;
    @FXML private TableColumn<Appointment, String> date1;
    @FXML private TableColumn<Appointment, String> time1;
    public Label timeLabel1;


    public void backClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PatientHomeSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    @FXML
    public ObservableList<Appointment> getAppointmentList() {
        ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();
        arrays.getAppointmentList().sort(Comparator.comparing(Appointment::getLocalDateTime));
        for (int i = 0; i< arrays.getAppointmentList().size(); i++) {
            if (arrays.getAppointment(i).getLocalDateTime().isBefore(LocalDateTime.now()) &&
                    arrays.getAppointment(i).getPatientUser().equals(LoginController.getCurrentUser())) {
                appointmentList.add(arrays.getAppointment(i));
            }
        }
        return appointmentList;
    }

    public int pastAppointmentListSize() {
        getAppointmentList();
        int index = 0;
        for (int i = 0; i< getAppointmentList().size(); i++) {
            index++;
        }
        return index;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        name1.setCellValueFactory(new PropertyValueFactory<Appointment, String>("Name"));
        adress1.setCellValueFactory(new PropertyValueFactory<Appointment, String>("Adress"));
        date1.setCellValueFactory(new PropertyValueFactory<Appointment, String>("Date"));
        time1.setCellValueFactory(new PropertyValueFactory<Appointment, String>("Time"));
        tableView1.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView1.setItems(getAppointmentList());
        tableView1.setEditable(false);
        tableView1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY );
        GridPane.setColumnSpan(tableView1, GridPane.REMAINING);
        Clock.initClockTime(timeLabel1);
    }
}
