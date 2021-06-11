package zeroXessApp.JavaFX;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import zeroXessApp.Classes.Clock;
import zeroXessApp.Classes.EduMathCheckResult;
import zeroXessApp.Classes.EduMathNumbers;

import java.net.URL;
import java.util.ResourceBundle;

public class EduMathPlusController extends EduMathSuperController implements Initializable {

    private String calculationType = "plus";

    public Label numberPlus;
    public Label number2Plus;
    public TextField resultPlus;
    public Label messagePlus;
    public Label timeLabelPlus;
    public String outcomePlus;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        numbers();
    }

    public void numbers() {
        numberPlus.setText("" + (int) EduMathNumbers.randomNumbers(2.0, 100.0));
        number2Plus.setText("" + (int) EduMathNumbers.randomNumbers(2.0, 100.0));
        Clock.initClockTime(timeLabelPlus);
    }

    public void checkResult() {
        outcomePlus = EduMathCheckResult.plus(Integer.parseInt(numberPlus.getText()), Integer.parseInt(number2Plus.getText()), resultPlus.getText());
        checkMessage();
    }

    public void checkMessage() {
        messagePlus.setText(outcomePlus);
        if (outcomePlus.equals("Excellent!")) {
            messagePlus.setTextFill(Color.web("#15d625")); reset();
        } else
            messagePlus.setTextFill(Color.web("#862828"));
            if (outcomePlus.equals("Incorrect!")) {
                reset();
            }
    }

    public void reset() {
        resultPlus.setText("");
        numbers();
    }

    public String getCalculationType() {
        return calculationType;
    }
}