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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import zeroXessApp.ClassObjects.Animals;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CattleViewController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    @FXML private TableView<Animals> tableView;
    @FXML private TableColumn<Animals, String> cattle;
    @FXML private TableColumn<Animals, String> name;
    @FXML private TableColumn<Animals, String> gender;
    @FXML private TableColumn<Animals, String> color;
    @FXML private TableColumn<Animals, Double> weight;
    public Label timeLabel;
    public Label succesLabel;

    public void backClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CattleSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    @FXML
    public ObservableList<Animals> getCattle() {
        ObservableList<Animals> cattle = FXCollections.observableArrayList();
        for (int i = 0; i< arrays.getCattleList().size(); i++) {
            if (arrays.getCattle(i).getAddedBy().equals(LoginController.getCurrentUser())) {
            cattle.add(arrays.getCattle(i)); } }
        return cattle;
    }

    public int cattleListSize() {
        getCattle();
        int index = 0;
        for (int i = 0; i< getCattle().size(); i++) {
            index++;
        }
        return index;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        cattle.setCellValueFactory(new PropertyValueFactory<Animals, String>("cattle"));
        name.setCellValueFactory(new PropertyValueFactory<Animals, String>("name"));
        gender.setCellValueFactory(new PropertyValueFactory<Animals, String>("gender"));
        color.setCellValueFactory(new PropertyValueFactory<Animals, String>("color"));
        weight.setCellValueFactory(new PropertyValueFactory<Animals, Double>("weight"));
        cattle.setCellFactory(TextFieldTableCell.forTableColumn());
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.setItems(getCattle());
        tableView.setEditable(true);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY );
        GridPane.setColumnSpan(tableView, GridPane.REMAINING);
        Clock.initClockTime(timeLabel);
    }
}
