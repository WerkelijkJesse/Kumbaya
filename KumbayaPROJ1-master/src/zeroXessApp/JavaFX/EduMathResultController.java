package zeroXessApp.JavaFX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.CorrectSum;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EduMathResultController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    @FXML private TableView<CorrectSum> tableView;
    @FXML private TableColumn<CorrectSum, String> correctSum;

    @FXML
    public ObservableList<CorrectSum> getCorrectSums() {
        ObservableList<CorrectSum> sums = FXCollections.observableArrayList();
        for (int i = 0; i < arrays.getCorrectSumsList().size(); i++) {
            sums.add(arrays.getCorrectSum(i)); }
        return sums;
    }

    @FXML
    public void initialize (URL url, ResourceBundle resourceBundle) {
        correctSum.setCellValueFactory(new PropertyValueFactory<CorrectSum, String>("correctSum"));
        correctSum.setCellFactory(TextFieldTableCell.forTableColumn());
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.setItems(getCorrectSums());
        tableView.setEditable(true);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY );
    }

    public void backClick (ActionEvent event) throws IOException {
        arrays.getCorrectSumsList().clear();
        Parent root = FXMLLoader.load(getClass().getResource("EduMathSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }
}
