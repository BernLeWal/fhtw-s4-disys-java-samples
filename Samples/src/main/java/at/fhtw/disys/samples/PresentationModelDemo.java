package at.fhtw.disys.samples;

import at.fhtw.disys.samples.presentationModels.Person;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * PresentationModelDemo is a JavaFX-application which shows how the presentation-model pattern
 * is used in a user-interface.
 *
 * The model (here an instance of a Person class) is primarily stored in the Controller-class
 * which adds the references to the presentation-models.
 * The user-interface only works with the presentation-models,
 * so the model itself is indirectly accessed.
 * The presentation-model manages the validation and data flow.
 */
public class PresentationModelDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            // Remarks: to use user-defined base-classes (AbstractController) with the FXML-files it is necessary to create an instance of the FXMLLoader in
            // order to be able to load the class of user-defined controls implemented as plain java-classes.
            FXMLLoader fl = new FXMLLoader();
            fl.setLocation(getClass().getResource("/at/fhtw/disys/samples/PresentationModel.fxml"));
            fl.load();
            Parent root = fl.getRoot();

            Scene scene = new Scene(root, 1024, 768);
            scene.getStylesheets().add(getClass().getResource("/at/fhtw/disys/samples/application.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("JavaFX PresentationModel Demo");

            // assign the model
            AbstractController controller = fl.getController();
            controller.setStage(stage);
            controller.setModel(getPersonModelFromBusinessLayer());

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Person getPersonModelFromBusinessLayer() {
        Person result = new Person();
        result.setVorname("Peter");
        result.setNachname("Mayer");
        return result;
    }

    public static void main(String[] args) {
        launch(args);
    }
}