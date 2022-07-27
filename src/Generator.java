import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Generator {
    @FXML
    private TextField messageTF, widthTF, lengthTF, totalTF, uppercaseTF, lowercaseTF, specialTF,
    digitsTF, sqTF;

    @FXML
    private TextArea characterTA, countTA, costTA;

    @FXML private CheckBox customCB;
    private Greeting greeting;
    private Card card;

    @FXML
    private void showResults(ActionEvent actionEvent) {
        try {
            greeting = new Greeting(
                    messageTF.getText(),
                    Double.parseDouble(uppercaseTF.getText()),
                    Double.parseDouble(lowercaseTF.getText()),
                    Double.parseDouble(specialTF.getText()),
                    Double.parseDouble(digitsTF.getText()));
            card = new Card(
                    Double.parseDouble(widthTF.getText()),
                    Double.parseDouble(lengthTF.getText()),
                    Double.parseDouble(sqTF.getText()));

            greeting.countChar();
            double total = Math.round((greeting.total() + card.total()) * 100.0) / 100.0;

            StringBuilder ch = new StringBuilder(),
                    num = new StringBuilder(),
                    cost = new StringBuilder();
            Iterator<Map.Entry<Character, Integer>> iterator = greeting.iterator();
            while(iterator.hasNext()) {
                Map.Entry<Character, Integer> next = iterator.next();
                char letter = next.getKey();
                int count = next.getValue();
                ch.append(letter).append("\n");
                num.append(count).append("\n");
                cost.append("$").append(greeting.letterCost(letter, count)).append("\n");
            }

            totalTF.setText("$" + total);
            characterTA.setText(ch.toString());
            costTA.setText(cost.toString());
            countTA.setText(num.toString());
        } catch (InvalidInputException e) {
            ErrorDisplay error = new ErrorDisplay(e.getMessage());
            error.display();
        }
    }

    private void fileOpen() {

    }

    private void fileSave() {
    }

    private void fileClose() {
        Platform.exit();
    }

    private void fileClear() {
        messageTF.clear();
        widthTF.clear();
        lengthTF.clear();
        if(customCB.isSelected()) {
            uppercaseTF.clear();
            lowercaseTF.clear();
            specialTF.clear();
            digitsTF.clear();
            sqTF.clear();
            characterTA.clear();
            countTA.clear();
            costTA.clear();
        }
    }

    private void helpAbout() {
        Alert help = new Alert(Alert.AlertType.INFORMATION);
        help.setTitle("About");
        String content = "The Greeting Card Cost Calculator allows users to determine the cost of a greeting cost" +
                "based on the price per character and size of the card.";
        help.setContentText(content);
        help.show();
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
