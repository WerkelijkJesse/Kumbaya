package zeroXessApp.JavaFX;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;


public class ReadAndPickController implements Initializable {

    public static final ArrayLists arrays = ArrayLists.getOnlyInstance();
    public Label timeLabel;
    public Image png;
    public ImageView imageView;
    public ImageView imageView2;
    public ImageView imageView3;
    public ImageView imageView4;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Label right;
    public Label wrong;
    public Label question;
    public String answer;
    public Label score;
    Integer realscore = 0;

    public void backClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduReadSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }


    public void initialize(URL location, ResourceBundle resources) {
        Collections.shuffle(arrays.getReadAndPicksList());
        imageLoader();
        valueLoader();
        setAnswer();
        setQuestion();
        Clock.initClockTime(timeLabel);
        scoreLoader();
    }

    public void next(ActionEvent event) {
        reset();
        Collections.shuffle(arrays.getReadAndPicksList());
        setAnswer();
        setQuestion();
        imageLoader();
        valueLoader();
        scoreLoader();
        alertStart(event);
    }

    public String toString() {
        return "Your current score is: " + realscore;
    }

    public void scoreLoader() {
        score.setText(toString());
    }

    public void imageLoader() {
        imageView.setImage(arrays.getReadAndPick(0).getPng());
        imageView2.setImage(arrays.getReadAndPick(1).getPng());
        imageView3.setImage(arrays.getReadAndPick(2).getPng());
        imageView4.setImage(arrays.getReadAndPick(3).getPng());
    }

    public void valueLoader() {
        button1.setText(arrays.getReadAndPick(0).getNameImage());
        button2.setText(arrays.getReadAndPick(1).getNameImage());
        button3.setText(arrays.getReadAndPick(2).getNameImage());
        button4.setText(arrays.getReadAndPick(3).getNameImage());
    }

    public void setQuestion() {
        question.setText(answer);
    }

    public void setAnswer() {
        this.answer = arrays.getReadAndPick((int) Math.floor(Math.random() * 4)).getNameImage();
    }

    public boolean checkAnswer(String antwoord) {
        boolean correct = false;

        if (antwoord.equalsIgnoreCase(question.getText())) {
            realscore++;
            correct = true;
        }

        return correct;
    }

    public void checkAnswer1(ActionEvent event) {
        answerCall(event, button1.getText());
    }

    public void checkAnswer2(ActionEvent event) {
        answerCall(event, button2.getText());
    }
    public void checkAnswer3(ActionEvent event) {
        answerCall(event, button3.getText());
    }
    public void checkAnswer4(ActionEvent event) {
        answerCall(event, button4.getText());
    }

    public void answerCall(ActionEvent event, String answer) {
        if (checkAnswer(answer)) {
            rightPicture();
            next(event);
        } else {
            wrongPicture();
        }
    }



    public void rightPicture() {
        reset();
        right.setText("That's a correct picture!");
    }

    public void wrongPicture() {
        reset();
        wrong.setText("That's a wrong picture.");
    }

    public void reset() {
        wrong.setText("");
        right.setText("");
    }

    public void setAlert(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("Congratulations, you have 10 correct answers!");
        alert.setContentText("Press 'Go back' to return to the main menu");

        ButtonType buttonTypeOne = new ButtonType("Go back");
        alert.getButtonTypes().setAll(buttonTypeOne);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            try {
                backClick(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void alertStart(ActionEvent event) {
        if (realscore == 10) {
            setAlert(event);
        }
    }
}

