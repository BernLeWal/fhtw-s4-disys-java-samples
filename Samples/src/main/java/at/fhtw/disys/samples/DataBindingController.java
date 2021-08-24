package at.fhtw.disys.samples;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * DataBindingDemo shows how to use data-binding in JavaFX & fxml:
 *
 * A StringProperty is generated who stores a text value,
 * which is bidirectional bound to a TextField (to be modified)
 * and unidirectional bound to a Label via fxml.
 */
public class DataBindingController extends AbstractController {
    private StringProperty text = new SimpleStringProperty("Hello World from Controller");

    public final String getText() {
        return text.get();
    }

    public final void setText(String value) {
        text.set(value);
    }

    public final StringProperty textProperty() {
        return text;
    }

    @FXML
    private TextField ctrlTextField;

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        super.initialize(url, resources);

        // http://stackoverflow.com/questions/19936719/how-to-do-binding-in-fxml-in-javafx-2
        ctrlTextField.textProperty().bindBidirectional(this.textProperty());
    }
}
