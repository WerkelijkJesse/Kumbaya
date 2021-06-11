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
import javafx.scene.paint.Color;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;
import zeroXessApp.ClassObjects.Contacts;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContactController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    @FXML private TableView<Contacts> tableView;
    @FXML private TableColumn<Contacts, String> userNameColumn;
    @FXML private TableColumn<Contacts, String> adressColumn;
    @FXML private TableColumn<Contacts, Integer> yearOfBirthColumn;
    public TextField userNameTextField;
    public TextField adressTextField;
    public TextField yearOfBirthTextField;
    public Label timeLabel;
    public Label wrongLabel;

    @FXML
    public void changeUserName(TableColumn.CellEditEvent editCell){
        Contacts contactSelected = tableView.getSelectionModel().getSelectedItem();
        contactSelected.setUsername(editCell.getNewValue().toString());
    }

    @FXML
    public void addUser(){
        if ((userNameTextField.getText().equals("") || adressTextField.getText().equals("") || yearOfBirthTextField.getText().equals(""))) {
            wrongLabel.setText("Please fill in every field");
            wrongLabel.setTextFill(Color.web("#862828"));
        }
        else {
            Contacts contact = new Contacts(adressTextField.getText(), Integer.parseInt(yearOfBirthTextField.getText()), userNameTextField.getText(), LoginController.getCurrentUser());
            arrays.addContact(contact);
            tableView.getItems().add(contact);
            wrongLabel.setText("Succesfully added " + userNameTextField.getText());
            wrongLabel.setTextFill(Color.web("#15d625"));
        }
    }

    @FXML
    public void deleteUser(){
        ObservableList<Contacts> select,allContacts;
        allContacts= tableView.getItems();
        select=tableView.getSelectionModel().getSelectedItems();
        for(Contacts contact :select){
            allContacts.remove(contact); }
        for (int i = 0; i< arrays.getContactList().size(); i++) {
            if (tableView.getSelectionModel().getSelectedItem().equals(arrays.getContact(i))) {
                arrays.getContactList().remove(i);} }
        wrongLabel.setText("Succesfully deleted");
    }

    @FXML
    public ObservableList<Contacts> getContacten() {
        ObservableList<Contacts> contacts = FXCollections.observableArrayList();
        for (int i = 0; i< arrays.getContactList().size(); i++) {
            if (arrays.getContact(i).getAddedBy().equals(LoginController.getCurrentUser())) {
            contacts.add(arrays.getContact(i)); } }
        return contacts;
    }

    public void backClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomeSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userNameColumn.setCellValueFactory(new PropertyValueFactory<Contacts, String>("username"));
        adressColumn.setCellValueFactory(new PropertyValueFactory<Contacts, String>("adress"));
        yearOfBirthColumn.setCellValueFactory(new PropertyValueFactory<Contacts, Integer>("yearOfBirth"));
        userNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.setItems(getContacten());
        tableView.setEditable(true);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY );
        GridPane.setColumnSpan(tableView, GridPane.REMAINING);
        Clock.initClockTime(timeLabel);
    }
}