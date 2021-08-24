module at.fhtw.disys.standardfxproject.standardfxproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.fhtw.disys.firstfxproject.firstfxproject to javafx.fxml;
    exports at.fhtw.disys.firstfxproject.firstfxproject;
}