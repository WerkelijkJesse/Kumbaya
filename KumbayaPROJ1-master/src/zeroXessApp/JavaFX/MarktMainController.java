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

public class MarktMainController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    @FXML private TableView<Animals> tableView;
    @FXML private TableColumn<Animals, String> cattle;
    @FXML private TableColumn<Animals, String> name;
    @FXML private TableColumn<Animals, String> gender;
    @FXML private TableColumn<Animals, String> color;
    @FXML private TableColumn<Animals, Integer> price;
    @FXML private TableColumn<Animals, Double> weight;

    public TextField bidText;
    public Label succesLabel;
    public Label failLabel;
    public Label timeLabel;

    public void makeBid(){
        succesLabel.setText("");
        failLabel.setText("");
        if (Integer.parseInt(bidText.getText()) >= 1 && Integer.parseInt(bidText.getText()) > tableView.getSelectionModel().getSelectedItem().getPrice()) {
            for (int i = 0; i < arrays.getMarketAnimalList().size(); i++) {
                if (arrays.getMarketAnimal(i).getName().
                    equals(tableView.getSelectionModel().getSelectedItem().getName())) {
                    arrays.getMarketAnimal(i).setPrice(Integer.parseInt(bidText.getText())); } }
            succesLabel.setText("You succesfully placed your bid.");
            tableView.refresh();
        }
        else {
            failLabel.setText("Error: bid lower than current one."); }
    }

    public void sellClick(ActionEvent event) throws IOException {
        succesLabel.setText("");
        Parent root = FXMLLoader.load(getClass().getResource("MarktSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void goBack (ActionEvent event) throws IOException {
        succesLabel.setText("");
        Parent root = FXMLLoader.load(getClass().getResource("HomeSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    @FXML
    public ObservableList <Animals> addCattle() {
        ObservableList<Animals> cattle = FXCollections.observableArrayList();
        for (int i = 0; i< arrays.getMarketAnimalList().size(); i++) {
            cattle.add(arrays.getMarketAnimal(i)); }
        return cattle;
    }

    public int marketCattleListSize() {
        addCattle();
        int index = 0;
        for (int i = 0; i< addCattle().size(); i++) {
            index++;
        }
        return index;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        cattle.setCellValueFactory(new PropertyValueFactory<Animals, String>("cattle"));
        name.setCellValueFactory(new PropertyValueFactory<Animals, String>("name"));
        gender.setCellValueFactory(new PropertyValueFactory<Animals, String>("gender"));
        color.setCellValueFactory(new PropertyValueFactory<Animals, String>("color"));
        price.setCellValueFactory(new PropertyValueFactory<Animals, Integer>("price"));
        weight.setCellValueFactory(new PropertyValueFactory<Animals, Double>("weight"));
        cattle.setCellFactory(TextFieldTableCell.forTableColumn());
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.setItems(addCattle());
        tableView.setEditable(true);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY );
        GridPane.setColumnSpan(tableView, GridPane.REMAINING);
        Clock.initClockTime(timeLabel);
    }
}
