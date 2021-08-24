package at.fhtw.disys.samples;

import at.fhtw.disys.samples.presentationModels.Person;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.ResourceBundle;

public class ListsController extends AbstractController {
    // the model:
    private Collection<Person> persons = Arrays
            .asList(new Person(1, "Rudi", "Ratlos", 35),
                    new Person(2, "Susi", "Sorglos", 75),
                    new Person(3, "Peter", "Planlos", 32));

    @FXML
    ListView<Person> list;
    @FXML
    TableView<Person> table;

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        super.initialize(url, resources);

        list.setItems(FXCollections.observableArrayList(persons));
        list.setCellFactory(TextFieldListCell.forListView(new StringConverter<>() {
            @Override
            public String toString(Person object) {
                return String.format("%s %s (%d)", object.getVorname(), object.getNachname(), object.getAlter());
            }

            @Override
            public Person fromString(String string) {
                return null;
            }
        }));

        table.setItems(FXCollections.observableArrayList(persons));
    }

    public void onListClicked(Event event) {
        System.out.println(list.getSelectionModel().getSelectedItem());
    }
}
