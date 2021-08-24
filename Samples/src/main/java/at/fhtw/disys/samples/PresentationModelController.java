package at.fhtw.disys.samples;

import at.fhtw.disys.samples.presentationModels.PersonModel;
import at.fhtw.disys.samples.presentationModels.Person;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PresentationModelController extends AbstractController {
    @FXML
    private TextField vorname;
    @FXML
    private TextField nachname;
    @FXML
    private TextField firmenname;
    @FXML
    private TextField UID;
    @FXML
    private CheckBox isFirma;
    @FXML
    private CheckBox disableEditPerson;
    @FXML
    private CheckBox disableEditFirma;
    @FXML
    private TitledPane personPane;
    @FXML
    private TitledPane firmaPane;

    private PersonModel presentationModel;
    private Person model;

    @Override
    public void setModel(Object model) {
        this.model = (Person) model;
        this.presentationModel.setModel(this.model);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.presentationModel = new PersonModel();
        applyBindings();
    }

    private void applyBindings() {
        vorname.textProperty().bindBidirectional(presentationModel.vornameProperty());
        nachname.textProperty().bindBidirectional(presentationModel.nachnameProperty());
        firmenname.textProperty().bindBidirectional(presentationModel.firmennameProperty());
        UID.textProperty().bindBidirectional(presentationModel.UIDProperty());

        isFirma.selectedProperty().bind(presentationModel.isFirmaBinding());
        disableEditPerson.selectedProperty().bind(
                presentationModel.disableEditPersonBinding());
        disableEditFirma.selectedProperty().bind(
                presentationModel.disableEditFirmaBinding());

        personPane.disableProperty().bind(
                presentationModel.disableEditPersonBinding());
        firmaPane.disableProperty().bind(
                presentationModel.disableEditFirmaBinding());
    }
}
