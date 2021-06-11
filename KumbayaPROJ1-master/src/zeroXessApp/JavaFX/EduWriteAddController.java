package zeroXessApp.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EduWriteAddController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public Label timeLabel;
    @FXML public RadioButton easyRadio;
    @FXML public RadioButton mediumRadio;
    @FXML public RadioButton hardRadio;
    public TextArea newSentence;
    public Label addedText;

    public void initialize(URL location, ResourceBundle resources) {
        Clock.initClockTime(timeLabel);
    }

    public void voegToe(){
        if(easyRadio.isSelected()){
            arrays.addEasyWrite(newSentence.getText());
        }
        else if (mediumRadio.isSelected()){
            arrays.addMediumWrite(newSentence.getText());
        }
        else if(hardRadio.isSelected()){
            arrays.addHardWrite(newSentence.getText());
        }
        addedText.setText("Your sentence has been added!");
    }


    public void goBack (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduWriteSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

}
