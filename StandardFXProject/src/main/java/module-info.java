module at.fhtw.disys.standardfxproject.standardfxproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.fhtw.disys.standardfxproject.standardfxproject to javafx.fxml;
    exports at.fhtw.disys.standardfxproject.standardfxproject;
}