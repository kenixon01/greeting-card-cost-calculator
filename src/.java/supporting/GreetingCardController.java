import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Iterator;
import java.util.Map;
import java.sql.*;

/**
 * The {@code GeneratorController} class will function as the controller for {@code GreetingCard.fxml}.  It will
 * provide the fxml application with user interactivity and store user data into a database for further analysis.
 * @author Khamilah Nixon
 */
public class GreetingCardController {
    @FXML
    private TextField messageTF, widthTF, lengthTF, totalTF, uppercaseTF, lowercaseTF, specialTF,
    digitsTF, sqTF;

    @FXML
    private TextArea characterTA, countTA, costTA;

    @FXML private CheckBox customCB;
    private Greeting greeting;
    private Card card;

    private void checkTF() throws InvalidInputException {
        if(uppercaseTF.getText().isBlank() ||lowercaseTF.getText().isBlank() || specialTF.getText().isBlank() ||
                digitsTF.getText().isBlank() || digitsTF.getText().isBlank()) {
            throw new InvalidInputException("The paper cost and cost per character values must have a value.");
        }
    }

    /**
     * This method will display the results of the greeting card price compilation to the user via the {@code totalTF}.
     * Each total is determined from the sum of the card total and greeting total based on the cost per character.
     * If any of the text fields do not meet the designated criteria, {@code display()} from the {@code Error} class
     * will be called and will generate an error dialog box.
     */
    @FXML
    private void showResults() {
        try {
            checkTF();
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

    /**
     * This method will allow the user to save the data in the text fields into a database
     */
    @FXML
    private void fileSave() {
        try {
            Database database = new Database();
            int upper = 0, lower = 0, special = 0, digits = 0;
            Iterator<Map.Entry<Character, Integer>> iterator = greeting.iterator();
            while(iterator.hasNext()) {
                Map.Entry<Character, Integer> next = iterator.next();
                char letter = next.getKey();
                if(Character.isUpperCase(letter)) {
                    upper++;
                }
                else if(Character.isLowerCase(letter)) {
                    lower++;
                }
                else if(Character.isDigit(letter)) {
                    digits++;
                }
                else {
                    special++;
                }
            }
            double width = Double.parseDouble(widthTF.getText());
            double length = Double.parseDouble(lengthTF.getText());
            double total = Double.parseDouble(totalTF.getText().replace("$",""));

            database.cardInsert(width, length);
            database.greetingInsert(messageTF.getText(),upper, lower, special, digits);
            database.costInsert(messageTF.getText(),width, length, total);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void fileClose() {
        Platform.exit();
    }

    /**
     * This method will reset the text fields
     */
    @FXML
    private void fileReset() {
        messageTF.setText("");
        widthTF.setText("");
        lengthTF.setText("");
        totalTF.setText("");
        if(customCB.isSelected()) {
            uppercaseTF.setText("0.05");
            lowercaseTF.setText("0.02");
            digitsTF.setText("0.02");
            specialTF.setText("0.03");
            sqTF.setText("0.02");
            characterTA.setText("");
            countTA.setText("");
            costTA.setText("");
            customCB.setSelected(false);
        }
    }

    @FXML
    private void helpAbout() {
        Alert help = new Alert(Alert.AlertType.INFORMATION);
        help.setTitle("About");
        String content = "The Greeting Card Cost Calculator allows users to determine the cost of a greeting card " +
                "based on the price per character and size of the card.";
        help.setContentText(content);
        help.show();
    }

    /**
     * This method will allow the user to enter custom costs per character and sq in. of paper
     */
    @FXML
    private void customCosts() {
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
