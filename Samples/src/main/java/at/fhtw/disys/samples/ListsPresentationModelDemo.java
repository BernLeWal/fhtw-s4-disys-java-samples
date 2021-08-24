package at.fhtw.disys.samples;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ListsPresentationModelDemo is a JavaFX application which demonstrates how to use
 * ListView and TableView and how to fill them with data based on presentation-model classes
 */
public class ListsPresentationModelDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/at/fhtw/disys/samples/ListsPresentationModel.fxml"));
            Scene scene = new Scene(root, 1024, 768);
            scene.getStylesheets().add(getClass().getResource("/at/fhtw/disys/samples/application.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("JavaFX Lists with PresentationModel Demo");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}