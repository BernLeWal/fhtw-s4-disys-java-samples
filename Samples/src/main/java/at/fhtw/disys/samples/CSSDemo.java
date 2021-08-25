package at.fhtw.disys.samples;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * CSSDemo is a JavaFX application showing how to use cascading-style-sheets (CSS) in your user-interface.
 * It also demonstrates how an user-defined control is used in the FXML.
 */
public class CSSDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/at/fhtw/disys/samples/CSS.fxml"));
            Scene scene = new Scene(root, 1024, 768);
            scene.getStylesheets().add(getClass().getResource("/at/fhtw/disys/samples/application.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("JavaFX CSS Demo");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) { launch(args); }
}