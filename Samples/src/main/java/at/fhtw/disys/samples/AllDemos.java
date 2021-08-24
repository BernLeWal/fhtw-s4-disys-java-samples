package at.fhtw.disys.samples;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * AllDemos starts a JavaFX application presenting a simple menu to run all the JavaFX samples.
 */
public class AllDemos extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/at/fhtw/disys/samples/AllDemos.fxml"));
            Scene scene = new Scene(root, 400, 400);
            scene.getStylesheets().add(getClass().getResource("/at/fhtw/disys/samples/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("JavaFX Samples");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
