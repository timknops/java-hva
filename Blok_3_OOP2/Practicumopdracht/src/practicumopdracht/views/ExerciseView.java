package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import practicumopdracht.models.Exercise;
import practicumopdracht.models.Workout;

/**
 * Sub-Class of View, contains all view things related to Exercise.
 *
 * @author Tim Knops
 * @see    Exercise
 * @see    View
 */
public class ExerciseView extends View {

    private Button saveButton;
    private Button newButton;
    private Button deleteButton;
    private Button switchButton;
    private ButtonType okButton;
    private ButtonType yesButton;
    private ButtonType noButton;
    private TextField nameTextField;
    private TextField setsTextField;
    private TextField repsTextField;
    private TextField weightTextField;
    private TextField rateOfPerceivedExertionTextField;
    private TextArea notesTextArea;
    private Label setsLabel;
    private Label repsLabel;
    private Label weightLabel;
    private Label rateOfPerceivedExertionLabel;
    private Label notesLabel;
    private ComboBox<Workout> exercisesComboBox;
    private ListView<Exercise> listView;
    private ToggleGroup toggleGroup;
    private RadioButton radioButtonNameAscending;
    private RadioButton radioButtonNameDescending;
    private RadioButton radioButtonVolumeAscending;
    private RadioButton radioButtonVolumeDescending;

    public ExerciseView() {
    }

    /** {@inheritDoc} */
    @Override
    protected Parent initializeView() {
        // Making the layout.
        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(640, 480);
        gridPane.setPadding(new Insets(10, 10, 15, 10));
        gridPane.setAlignment(Pos.CENTER);

        ColumnConstraints column = new ColumnConstraints();
        column.setHgrow(Priority.SOMETIMES);
        gridPane.getColumnConstraints().add(column);

        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        RowConstraints row4 = new RowConstraints();

        row1.setPercentHeight(44);
        row2.setPercentHeight(39);
        row3.setPercentHeight(7);
        row4.setPercentHeight(10);

        gridPane.getRowConstraints().addAll(row1, row2, row3, row4);

        // Adding the listview.
        listView = new ListView<>();
        listView.setPrefWidth(620);
        gridPane.add(listView, 0, 1);

        // Adding the buttons.
        HBox buttonHbox = new HBox();
        buttonHbox.setPrefWidth(580);
        buttonHbox.setAlignment(Pos.BOTTOM_CENTER);
        buttonHbox.setSpacing(15);
        gridPane.add(buttonHbox, 0, 3);

        saveButton = new Button("Opslaan");
        saveButton.setPrefWidth(150);
        saveButton.setId("save-opacity");
        newButton = new Button("Nieuw");
        newButton.setPrefWidth(150);
        deleteButton = new Button("Verwijderen");
        deleteButton.setPrefWidth(150);
        deleteButton.setId("delete-opacity");
        switchButton = new Button("Terug");
        switchButton.setPrefWidth(150);

        buttonHbox.getChildren().addAll(saveButton, deleteButton, newButton, switchButton);

        // Adding the radiobuttons.
        HBox radioButtonHbox = new HBox();
        radioButtonHbox.setPrefWidth(580);
        radioButtonHbox.setAlignment(Pos.BOTTOM_CENTER);
        radioButtonHbox.setSpacing(23);
        gridPane.add(radioButtonHbox, 0, 2);

        toggleGroup = new ToggleGroup();
        radioButtonNameAscending = new RadioButton("Naam (A - Z)");
        radioButtonNameAscending.setToggleGroup(toggleGroup);
        radioButtonNameAscending.setSelected(true);

        radioButtonNameDescending = new RadioButton("Naam (Z - A)");
        radioButtonNameDescending.setToggleGroup(toggleGroup);

        radioButtonVolumeAscending = new RadioButton("Volume (Laag - Hoog)");
        radioButtonVolumeAscending.setToggleGroup(toggleGroup);

        radioButtonVolumeDescending = new RadioButton("Volume (Hoog - Laag)");
        radioButtonVolumeDescending.setToggleGroup(toggleGroup);

        radioButtonHbox.getChildren().addAll(radioButtonNameAscending, radioButtonNameDescending,
                radioButtonVolumeAscending, radioButtonVolumeDescending);

        // Adding container for all input fields.
        VBox inputFieldsVBox = new VBox();
        inputFieldsVBox.setPadding(new Insets(0, 0, 10, 0));
        inputFieldsVBox.setAlignment(Pos.TOP_CENTER);
        gridPane.getChildren().add(inputFieldsVBox);

        // Adding exercises choice-box.
        HBox exercisesHbox = new HBox();
        exercisesHbox.setPrefSize(580, 40);
        exercisesHbox.setAlignment(Pos.CENTER);
        inputFieldsVBox.getChildren().add(exercisesHbox);

        Label exercisesLabel = new Label("Workouts:");
        exercisesLabel.setPrefWidth(100);
        exercisesComboBox = new ComboBox<>();
        exercisesComboBox.setPrefWidth(520);
        exercisesHbox.getChildren().addAll(exercisesLabel, exercisesComboBox);

        // Adding name input field.
        HBox nameHBox = new HBox();
        nameHBox.setPrefSize(200, 40);
        nameHBox.setAlignment(Pos.CENTER);
        inputFieldsVBox.getChildren().add(nameHBox);

        Label nameLabel = new Label("Naam:");
        nameLabel.setPrefWidth(100);
        nameTextField = new TextField();
        nameTextField.setPrefWidth(520);
        nameHBox.getChildren().addAll(nameLabel, nameTextField);

        // Adding sets, reps, weight, notes and rpe container
        HBox setsRepsWeightNotesRpeHBox = new HBox();
        setsRepsWeightNotesRpeHBox.setPrefSize(620, 120);
        setsRepsWeightNotesRpeHBox.setAlignment(Pos.CENTER_LEFT);
        inputFieldsVBox.getChildren().add(setsRepsWeightNotesRpeHBox);

        // Adding vertical container for sets, reps and weight.
        VBox setsRepsWeightVBox = new VBox();
        setsRepsWeightVBox.setPrefWidth(260);
        setsRepsWeightNotesRpeHBox.getChildren().add(setsRepsWeightVBox);

        // Adding sets input field.
        HBox setsHBox = new HBox();
        setsHBox.setPrefSize(200, 40);
        setsHBox.setAlignment(Pos.CENTER_LEFT);
        setsRepsWeightVBox.getChildren().add(setsHBox);

        setsLabel = new Label("Sets:");
        setsLabel.setPrefWidth(100);
        setsTextField = new TextField();
        setsTextField.setPrefWidth(100);
        setsHBox.getChildren().addAll(setsLabel, setsTextField);

        // Adding reps input field.
        HBox repsHBox = new HBox();
        repsHBox.setPrefSize(200, 40);
        repsHBox.setAlignment(Pos.CENTER_LEFT);
        setsRepsWeightVBox.getChildren().add(repsHBox);

        repsLabel = new Label("Reps:");
        repsLabel.setPrefWidth(100);
        repsTextField = new TextField();
        repsTextField.setPrefWidth(100);
        repsHBox.getChildren().addAll(repsLabel, repsTextField);

        // Adding weight input field.
        HBox weightHBox = new HBox();
        weightHBox.setPrefSize(200, 40);
        weightHBox.setAlignment(Pos.CENTER_LEFT);
        setsRepsWeightVBox.getChildren().add(weightHBox);

        weightLabel = new Label("Gewicht:");
        weightLabel.setPrefWidth(100);
        weightTextField = new TextField();
        weightTextField.setPrefWidth(100);
        weightHBox.getChildren().addAll(weightLabel, weightTextField);

        // Adding container for the rpe and notes section.
        VBox notesRateOfPerceivedExertionVBox = new VBox();
        setsRepsWeightNotesRpeHBox.getChildren().add(notesRateOfPerceivedExertionVBox);

        // Adding RPE Input field.
        HBox rateOfPerceivedExertionHBox = new HBox();
        rateOfPerceivedExertionHBox.setPrefSize(380, 40);
        rateOfPerceivedExertionHBox.setAlignment(Pos.CENTER_LEFT);

        rateOfPerceivedExertionLabel = new Label("RPE:");
        rateOfPerceivedExertionLabel.setPrefWidth(70);
        rateOfPerceivedExertionTextField = new TextField();
        rateOfPerceivedExertionTextField.setPrefWidth(100);
        rateOfPerceivedExertionHBox.getChildren().addAll(rateOfPerceivedExertionLabel, rateOfPerceivedExertionTextField);
        notesRateOfPerceivedExertionVBox.getChildren().add(rateOfPerceivedExertionHBox);

        // Adding notes input field.
        HBox notesHBox = new HBox();
        notesHBox.setPrefSize(360, 80);
        notesRateOfPerceivedExertionVBox.getChildren().add(notesHBox);

        notesLabel = new Label("Notities:");
        notesLabel.setPrefSize(70, 22);
        notesTextArea = new TextArea();
        notesTextArea.setPrefWidth(300);
        notesHBox.setPadding(new Insets(8, 0, 8, 0));
        notesHBox.getChildren().addAll(notesLabel, notesTextArea);

        // Button for the alert.
        okButton = new ButtonType("OK");
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

    public TextField getSetsTextField() {
        return setsTextField;
    }

    public TextField getRepsTextField() {
        return repsTextField;
    }

    public TextField getWeightTextField() {
        return weightTextField;
    }

    public TextField getRateOfPerceivedExertionTextField() {
        return rateOfPerceivedExertionTextField;
    }

    public TextArea getNotesTextArea() {
        return notesTextArea;
    }

    public Label getSetsLabel() {
        return setsLabel;
    }

    public Label getRepsLabel() {
        return repsLabel;
    }

    public Label getWeightLabel() {
        return weightLabel;
    }

    public Label getRateOfPerceivedExertionLabel() {
        return rateOfPerceivedExertionLabel;
    }

    public Label getNotesLabel() {
        return notesLabel;
    }

    public ComboBox<Workout> getExercisesComboBox() {
        return exercisesComboBox;
    }

    public ListView<Exercise> getListView() {
        return listView;
    }

    public ToggleGroup getToggleGroup() {
        return toggleGroup;
    }

    public RadioButton getRadioButtonNameAscending() {
        return radioButtonNameAscending;
    }

    public RadioButton getRadioButtonNameDescending() {
        return radioButtonNameDescending;
    }

    public RadioButton getRadioButtonVolumeAscending() {
        return radioButtonVolumeAscending;
    }

    public RadioButton getRadioButtonVolumeDescending() {
        return radioButtonVolumeDescending;
    }
}
