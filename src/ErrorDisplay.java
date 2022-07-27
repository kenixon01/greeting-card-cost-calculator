import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class ErrorDisplay {
    private String text;

    public ErrorDisplay(String text) {
        this.text = text;
    }

    @FXML
    public void display() {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Error");
        error.setContentText(text);
        error.show();
    }
}
