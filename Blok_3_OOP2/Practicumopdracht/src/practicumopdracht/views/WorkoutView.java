package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import practicumopdracht.models.Workout;

/**
 * Sub-Class of View, contains all things view related to Workout.
 *
 * @author Tim Knops
 * @see View
 * @see Workout
 */
public class WorkoutView extends View {

    private Button saveButton;
    private Button newButton;
    private Button deleteButton;
    private Button switchButton;
    private ButtonType okButton;
    private ButtonType yesButton;
    private ButtonType noButton;
    private TextField nameTextField;
    private DatePicker datePicker;
    private CheckBox checkBox;
    private ListView<Workout> listView;
    private MenuItem menuItemLoad;
    private MenuItem menuItemSave;
    private MenuItem menuItemClose;
    private MenuItem menuItemDateAscending;
    private MenuItem menuItemDateDescending;

    public WorkoutView() {

    }

    /** {@inheritDoc} */
    @Override
    protected Parent initializeView() {
        // Making the layout.
        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(640, 480);
        gridPane.setAlignment(Pos.CENTER);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.SOMETIMES);
        gridPane.getColumnConstraints().add(columnConstraints);

        RowConstraints rowTopBar = new RowConstraints();
        RowConstraints row0 = new RowConstraints();
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();

        rowTopBar.setPercentHeight(6);
        row0.setPercentHeight(14); //14
        row1.setPercentHeight(30);
        row2.setPercentHeight(38);
        row3.setPercentHeight(12);

        gridPane.getRowConstraints().addAll(rowTopBar, row0, row1, row2, row3);

        // Adding the menubar.
        BorderPane borderPane = new BorderPane();
        MenuBar menuBar = new MenuBar();
        borderPane.setTop(menuBar);
        Menu menu1 = new Menu("Bestand");
        Menu menu2 = new Menu("Sorteren");

        menuBar.getMenus().addAll(menu1, menu2);

        menuItemLoad = new MenuItem("Laden");
        menuItemSave = new MenuItem("Opslaan");
        menuItemClose = new MenuItem("Afsluiten");

        menu1.getItems().addAll(menuItemLoad, menuItemSave, menuItemClose);

        menuItemDateAscending = new MenuItem("Datum (Nieuw - Oud)");
        menuItemDateDescending = new MenuItem("Datum (Oud - Nieuw)");

        menu2.getItems().addAll(menuItemDateAscending, menuItemDateDescending);


        gridPane.add(borderPane, 0, 0);

        // Adding the title.
        HBox titleHBox = new HBox();
        titleHBox.setAlignment(Pos.BOTTOM_CENTER);

        Text title = new Text("Workout Programma");
        title.setId("title");
        titleHBox.getChildren().add(title);
        gridPane.add(titleHBox, 0, 1);

        // Adding the listview.
        HBox listViewHBox = new HBox();
        listView = new ListView<>();
        listView.setPrefWidth(620);
        listViewHBox.getChildren().add(listView);
        listViewHBox.setPadding(new Insets(0, 10, 0, 10));
        gridPane.add(listViewHBox, 0, 3);

        // Adding the buttons.
        HBox buttonHbox = new HBox();
        buttonHbox.setPrefWidth(580);
        buttonHbox.setAlignment(Pos.CENTER);
        buttonHbox.setSpacing(15);
        buttonHbox.setPadding(new Insets(0, 10, 0, 10));

        gridPane.add(buttonHbox, 0, 4);

        saveButton = new Button("Opslaan");
        saveButton.setPrefWidth(150);
        saveButton.setId("save-opacity");
        newButton = new Button("Nieuw");
        newButton.setPrefWidth(150);
        deleteButton = new Button("Verwijderen");
        deleteButton.setPrefWidth(150);
        deleteButton.setId("delete-opacity");
        switchButton = new Button("Oefeningen");
        switchButton.setPrefWidth(150);
        switchButton.setId("opacity");

        buttonHbox.getChildren().addAll(saveButton, deleteButton, newButton, switchButton);

        // Adding container for all input fields.
        VBox inputFieldsVBox = new VBox();
        inputFieldsVBox.setAlignment(Pos.CENTER);
        inputFieldsVBox.setPadding(new Insets(0, 10, 0, 10));
        gridPane.add(inputFieldsVBox, 0, 2);

        // Adding name input field.
        HBox nameHBox = new HBox();
        nameHBox.setPrefSize(200, 40);
        nameHBox.setAlignment(Pos.CENTER_LEFT);
        inputFieldsVBox.getChildren().add(nameHBox);

        Label nameLabel = new Label("Naam:");
        nameLabel.setPrefWidth(100);
        nameTextField = new TextField();
        nameTextField.setPrefWidth(520);
        nameHBox.getChildren().addAll(nameLabel, nameTextField);

        // Adding date picker.
        HBox dateHBox = new HBox();
        dateHBox.setPrefSize(200, 40);
        dateHBox.setAlignment(Pos.CENTER_LEFT);
        inputFieldsVBox.getChildren().add(dateHBox);

        Label dateLabel = new Label("Datum:");
        dateLabel.setPrefWidth(100);
        datePicker = new DatePicker();
        datePicker.setPrefWidth(520);
        datePicker.setEditable(false);
        dateHBox.getChildren().addAll(dateLabel, datePicker);

        // Adding finished checkbox.
        HBox finishedHBox = new HBox();
        finishedHBox.setPrefSize(200, 40);
        finishedHBox.setAlignment(Pos.CENTER_LEFT);
        inputFieldsVBox.getChildren().add(finishedHBox);

        Label finishedLabel = new Label("Afgerond:");
        finishedLabel.setPrefWidth(100);
        checkBox = new CheckBox();
        finishedHBox.getChildren().addAll(finishedLabel, checkBox);

        // Buttons for the alerts.
        okButton = new ButtonType("Ok");
        yesButton = new ButtonType("Ja");
        noButton = new ButtonType("Nee");

        return gridPane;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getNewButton() {
        return newButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Button getSwitchButton() {
        return switchButton;
    }

    public ButtonType getOkButton() {
        return okButton;
    }

    public ButtonType getYesButton() {
        return yesButton;
    }

    public ButtonType getNoButton() {
        return noButton;
    }

    public TextField getNameTextField() {
        return nameTextField;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public ListView<Workout> getListView() {
        return listView;
    }

    public MenuItem getMenuItemLoad() {
        return menuItemLoad;
    }

    public MenuItem getMenuItemSave() {
        return menuItemSave;
    }

    public MenuItem getMenuItemClose() {
        return menuItemClose;
    }

    public MenuItem getMenuItemDateAscending() {
        return menuItemDateAscending;
    }

    public MenuItem getMenuItemDateDescending() {
        return menuItemDateDescending;
    }
}
