package zeroXessApp.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import zeroXessApp.Classes.ButtonSwitch;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class EduMathSuperController {

    public abstract void initialize(URL url, ResourceBundle resourceBundle);
    public abstract void checkResult();
    public abstract void numbers();
    public abstract void checkMessage();
    public abstract void reset();

    public void goBack (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduMathSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }
}
