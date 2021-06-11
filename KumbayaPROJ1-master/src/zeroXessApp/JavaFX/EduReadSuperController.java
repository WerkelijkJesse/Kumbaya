package zeroXessApp.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import zeroXessApp.Classes.ButtonSwitch;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public abstract class EduReadSuperController {
    public abstract void initialize(URL location, ResourceBundle resources);

    Random random = new Random();
    int current = 0;

    public abstract int getCurrent();
    public abstract void question();
    public abstract void setRandom();
    public abstract void checkAnswer1();
    public abstract void checkAnswer2();
    public abstract void checkAnswer3();
    public abstract void checkAnswer4();
    public abstract void rightAnswer();
    public abstract void wrongAnswer();
    public abstract void reset();

    public void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduReadSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void next(){
        setRandom();
        reset();
        question();
    }
}

