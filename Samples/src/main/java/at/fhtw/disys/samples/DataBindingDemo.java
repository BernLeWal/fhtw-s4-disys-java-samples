package at.fhtw.disys.samples;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * DataBindingDemo is a JavaFX application that shows how to use data-binding in fxml.
 * A StringProperty is generated who stores a text value,
 * which is bidirectional bound to a TextField (to be modified)
 * and unidirectional bound to a Label via fxml.
 */
public class DataBindingDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            // Remarks: to use user-defined controls in the FXML-files it is necessary to create an instance of the FXMLLoader in
            // order to be able to load the class of user-defined controls implemented as plain java-classes.
            FXMLLoader fl = new FXMLLoader();
            fl.setLocation(getClass().getResource("/at/fhtw/disys/samples/DataBinding.fxml"));
            fl.load();
            Parent root = fl.getRoot();

            Scene scene = new Scene(root, 1024, 768);
            scene.getStylesheets().add(getClass().getResource("/at/fhtw/disys/samples/application.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("JavaFX DataBinding Demo");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}