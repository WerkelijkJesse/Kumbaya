package zeroXessApp.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;

import java.io.IOException;

public class MarktController {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public TextField bidPrice;
    public ChoiceBox chooseAnimal;
    public Label succesLabel;
    public Label timeLabel;
    public Label failLabel;

    public void initialize() {
        for (int i = 0; i< arrays.getCattleList().size(); i++) {
            chooseAnimal.getItems().addAll(arrays.getCattle(i).getName());
        }
        Clock.initClockTime(timeLabel);
    }

    public void goBack (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MarktMain.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void addButton(ActionEvent event) {
        failLabel.setText("");
        succesLabel.setText("");
        if (Integer.parseInt(bidPrice.getText()) >= 1) {
            for (int i = 0; i < arrays.getCattleList().size(); i++) {
                if (arrays.getCattle(i).getName().equals(chooseAnimal.getValue().toString())) {
                    arrays.addToMarket(arrays.getCattle(i));
                    arrays.getCattle(i).setPrice(Integer.parseInt(bidPrice.getText()));
                    succesLabel.setText("Succesful");
                }
            }
        }
        else {
            failLabel.setText("Minimum price is €1,-");
        }
    }
}
