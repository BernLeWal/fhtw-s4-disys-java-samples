package at.fhtw.disys.samples;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ControlsDemo starts a JavaFX application, showing how to put various kinds of simple
 * controls like Text, TextField, ComboBox, CheckBox, RadioButtons and Buttons
 * into a FXML window.
 */
public class ControlsDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/at/fhtw/disys/samples/Controls.fxml"));
            Scene scene = new Scene(root, 1024, 768);
            scene.getStylesheets().add(getClass().getResource("/at/fhtw/disys/samples/application.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("JavaFX Controls Demo");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) { launch(args); }
}
