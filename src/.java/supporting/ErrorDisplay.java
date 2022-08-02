import javafx.fxml.FXML;
import javafx.scene.control.Alert;

/**
 * This class will generate alert dialog boxes in JavaFXML based on a specific string input
 * @author Khamilah Nixon
 */
public class ErrorDisplay {
    private String text;

    public ErrorDisplay(String text) {
        this.text = text;
    }

    /**
     * This method will create an alert dialog box
     */
    @FXML
    public void display() {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Error");
        error.setContentText(text);
        error.show();
    }
}
