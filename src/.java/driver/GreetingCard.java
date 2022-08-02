import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GreetingCard extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = FXMLLoader.load(getClass().getResource("GreetingCard.fxml"));
        Scene root = new Scene(pane, 1280, 800);
        stage.setTitle("Greeting Card Cost Calculator");
        stage.setScene(root);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
