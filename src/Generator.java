import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;

public class Generator {
    @FXML
    private TextField messageTF, colorTF;
    @FXML
    private Label resultsLabel;

    @FXML
    private void showResults(ActionEvent actionEvent) {
        Greeting greeting = new Greeting(messageTF.getText());
        resultsLabel.setText(greeting.getGREETING());

    }
}
