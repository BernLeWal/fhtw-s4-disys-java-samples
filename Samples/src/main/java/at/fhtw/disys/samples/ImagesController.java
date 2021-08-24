package at.fhtw.disys.samples;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.IOException;
import java.net.URL;

public class ImagesController extends AbstractController {
    public ScrollPane imageViewPane;
    public ImageView imageView;

    private Image defaultImage;


    @FXML
    public void initialize() {
        defaultImage = new Image(ImagesController.class.getResourceAsStream("/at/fhtw/disys/samples/placeholder.jpg"));

        //
        // ImageView
        //
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        imageView.fitWidthProperty().bind(imageViewPane.widthProperty());
        imageView.fitHeightProperty().bind(imageViewPane.heightProperty());

        imageView.imageProperty().set( defaultImage );
    }

    public void onSetPictureClicked(ActionEvent actionEvent) {
        Image image = new Image(ImagesController.class.getResourceAsStream("/at/fhtw/disys/samples/Roboter.jpg"));
        imageView.imageProperty().set( image );
    }

    public void onOpenFileClicked(ActionEvent actionEvent) {
        FileChooser fd = new FileChooser();
        fd.setTitle("Open File");
        Image image = new Image( fd.showOpenDialog(null).toURI().toString() );
        imageView.imageProperty().set( image );
    }

    public void onOpenUrlClicked(ActionEvent actionEvent) {
        TextInputDialog td = new TextInputDialog( "https://raw.githubusercontent.com/BernLeWal/htl-sew-java/main/src/main/resources/ui/fx/Kinderroboter.png" );
        td.setTitle("Open URL");
        td.setHeaderText("Enter the URL of an image you want to download and display:");
        String url = td.showAndWait().orElse("");
        try {
            Image image = new Image(new URL(url).openConnection().getInputStream());
            imageView.imageProperty().set( image );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
