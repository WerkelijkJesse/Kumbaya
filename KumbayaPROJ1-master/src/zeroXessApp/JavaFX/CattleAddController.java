package zeroXessApp.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;
import zeroXessApp.ClassObjects.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CattleAddController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public TextField name;
    public TextField gender;
    public TextField color;
    public TextField price;
    public TextField weight;
    public ChoiceBox choiceBox;
    public Label choiceBoxLabel;
    public Label timeLabel;
    public Label succesLabel;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setValue("Cattle");
        choiceBox.getItems().addAll("Cow", "Goat", "Pig", "Sheep");
        Clock.initClockTime(timeLabel);
    }

    public String getCattle() {
        return choiceBox.getValue().toString();
    }

    public String getName() {
        return name.getText();
    }

    public String getGender() {
        return gender.getText();
    }

    public String getColor() {
        return color.getText();
    }

    public int getPrice() {
        return Integer.parseInt(price.getText());
    }

    public double getWeight() {
        return Double.parseDouble(weight.getText());
    }

    public void backClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CattleSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void addCattleClick(ActionEvent event) {
        if (getCattle().equals("Cow")) {
            Animals animal = new Cow(getCattle(), getName(), getGender(), getColor(), getWeight(), LoginController.getCurrentUser());
            arrays.addCattle(animal);
        } else if (getCattle().equals("Goat")) {
            Animals animal = new Goat(getCattle(), getName(), getGender(), getColor(), getWeight(), LoginController.getCurrentUser());
            arrays.addCattle(animal);
        } else if (getCattle().equals("Pig")) {
            Animals animal = new Pig(getCattle(), getName(), getGender(), getColor(), getWeight(), LoginController.getCurrentUser());
            arrays.addCattle(animal);
        } else if (getCattle().equals("Sheep")) {
            Animals animal = new Sheep(getCattle(), getName(), getGender(), getColor(), getWeight(), LoginController.getCurrentUser());
            arrays.addCattle(animal); }
        succesLabel.setText("Animal succesfully added.");
    }

}
