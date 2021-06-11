package zeroXessApp.Classes;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;

public class SizeKeeper {

    public static void minAndMax(Stage stage) {
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setMaxWidth(1280);
        stage.setMaxHeight(1024);
    }

    public static void keepSize(Stage stage) {
        final Double[] Height1 = {0.0};
        final Double[] Width1 = {0.0};
        stage.widthProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                Width1[0] = (Double) newSceneWidth;
            }});
        stage.heightProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                Height1[0] = (Double) newSceneHeight;
            }});
        stage.setHeight(Height1[0]);
        stage.setWidth(Width1[0]);
    }
}
