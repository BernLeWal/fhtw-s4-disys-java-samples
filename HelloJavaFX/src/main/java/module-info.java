module at.fhtw.disys.helloworld {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.fhtw.disys.helloworld to javafx.fxml;
    exports at.fhtw.disys.helloworld;
}