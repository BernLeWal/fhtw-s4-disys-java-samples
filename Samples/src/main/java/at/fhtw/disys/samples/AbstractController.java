package at.fhtw.disys.samples;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class AbstractController implements Initializable {
	private Stage stage;

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage temp) {
		stage = temp;
	}

	@Override
	public void initialize(URL url, ResourceBundle resources) {
	}

	private void show(String resource, Object model, String title, Modality m, 
			String... cssList) throws IOException {
		FXMLLoader fl = new FXMLLoader();
		fl.setLocation(getClass().getResource("/at/fhtw/disys/samples/" + resource));
		fl.load();
		Parent root = fl.getRoot();

		Stage newStage = new Stage(StageStyle.DECORATED);
		newStage.initModality(m);
		newStage.initOwner(stage);
		Scene scene = new Scene(root, 1024, 768);
		scene.getStylesheets().add(
				getClass().getResource("/at/fhtw/disys/samples/application.css").toExternalForm());
		// more css by code
		for (String css : cssList) {
			scene.getStylesheets().add(
					getClass().getResource(css).toExternalForm());
		}

		AbstractController controller = fl.getController();
		controller.setStage(newStage);
		controller.setModel(model);
		newStage.setScene(scene);
		newStage.setTitle(title);
		newStage.show();
	}

	public void show(String resource, Object model, String title, String... cssList) throws IOException {
		show(resource, model, title, Modality.NONE, cssList);
	}

	public void showDialog(String resource, Object model, String title, String... cssList) throws IOException {
		show(resource, model, title, Modality.WINDOW_MODAL, cssList);
	}

	public void show(String resource, String title, String... cssList) throws IOException {
		show(resource, null, title, Modality.NONE, cssList);
	}

	public void showDialog(String resource, String title, String... cssList) throws IOException {
		show(resource, null, title, Modality.WINDOW_MODAL, cssList);
	}

	public void setModel(Object model) {
		// optional set model in derived classes
	}
}
