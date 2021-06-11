package zeroXessApp.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import zeroXessApp.Classes.*;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;
import zeroXessApp.Classes.CorrectSum;
import zeroXessApp.ClassObjects.HighScores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EduMathShuffleController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public Label number1;
    public Label number2;
    public Label sign;
    public Label message;
    public Label score;
    public Label timeLabel;
    public Label lives;
    public Label saveScore;

    public TextField result;
    public String outcome;
    public int points = 0;
    public int attempts = 3;
    public int random;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        numbers();
        points();
        lives.setText("Lives: " + attempts);
        Clock.initClockTime(timeLabel);
    }

    public void numbers() {
        random = (int) EduMathNumbers.randomNumbers(0.0, 100.0); sign();
    }

    public void sign() {
        if (random >= 0 && random <= 25) {
            sign.setText("+"); randomNumbers(2.0, 100.0);
        } else if (random >= 26 && random <= 50) {
            sign.setText("-"); randomNumbers(2.0, 100.0);
        } else if (random >= 51 && random <= 75) {
            sign.setText("x"); randomNumbers(2.0, 12.0);
        } else if (random >= 76 && random <= 100) {
            sign.setText("/"); randomNumbers(2.0, 100.0);
        }
    }

    public void randomNumbers(double min, double max) {
        number1.setText("" + (int) EduMathNumbers.randomNumbers(min, max));
        number2.setText("" + (int) EduMathNumbers.randomNumbers(min, max));
        while (EduMathNumbers.checkNumbers(sign.getText(), Integer.parseInt(number1.getText()), Integer.parseInt(number2.getText()))) {
            randomNumbers(2.0, 100.0);
        }
    }

    public void checkResult(ActionEvent event) throws IOException {
        outcome = EduMathCheckResult.checkSign(sign.getText(), Integer.parseInt(number1.getText()), Integer.parseInt(number2.getText()), result.getText());
        saveCorrectSums();
        checkMessage(event);
    }

    public void checkMessage(ActionEvent event) throws IOException {
        message.setText(outcome);
        if (outcome.equals("Excellent!")) {
            message.setTextFill(Color.web("#15d625")); points++; points(); reset();
        } else
            message.setTextFill(Color.web("#862828"));
        if (outcome.equals("Incorrect!")) {
            points(); attempts--; lives(event); reset();
        }
    }

    public void points() {
        if (points == 1) {
            score.setText("You have " + points + " point!");
        } else {
            score.setText("You have " + points + " points!");
        }
    }

    public void lives(ActionEvent event) throws IOException {
        if (attempts != 0) {
            lives.setText("Lives: " + attempts);
        } else {
            addScore(); points = 0;
            resultClick(event);
        }
    }

    public void reset() {
        result.setText("");
        numbers();
    }

    public void saveCorrectSums() {
        if (outcome.equals("Excellent!")) {
            arrays.addCorrectSum(new CorrectSum(number1.getText() + " " + sign.getText() + " " + number2.getText() + " = " + result.getText()));
        }
    }

    public void saveClick(ActionEvent event) throws IOException {
        addScore(); attempts = 3; points = 0;
        resultClick(event);

    }

    public void addScore() {
        arrays.addMathHighScore(new HighScores(points, LoginController.getCurrentUser()));
    }

    public void resultClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduMathResultSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void backClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduMathSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }
}
