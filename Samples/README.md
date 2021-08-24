# JavaFX samples

Contains samples for the JavaFX GUI framework.  
_ATTENTION_: See documentation how JavaFX must be configured and activated in the run configurations!

## at.fhtw.disys.samples
* __AllDemos__ starts a JavaFX application presenting a simple menu to run all the JavaFX samples.
* __ControlsDemo__ starts a JavaFX application, showing how to put various kinds of simple
    controls like Text, TextField, ComboBox, CheckBox, RadioButtons and Buttons
    into a FXML window.
* __CSSDemo__ is a JavaFX application showing how to use cascading-style-sheets (CSS) in your user-interface.
    It also demonstrates how an user-defined control is used in the FXML.
* __DataBindingDemo__ is a JavaFX application that shows how to use data-binding in fxml.  
    A StringProperty is generated who stores a text value,
    which is bidirectional bound to a TextField (to be modified)
    and unidirectional bound to a Label via fxml.
* __EventHandlingDemo__ is a JavaFX application which shows how event-handling is implemented in Java
    via simple onAction-eventhandling directly at a control (here a Button)
    or with the PresentationModel-Pattern to provide a managable solution for multiple-handlings.
* __ImagesDemo__ is a JavaFX application which shows how to work with images and use them in an ImageView.
* __LayoutsDemo__ is a JavaFX application which demonstrates how layouting
    of your controls on the user-interface works,
    with samples of TabPane, VBox/HBox, StackPane and GridPane.
* __ListsDemo__ is a JavaFX application which demonstrates how to use
    ListView and TableView and how to fill them with data
* __ListsPresentationModelDemo__ is a JavaFX application which demonstrates how to use
    ListView and TableView and how to fill them with data based on presentation-model classes
* __SimpleBindingDemo__ is a JavaFX application showing how very simple (low level)
    bindings directly defined on multiple controls during the UI initialization works.  
    Demonstrates direct selected, visible and text-value bindings.
* __PresentationModelDemo__ is a JavaFX-application which shows how the presentation-model pattern
    is used in a user-interface.  
    The model (here an instance of a Person class) is primarily stored in the Controller-class
    which adds the references to the presentation-models.
    The user-interface only works with the presentation-models,
    so the model itself is indirectly accessed.
    The presentation-model manages the validation and data flow.
