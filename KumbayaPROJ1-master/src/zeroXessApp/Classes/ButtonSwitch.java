package zeroXessApp.Classes;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ButtonSwitch {
    public static void switchMenus(ActionEvent event, Parent root) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
        stage.show();
        SizeKeeper.keepSize(stage);
    }
}
