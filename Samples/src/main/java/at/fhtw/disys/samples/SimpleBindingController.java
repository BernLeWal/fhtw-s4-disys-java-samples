package at.fhtw.disys.samples;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import at.fhtw.disys.samples.controls.TitledBorder;
import at.fhtw.disys.samples.presentationModels.LowLevelBindingModel;

import java.net.URL;
import java.util.ResourceBundle;

public class SimpleBindingController extends AbstractController {

    private LowLevelBindingModel model;

    @FXML
    CheckBox check;
    @FXML
    CheckBox checkInverted;
    @FXML
    CheckBox checkVisibility;
    @FXML
    TitledBorder border;

    @FXML
    TextField text;
    @FXML
    TitledBorder borderText;

    @FXML
    TitledBorder borderGreen;
    @FXML
    TitledBorder borderLighter;
    @FXML
    TitledBorder borderDarker;

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        super.initialize(url, resources);

        model = new LowLevelBindingModel();

        applyBindings();
    }

    private void applyBindings() {
        check.selectedProperty().bindBidirectional(model.boolProperty());
        checkInverted.selectedProperty().bind(model.boolInvertedBinding());

        checkVisibility.selectedProperty().bindBidirectional(
                model.boolProperty());

        border.visibleProperty().bind(model.boolToVisibilityBinding());

        text.textProperty().bindBidirectional(model.textProperty());
        borderText.visibleProperty().bind(model.emptyToVisibilityBinding());

        borderGreen.styleProperty().bind(model.styleBinding());
        borderLighter.styleProperty().bind(model.styleLighterBinding());
        borderDarker.styleProperty().bind(model.styleDarkerBinding());
    }
}
