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
import javafx.scene.paint.Color;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;
import zeroXessApp.ClassObjects.Medicine;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PatientMedicineController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();
    public Label timeLabel;
    public Label wrongMedicine;

    @FXML private TableView<Medicine> tableView;
    @FXML private TableColumn<Medicine, String> doctor;
    @FXML private TableColumn<Medicine, String> m1;
    @FXML private TableColumn<Medicine, String> m2;
    @FXML private TableColumn<Medicine, String> m3;
    @FXML private TableColumn<Medicine, String> m4;
    @FXML private TableColumn<Medicine, String> m5;
    @FXML private TableColumn<Medicine, String> m6;
    @FXML private TableColumn<Medicine, String> m7;
    @FXML private TableColumn<Medicine, String> m8;

    public RadioButton rb1;
    public RadioButton rb2;
    public RadioButton rb3;
    public RadioButton rb4;
    public RadioButton rb5;
    public RadioButton rb6;
    public RadioButton rb7;
    public RadioButton rb8;

    int a = 0;

    public void backClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PatientHomeSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public ObservableList<Medicine> getMedicine() {
        ObservableList<Medicine> medicine = FXCollections.observableArrayList();
        for (int i = 0; i< arrays.getMedicineList().size(); i++) {
            if (arrays.getMedicine(i).getName().equals(LoginController.getCurrentUser())) {
                medicine.add(arrays.getMedicine(i));
            }
        }
        return medicine;
    }

    public void orderStandard() {
        wrongMedicine.setText("please only select medicine which is prescribed to you");
        a++;
    }

    public void getSelectedMedicine(int i) {
        if (!tableView.getItems().isEmpty()) {
            if (rb1.isSelected() && !arrays.getMedicine(i).getM1().contains("X")) {
                orderStandard();
            }
            if (rb2.isSelected() && !arrays.getMedicine(i).getM2().contains("X")) {
                orderStandard();
            }
            if (rb3.isSelected() && !arrays.getMedicine(i).getM3().contains("X")) {
                orderStandard();
            }
            if (rb4.isSelected() && !arrays.getMedicine(i).getM4().contains("X")) {
                orderStandard();
            }
            if (rb5.isSelected() && !arrays.getMedicine(i).getM5().contains("X")) {
                orderStandard();
            }
            if (rb6.isSelected() && !arrays.getMedicine(i).getM6().contains("X")) {
                orderStandard();
            }
            if (rb7.isSelected() && !arrays.getMedicine(i).getM7().contains("X")) {
                orderStandard();
            }
            if (rb8.isSelected() && !arrays.getMedicine(i).getM8().contains("X")) {
                orderStandard();
            }
        }
    }

    public void getUserMedicine(){
        wrongMedicine.setTextFill(Color.web("#862828"));
        for (int i = 0; i< arrays.getMedicineList().size(); i++) {
            if (arrays.getMedicine(i).getName().equals(LoginController.getCurrentUser())) {
                getSelectedMedicine(i);
            }
        }
        reset();
        a = 0;
    }

    public void reset() {
        if (a == 0) {
            wrongMedicine.setTextFill(Color.web("#15d625"));
            wrongMedicine.setText("Succefull ordered");
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Clock.initClockTime(timeLabel);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.setItems(getMedicine());
        tableView.setEditable(true);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        doctor.setCellValueFactory(new PropertyValueFactory<Medicine, String>("doctor"));
        m1.setCellValueFactory(new PropertyValueFactory<Medicine, String>("m1"));
        m2.setCellValueFactory(new PropertyValueFactory<Medicine, String>("m2"));
        m3.setCellValueFactory(new PropertyValueFactory<Medicine, String>("m3"));
        m4.setCellValueFactory(new PropertyValueFactory<Medicine, String>("m4"));
        m5.setCellValueFactory(new PropertyValueFactory<Medicine, String>("m5"));
        m6.setCellValueFactory(new PropertyValueFactory<Medicine, String>("m6"));
        m7.setCellValueFactory(new PropertyValueFactory<Medicine, String>("m7"));
        m8.setCellValueFactory(new PropertyValueFactory<Medicine, String>("m8"));
    }

}
