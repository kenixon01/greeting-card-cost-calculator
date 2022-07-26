import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextFlow;

public class Generator {
    @FXML
    private TextField messageTF, widthTF, lengthTF, totalTF, uppercaseTF, lowercaseTF, specialTF,
    digitsTF, sqTF;

    private double upper, lower, special, digits, sqIn;

    @FXML private CheckBox customCB;

    @FXML
    private void showResults(ActionEvent actionEvent) {
        Greeting greeting = new Greeting(
                messageTF.getText(),
                Double.parseDouble(uppercaseTF.getText()),
                Double.parseDouble(lowercaseTF.getText()),
                Double.parseDouble(specialTF.getText()),
                Double.parseDouble(digitsTF.getText()));
        Card card = new Card(
                Integer.parseInt(widthTF.getText()),
                Integer.parseInt(lengthTF.getText()),
                Double.parseDouble(sqTF.getText()));
        greeting.countChar();
        totalTF.setText("$" + Math.round((greeting.total() + card.total()) * 100.0) / 100.0);
    }

    @FXML
    private void customCosts(ActionEvent actionEvent) {
        if(customCB.isSelected()){
            uppercaseTF.setDisable(false);
            lowercaseTF.setDisable(false);
            specialTF.setDisable(false);
            digitsTF.setDisable(false);
            sqTF.setDisable(false);
            sqTF.setEditable(true);

            uppercaseTF.setEditable(true);
            lowercaseTF.setEditable(true);
            digitsTF.setEditable(true);
            specialTF.setEditable(true);
        }
        else {
            uppercaseTF.setDisable(true);
            lowercaseTF.setDisable(true);
            specialTF.setDisable(true);
            digitsTF.setDisable(true);
            sqTF.setDisable(true);

            sqTF.setEditable(false);
            digitsTF.setEditable(false);
            specialTF.setEditable(false);
            lowercaseTF.setEditable(false);
            uppercaseTF.setEditable(false);

            uppercaseTF.setText("0.05");
            lowercaseTF.setText("0.02");
            digitsTF.setText("0.02");
            specialTF.setText("0.03");
            sqTF.setText("0.02");
        }

    }
}
