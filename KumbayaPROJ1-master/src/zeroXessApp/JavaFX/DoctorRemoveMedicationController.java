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
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;
import zeroXessApp.ClassObjects.Medicine;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DoctorRemoveMedicationController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public Label timeLabel;
    public Label deleteText;

    @FXML private TableView<Medicine> tableView;
    @FXML private TableColumn<Medicine, String> name;
    @FXML private TableColumn<Medicine, String> m1;
    @FXML private TableColumn<Medicine, String> m2;
    @FXML private TableColumn<Medicine, String> m3;
    @FXML private TableColumn<Medicine, String> m4;
    @FXML private TableColumn<Medicine, String> m5;
    @FXML private TableColumn<Medicine, String> m6;
    @FXML private TableColumn<Medicine, String> m7;
    @FXML private TableColumn<Medicine, String> m8;


    public void backClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DoctorHomeSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public ObservableList<Medicine> getMedicine() {
        ObservableList<Medicine> medicine = FXCollections.observableArrayList();
        for (int i = 0; i< arrays.getMedicineList().size(); i++) {
            if (arrays.getMedicine(i).getDoctor().equals(LoginController.getCurrentUser())) {
                medicine.add(arrays.getMedicine(i));
            }
        }
        return medicine;
    }

    public void deleteUser(){
        for (int i = 0; i< arrays.getMedicineList().size(); i++) {
            if (tableView.getSelectionModel().getSelectedItem().equals(arrays.getMedicine(i))) {
                arrays.getMedicineList().remove(i);} }
        deleteText.setText("Succesfully deleted");
        tableViewer();
    }

    public void tableViewer(){
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.setItems(getMedicine());
        tableView.setEditable(true);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        name.setCellValueFactory(new PropertyValueFactory<Medicine, String>("name"));
        m1.setCellValueFactory(new PropertyValueFactory<Medicine, String>("m1"));
        m2.setCellValueFactory(new PropertyValueFactory<Medicine, String>("m2"));
        m3.setCellValueFactory(new PropertyValueFactory<Medicine, String>("m3"));
        m4.setCellValueFactory(new PropertyValueFactory<Medicine, String>("m4"));
        m5.setCellValueFactory(new PropertyValueFactory<Medicine, String>("m5"));
        m6.setCellValueFactory(new PropertyValueFactory<Medicine, String>("m6"));
        m7.setCellValueFactory(new PropertyValueFactory<Medicine, String>("m7"));
        m8.setCellValueFactory(new PropertyValueFactory<Medicine, String>("m8"));
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Clock.initClockTime(timeLabel);
        tableViewer();
    }
}
