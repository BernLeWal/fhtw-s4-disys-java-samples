module at.fhtw.disys.hellorest.hellorest {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires java.net.http;


    opens at.fhtw.disys.hellorest to javafx.fxml;
    exports at.fhtw.disys.hellorest;
}