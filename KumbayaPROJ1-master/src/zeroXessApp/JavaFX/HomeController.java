package zeroXessApp.JavaFX;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;
import zeroXessApp.ClassObjects.Appointment;
import zeroXessApp.ClassObjects.HighScores;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public Label dateLabel;
    public Label timeLabel;
    public Label timeLabel2;
    public Label nameLabel;

    @FXML private TableView<HighScores> tableView;
    @FXML private TableColumn<HighScores, Integer> scores;
    @FXML private TableColumn<HighScores, String> users;
    @FXML private ListView<Appointment> listView;

    @FXML
    public ObservableList<Appointment> getFirstAppointments() {
        ObservableList<Appointment> firstAppointments = FXCollections.observableArrayList();
        arrays.getAppointmentList().sort(Comparator.comparing(Appointment::getLocalDateTime));
        for (int i = 0; i<arrays.getAppointmentList().size(); i++) {
            if (arrays.getAppointment(i).getLocalDateTime().isAfter(LocalDateTime.now()) &&
                    arrays.getAppointment(i).getPatientUser().equals(LoginController.getCurrentUser())) {
                firstAppointments.add(arrays.getAppointment(i));
            }
        }
        return firstAppointments;
    }

    public int firstAppointmentsListSize() {
        getFirstAppointments();
        int index = 0;
        for (int i = 0; i< getFirstAppointments().size(); i++) {
            index++;
        }
        return index;
    }

    @FXML
    public ObservableList<HighScores> getHighScores() {
        ObservableList<HighScores> highScores = FXCollections.observableArrayList();
        arrays.getMathHighScoreList().sort(Comparator.comparing(HighScores::getScore).reversed());
        for (int i = 0; i<arrays.getMathHighScoreList().size(); i++) {
                highScores.add(arrays.getMathHighScore(i));
        }
        return highScores;
    }

    public void loguitClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("LoginSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void contactClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ContactenSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void animalClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("CattleSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void dataClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ChangeDataSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void doctorClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("DoctorSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void eduClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("EduHomeSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void marktClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("MarktMain.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void initClockTime() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            timeLabel.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void initialize(URL location, ResourceBundle resources) {
        nameLabel.setText(LoginController.getCurrentUser());
        scores.setCellValueFactory(new PropertyValueFactory<HighScores, Integer>("score"));
        users.setCellValueFactory(new PropertyValueFactory<HighScores, String>("user"));
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY );
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.setItems(getHighScores());
        tableView.setEditable(false);
        listView.setItems(getFirstAppointments());
        listView.setEditable(false);
        Clock.initClockTime(timeLabel2);
        Clock.initClockDate(dateLabel);
        initClockTime();
    }
}
