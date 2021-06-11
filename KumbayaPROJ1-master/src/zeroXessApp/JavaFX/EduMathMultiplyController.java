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

public class EduMathMultiplyController extends EduMathSuperController implements Initializable {

    private String calculationType = "multiply";

    public Label numberMultiply;
    public Label number2Multiply;
    public TextField resultMultiply;
    public Label messageMultiply;
    public Label timeLabelMultiply;
    public String outcomeMultiply;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        numbers();
    }

    public void numbers() {
        numberMultiply.setText("" + (int) EduMathNumbers.randomNumbers(2.0, 12.0));
        number2Multiply.setText("" + (int) EduMathNumbers.randomNumbers(2.0, 12.0));
        Clock.initClockTime(timeLabelMultiply);
    }

    public void checkResult() {
        outcomeMultiply = EduMathCheckResult.multiply(Integer.parseInt(numberMultiply.getText()), Integer.parseInt(number2Multiply.getText()), resultMultiply.getText());
        checkMessage();
    }

    public void checkMessage() {
        messageMultiply.setText(outcomeMultiply);
        if (outcomeMultiply.equals("Excellent!")) {
            messageMultiply.setTextFill(Color.web("#15d625")); reset();
        } else
            messageMultiply.setTextFill(Color.web("#862828"));
        if (outcomeMultiply.equals("Incorrect!")) {
            reset();
        }
    }

    public void reset() {
        resultMultiply.setText("");
        numbers();
    }

    public String getCalculationType() {
        return calculationType;
    }
}