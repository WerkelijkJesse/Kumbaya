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

public class EduMathDivideController extends EduMathSuperController implements Initializable {

    private String calculationType = "divide";

    public Label numberDivide;
    public Label number2Divide;
    public TextField resultDivide;
    public Label messageDivide;
    public Label timeLabelDivide;
    public String outcomeDivide;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        numbers();
    }

    public void numbers() {
        numberDivide.setText("" + (int) EduMathNumbers.randomNumbers(2.0, 100.0));
        number2Divide.setText("" + (int) EduMathNumbers.randomNumbers(2.0, 100.0));
        if (EduMathNumbers.checkDivide(Integer.parseInt(numberDivide.getText()), Integer.parseInt(number2Divide.getText()))) { numbers(); }
        Clock.initClockTime(timeLabelDivide);
    }

    public void checkResult() {
        outcomeDivide = EduMathCheckResult.divide(Integer.parseInt(numberDivide.getText()), Integer.parseInt(number2Divide.getText()), resultDivide.getText());
        checkMessage();
    }

    public void checkMessage() {
        messageDivide.setText(outcomeDivide);
        if (outcomeDivide.equals("Excellent!")) {
            messageDivide.setTextFill(Color.web("#15d625")); reset();
        } else
            messageDivide.setTextFill(Color.web("#862828"));
        if (outcomeDivide.equals("Incorrect!")) {
            reset();
        }
    }

    public void reset() {
        resultDivide.setText("");
        numbers();
    }

    public String getCalculationType() {
        return calculationType;
    }
}