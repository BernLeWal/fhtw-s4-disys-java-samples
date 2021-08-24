package at.fhtw.disys.samples.presentationModels;

import at.fhtw.disys.utils.StringUtils;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class PersonModel {

    private StringProperty vorname = new SimpleStringProperty();
    private StringProperty nachname = new SimpleStringProperty();
    private StringProperty firmenname = new SimpleStringProperty();
    private StringProperty UID = new SimpleStringProperty();

    private BooleanBinding isFirma = new BooleanBinding() {
        @Override
        protected boolean computeValue() {
            return !StringUtils.isNullOrEmpty(getFirmenname());
        }
    };

    private BooleanBinding disableEditPerson = new BooleanBinding() {
        @Override
        protected boolean computeValue() {
            return !StringUtils.isNullOrEmpty(getFirmenname())
                    && StringUtils.isNullOrEmpty(getVorname())
                    && StringUtils.isNullOrEmpty(getNachname());
        }
    };

    private BooleanBinding disableEditFirma = new BooleanBinding() {
        @Override
        protected boolean computeValue() {
            return StringUtils.isNullOrEmpty(getFirmenname())
                    && (!StringUtils.isNullOrEmpty(getVorname()) || !StringUtils
                    .isNullOrEmpty(getNachname()));
        }
    };

    public PersonModel() {
        ChangeListener<String> canEditListener = new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                isFirma.invalidate();
                disableEditPerson.invalidate();
                disableEditFirma.invalidate();
            }
        };
        vorname.addListener(canEditListener);
        nachname.addListener(canEditListener);
        firmenname.addListener(canEditListener);
    }

    public void setModel(Person model) {
        this.vorname.set(model.getVorname());
        this.nachname.set(model.getNachname());
    }

    public void updateModel(Person model) {
        model.setVorname(this.vorname.get());
        model.setNachname(this.nachname.get());
    }

    public final StringProperty vornameProperty() {
        return vorname;
    }

    public final StringProperty nachnameProperty() {
        return nachname;
    }

    public final StringProperty firmennameProperty() {
        return firmenname;
    }

    public final StringProperty UIDProperty() {
        return UID;
    }

    public final BooleanBinding isFirmaBinding() {
        return isFirma;
    }

    public BooleanBinding disableEditPersonBinding() {
        return disableEditPerson;
    }

    public BooleanBinding disableEditFirmaBinding() {
        return disableEditFirma;
    }

    public String getVorname() {
        return vorname.get();
    }

    public void setVorname(String vorname) {
        this.vorname.set(vorname);
    }

    public String getNachname() {
        return nachname.get();
    }

    public void setNachname(String nachname) {
        this.nachname.set(nachname);
    }

    public String getFirmenname() {
        return firmenname.get();
    }

    public void setFirmenname(String firmenname) {
        this.firmenname.set(firmenname);
    }

    public String getUID() {
        return UID.get();
    }

    public void setUID(String uID) {
        UID.set(uID);
    }

    public boolean isFirma() {
        return isFirma.get();
    }

    public boolean disableEditPerson() {
        return disableEditPerson.get();
    }

    public boolean disableEditFirma() {
        return disableEditFirma.get();
    }
}
