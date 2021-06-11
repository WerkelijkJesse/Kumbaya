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

public class EduMathMinusController extends EduMathSuperController implements Initializable {

    private String calculationType = "minus";

    public Label numberMinus;
    public Label number2Minus;
    public TextField resultMinus;
    public Label messageMinus;
    public Label timeLabelMinus;
    public String outcomeMinus;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        numbers();
    }

    public void numbers() {
        numberMinus.setText("" + (int) EduMathNumbers.randomNumbers(2.0, 100.0));
        number2Minus.setText("" + (int) EduMathNumbers.randomNumbers(2.0, 100.0));
        if (EduMathNumbers.checkMinus(Integer.parseInt(numberMinus.getText()), Integer.parseInt(number2Minus.getText()))) { numbers(); }
        Clock.initClockTime(timeLabelMinus);
    }

    public void checkResult() {
        outcomeMinus = EduMathCheckResult.minus(Integer.parseInt(numberMinus.getText()), Integer.parseInt(number2Minus.getText()), resultMinus.getText());
        checkMessage();
    }

    public void checkMessage() {
        messageMinus.setText(outcomeMinus);
        if (outcomeMinus.equals("Excellent!")) {
            messageMinus.setTextFill(Color.web("#15d625")); reset();
        } else
            messageMinus.setTextFill(Color.web("#862828"));
        if (outcomeMinus.equals("Incorrect!")) {
            reset();
        }
    }

    public void reset() {
        resultMinus.setText("");
        numbers();
    }

    public String getCalculationType() {
        return calculationType;
    }
}