package at.fhtw.disys.samples.presentationModels;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;
import at.fhtw.disys.utils.StringUtils;

public class LowLevelBindingModel {

    public LowLevelBindingModel() {
        // Listener mit Lambda
        bool.addListener((o, oldVal, newVal) -> {
            boolInverted.invalidate();
            boolToVisibility.invalidate();
        });

        // Listener mit anonymer implementierung eines Interfaces
        text.addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                emptyToVisibility.invalidate();
            }
        });
    }

    private BooleanProperty bool = new SimpleBooleanProperty();
    private StringProperty text = new SimpleStringProperty();
    private BooleanBinding boolInverted = new BooleanBinding() {
        @Override
        protected boolean computeValue() {
            return !bool.get();
        }
    };

    private BooleanBinding boolToVisibility = new BooleanBinding() {
        @Override
        protected boolean computeValue() {
            // Make many other decisions here
            return bool.get();
        }
    };

    private BooleanBinding emptyToVisibility = new BooleanBinding() {
        @Override
        protected boolean computeValue() {
            return StringUtils.isNullOrEmpty(text.get());
        }
    };

    private ObjectProperty<Color> color = new SimpleObjectProperty<>(Color.GREEN);
    private StringBinding style = new StringBinding() {
        @Override
        protected String computeValue() {
            return "-fx-background-color: " + toRGBCode(color.get());
        }
    };
    private StringBinding lighterStyle = new StringBinding() {
        @Override
        protected String computeValue() {
            return "-fx-background-color: " + toRGBCode(color.get().brighter().brighter());
        }
    };
    private StringBinding darkerStyle = new StringBinding() {
        @Override
        protected String computeValue() {
            return "-fx-background-color: " + toRGBCode(color.get().darker().darker());
        }
    };

    public final BooleanProperty boolProperty() {
        return bool;
    }

    public final BooleanBinding boolInvertedBinding() {
        return boolInverted;
    }

    public BooleanBinding boolToVisibilityBinding() {
        return boolToVisibility;
    }

    public final StringProperty textProperty() {
        return text;
    }

    public BooleanBinding emptyToVisibilityBinding() {
        return emptyToVisibility;
    }

    public final StringBinding styleBinding() {
        return style;
    }

    public final StringBinding styleLighterBinding() {
        return lighterStyle;
    }

    public final StringBinding styleDarkerBinding() {
        return darkerStyle;
    }


    public static String toRGBCode(Color color) {
        return String.format("#%02X%02X%02X", (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255), (int) (color.getBlue() * 255));
    }
}
