package zeroXessApp.JavaFX;

import javafx.animation.KeyFrame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import javafx.animation.*;
import zeroXessApp.Classes.ArrayLists;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class EduWriteWordsController implements Initializable {

    private static final ArrayLists arrays = ArrayLists.getOnlyInstance();

    public Label timeLabel;
    public TextField textAnswer;
    public Label wordLabel;
    public ListView<String> listView;
    public Button startButton;
    public ObservableList<String> words = FXCollections.observableArrayList();
    private int index = 0;
    private int mistakes = 3;


    public void run() throws InterruptedException {
        KeyFrame frame1 = new KeyFrame(Duration.seconds(0), new KeyValue(wordLabel.textProperty(), arrays.getWriteWords(0)));
        KeyFrame frame2 = new KeyFrame(Duration.seconds(2), new KeyValue(wordLabel.textProperty(), arrays.getWriteWords(1)));
        KeyFrame frame3 = new KeyFrame(Duration.seconds(4), new KeyValue(wordLabel.textProperty(), arrays.getWriteWords(2)));
        KeyFrame frame4 = new KeyFrame(Duration.seconds(6), new KeyValue(wordLabel.textProperty(), arrays.getWriteWords(3)));
        KeyFrame frame5 = new KeyFrame(Duration.seconds(8), new KeyValue(wordLabel.textProperty(), arrays.getWriteWords(4)));
        KeyFrame frame6 = new KeyFrame(Duration.seconds(10), new KeyValue(wordLabel.textProperty(), arrays.getWriteWords(5)));
        KeyFrame frame7 = new KeyFrame(Duration.seconds(12), new KeyValue(wordLabel.textProperty(), arrays.getWriteWords(6)));
        KeyFrame frame8 = new KeyFrame(Duration.seconds(14), new KeyValue(wordLabel.textProperty(), arrays.getWriteWords(7)));
        KeyFrame frame9 = new KeyFrame(Duration.seconds(16), new KeyValue(wordLabel.textProperty(), arrays.getWriteWords(8)));
        KeyFrame frame10 = new KeyFrame(Duration.seconds(18), new KeyValue(wordLabel.textProperty(), arrays.getWriteWords(9)));
        KeyFrame frame11 = new KeyFrame(Duration.seconds(20), new KeyValue(wordLabel.textProperty(), ""));
        Timeline animation = new Timeline(frame1, frame2, frame3, frame4, frame5, frame6, frame7, frame8, frame9, frame10,frame11);
        animation.play();
    }

    public void answerCheck(){
        if(arrays.getWriteWordsList().contains(textAnswer.getText() )&& !textAnswer.getText().equals("") && !listView.getItems().contains(textAnswer.getText())){
            listView.setItems(words);
            words.add(textAnswer.getText());
            wordLabel.setText(correctCheck());
        }
        else{
            wordLabel.setText(mistakeCheck());
        }
        textAnswer.setText("");
    }

    public int getCurrentScore(){
        return index;
    }

    public String correctCheck(){
        index++;
        if(index >= 10){
            return "You did it! You remembered all of the animals!!";
        }
        else{
            return "Correct! You have "+ index+ " out of 10 correct answers!";
        }

    }

    public String mistakeCheck(){
        mistakes--;
        if(mistakes <= 0){
            return "You failed! Try again?";
        }
        else if(mistakes == 1){
            return "Wrong! You have "+ mistakes+" try left.";
        }
        else{
            return "Wrong! You have "+ mistakes+" tries left.";
        }
    }




    public void backClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EduWriteSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        wordLabel.setText("Try to memorize all of the animals! You have 3 tries, click Start when you want to begin!");
        Clock.initClockTime(timeLabel);
    }
}
