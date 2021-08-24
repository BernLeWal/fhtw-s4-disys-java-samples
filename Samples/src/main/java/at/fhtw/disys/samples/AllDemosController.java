package at.fhtw.disys.samples;

import at.fhtw.disys.samples.presentationModels.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class AllDemosController extends AbstractController {

    @FXML
    public void onLayouts() throws IOException {
        showDialog("Layouts.fxml", "Layouts");
    }

    @FXML
    public void onControls() throws IOException {
        showDialog("Controls.fxml", "Controls");
    }

    @FXML
    public void onDataBinding() throws IOException {
        showDialog("DataBinding.fxml", "DataBinding");
    }

    @FXML
    public void onPresentationModel() throws IOException {
        Person model = getPersonModelFromBusinessLayer();
        showDialog("PresentationModel.fxml", model, "PresentationModel");
    }

    private Person getPersonModelFromBusinessLayer() {
        Person result = new Person();
        result.setVorname("Peter");
        result.setNachname("Mayer");
        return result;
    }

    @FXML
    public void onSimpleBinding() throws IOException {
        showDialog("SimpleBinding.fxml", "Simple binding");
    }

    @FXML
    public void onEventHandling() throws IOException {
        showDialog("EventHandling.fxml", "EventHandling");
    }

    @FXML
    public void onLists() throws IOException {
        showDialog("Lists.fxml", "Lists");
    }

    @FXML
    public void onListsPresentationModel() throws IOException {
        showDialog( "ListsPresentationModel.fxml", "Lists with PresentationModel");
    }

    @FXML
    public void onCSS() throws IOException {
        showDialog("CSS.fxml", "CSS");
    }

    @FXML
    public void onImages(ActionEvent actionEvent) throws IOException {
        showDialog( "Images.fxml", "Images");
    }
}
