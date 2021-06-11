package zeroXessApp.Classes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/zeroXessApp/JavaFX/LoginSample.fxml"));
        Image icon = new Image(getClass().getResourceAsStream("/zeroXessApp/Pictures/KumbayaIcon.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Kumba zeroXess");
        stage.setScene(new Scene(root, 800, 600));
        SizeKeeper.minAndMax(stage);
        SizeKeeper.keepSize(stage);
        stage.show();
    }

    public static void main(String[] args) {
        arrays.addAll();
        launch(args);
    }
}

