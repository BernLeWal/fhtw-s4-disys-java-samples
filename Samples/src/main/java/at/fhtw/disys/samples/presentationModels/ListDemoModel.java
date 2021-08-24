package at.fhtw.disys.samples.presentationModels;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ListDemoModel {
    private StringProperty name = new SimpleStringProperty();
    private FloatProperty age = new SimpleFloatProperty();

    public ListDemoModel() {

    }

    public ListDemoModel(String name, float age) {
        this.name.set(name);
        this.age.set(age);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public float getAge() {
        return age.get();
    }

    public void setAge(float age) {
        this.age.set(age);
    }

    public final StringProperty nameProperty() {
        return name;
    }

    public final FloatProperty ageProperty() {
        return age;
    }
}
