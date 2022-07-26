import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;

public class Generator {
    @FXML
    private TextField messageTF, colorTF, widthTF, lengthTF;

    @FXML
    private void showResults(ActionEvent actionEvent) {
        Greeting greeting = new Greeting(messageTF.getText());
        Card card = new Card(Integer.parseInt(widthTF.getText()),Integer.parseInt(lengthTF.getText()), colorTF.getText());
        greeting.countChar();

    }
}
