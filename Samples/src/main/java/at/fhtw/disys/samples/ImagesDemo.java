package at.fhtw.disys.samples;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ImagesDemo is a JavaFX application which shows how to
 * work with images and use them in an ImageView.
 */
public class ImagesDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/at/fhtw/disys/samples/Images.fxml"));
            Scene scene = new Scene(root, 1024, 768);
            stage.setScene(scene);
            stage.setTitle("JavaFX Images Demo");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
