package zeroXessApp.JavaFX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import zeroXessApp.Classes.ButtonSwitch;
import zeroXessApp.Classes.Clock;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FAQController implements Initializable {

    public Label timeLabel;
    public ChoiceBox<String> faqChoice;
    public TextArea faqText;

    ObservableList<String> faqList = FXCollections.observableArrayList("Doctor", "Patient", "Order Medicine");

    public void backClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DoctorSample.fxml"));
        ButtonSwitch.switchMenus(event, root);
    }

    public void checkFAQ(){
            if (faqChoice.getValue().equals("Doctor")) {
                if (LoginController.getCurrentUser().matches("Moderator|Tracey|Matt|Carl|Donald|Jack")) {
                    faqText.setText("Q: Does a patient need a medicine prescribed to save the data?" + "\nA: No, you don't have to fill in a medicine for the patient when you save it"
                            + "\n\nQ: Can I choose another medicine to prescribe than the eight which are shown?\n" + "A: At the moment it is not yet implemented for other medicines");
                } else {
                    faqText.setText("The Doctor tab and FAQ is only available for doctors.");
                }
            } else if (faqChoice.getValue().equals("Patient")) {
                faqText.setText("Q: How can I make an appointment with a doctor? \n"
                        + "A: When you open the patient tab there is another button which is called make a appointment. On the top of the next screen you can see" +
                        " the different doctors that you can make an appointment with. In the table you can see the different specializations of the doctors." +
                        " Next you can select a doctor and a date, then if you click the 'Check available appointments' button you can see when the doctor still has time" +
                        " on that specific day. Then select an time and click 'Create!' to finish making the appointment");
            } else if (faqChoice.getValue().equals("Order Medicine")) {
                faqText.setText("Q: How do can I order medicines? \n" +
                        "A: When you select the prescribed medicines or medicine and click 'Order medicine' the request will in the future be automatically send to the apothecary.");
            }
        }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Clock.initClockTime(timeLabel);
        faqChoice.setItems(faqList);
    }
}
