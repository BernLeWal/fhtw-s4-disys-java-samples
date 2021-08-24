module at.fhtw.disys.samples {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.fhtw.disys.samples to javafx.fxml;
    exports at.fhtw.disys.samples;
    exports at.fhtw.disys.samples.presentationModels;
    exports at.fhtw.disys.samples.controls;
}