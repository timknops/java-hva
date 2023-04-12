package practicumopdracht.controllers;

import javafx.scene.control.*;
import practicumopdracht.MainApplication;
import practicumopdracht.comparators.NameComparator;
import practicumopdracht.comparators.VolumeComparator;
import practicumopdracht.data.ExerciseDAO;
import practicumopdracht.models.Exercise;
import practicumopdracht.models.Workout;
import practicumopdracht.views.ExerciseView;
import practicumopdracht.views.View;
import java.util.Collections;
import java.util.Optional;

import static practicumopdracht.MainApplication.switchController;

public class ExerciseController extends Controller {

    private ExerciseView view = new ExerciseView();
    private ExerciseDAO exerciseDAO = MainApplication.getExerciseDAO();
    private Workout workoutModel;

    // Getting all input fields.
    private final TextField NAME = view.getNameTextField();
    private final TextField SETS = view.getSetsTextField();
    private final TextField REPS = view.getRepsTextField();
    private final TextField WEIGHT = view.getWeightTextField();
    private final TextField RATE_OF_PERCEIVED_EXERTION = view.getRateOfPerceivedExertionTextField();
    private final TextArea NOTES = view.getNotesTextArea();
    private final ListView<Exercise> LIST_VIEW = view.getListView();

    // Getting all buttons.
    private final Button SAVE_BUTTON = view.getSaveButton();
    private final Button DELETE_BUTTON = view.getDeleteButton();
    private final ButtonType OK_BUTTON = view.getOkButton();
    private final ButtonType YES_BUTTON = view.getYesButton();
    private final ButtonType NO_BUTTON = view.getNoButton();

    public ExerciseController(Workout workoutModel) {
        this.workoutModel = workoutModel;

        view.getNewButton().setOnAction(actionEvent -> handleNewButton());
        SAVE_BUTTON.setOnAction(actionEvent -> {
            if (handleSaveButton()) {
                resetListView();
            }
        });

        DELETE_BUTTON.setOnAction(actionEvent -> handleDeleteButton());
        view.getSwitchButton().setOnAction(actionEvent -> handleSwitchButton());

        ComboBox<Workout> COMBO_BOX = view.getExercisesComboBox();
        COMBO_BOX.getItems().addAll(MainApplication.getWorkoutDAO().getAll());
        COMBO_BOX.getSelectionModel().select(this.workoutModel); // Selects the workout that was chosen in the WorkoutView.

        LIST_VIEW.getItems().addAll(exerciseDAO.getAllFor(this.workoutModel));

        // Adding a ChangeListener to the combobox, when a model is selected it is notified.
        COMBO_BOX.valueProperty().addListener((observableValue, oldSelectedWorkout, newSelectedWorkout) -> {
            this.workoutModel = newSelectedWorkout;
            clearInputFields();
            resetListView();
            resetBorderColor();
        });

        // Adding a ChangeListener to the listview, when a model is selected it is notified.
        LIST_VIEW.getSelectionModel().selectedItemProperty().addListener((observableValue, oldSelectedWorkout,
                                                                          newSelectedWorkout) -> {
            if (newSelectedWorkout != null) {
                resetBorderColor();
                displayExercise(newSelectedWorkout);
                SAVE_BUTTON.setId("save");
                DELETE_BUTTON.setId("delete");
            }
        });

        view.getToggleGroup().selectedToggleProperty().addListener((observableValue, oldToggledButton, newToggledButton) -> {
            if (newToggledButton.equals(view.getRadioButtonNameAscending())) {
                sort(false, true);
            } else if (newToggledButton.equals(view.getRadioButtonNameDescending())) {
                sort(true, true);
            } else if (newToggledButton.equals(view.getRadioButtonVolumeAscending())) {
                sort(false, false);
            } else {
                sort(true, false);
            }
        });

        sort(false, true);
    }

    private boolean handleSaveButton() {
        if (LIST_VIEW.getSelectionModel().getSelectedItem() != null || SAVE_BUTTON.getId().equals("save")) {
            final int MAX_NOTES_LENGTH = 300, MAX_RPE = 10, MIN_RPE = 0;

            // Making the alert.
            Alert alert = new Alert(Alert.AlertType.WARNING, "De volgende fouten zijn gevonden:\n", OK_BUTTON);
            alert.setHeaderText("Er is iets mis gegaan...");
            alert.setTitle("Foutmelding");
            boolean showAlert = false;

            // Getting all the input fields.
            String nameInput = NAME.getText().trim();
            String setsInput = SETS.getText();
            String repsInput = REPS.getText();
            String weightInput = WEIGHT.getText().replace(",", ".");
            String rateOfPerceivedExertionInput = RATE_OF_PERCEIVED_EXERTION.getText().replace(",", ".");
            String notesInput = NOTES.getText() == null ? NOTES.getText() : NOTES.getText().trim();

            // Name input field validation.
            showAlert = validateName(alert, showAlert, nameInput, NAME);

            // Sets, reps, weight and rpe input fields validation.
            showAlert = validateIntDoubleInputFields(alert, setsInput, SETS, view.getSetsLabel(),
                    showAlert, false);
            showAlert = validateIntDoubleInputFields(alert, repsInput, REPS, view.getRepsLabel(),
                    showAlert, false);
            showAlert = validateIntDoubleInputFields(alert, weightInput, WEIGHT, view.getWeightLabel(),
                    showAlert, true);
            showAlert = validateIntDoubleInputFields(alert, rateOfPerceivedExertionInput,
                    RATE_OF_PERCEIVED_EXERTION, view.getRateOfPerceivedExertionLabel(), showAlert, false);

            // Validates so that rateOfPerceivedExertion is in between 1 and 10.
            try {
                String label = view.getRateOfPerceivedExertionLabel().getText().replace(":", "");

                if (Integer.parseInt(rateOfPerceivedExertionInput) > MAX_RPE) {
                    alert.setContentText(String.format("%s- %s kan niet hoger zijn dan %d.\n",
                            alert.getContentText(), label, MAX_RPE));
                    RATE_OF_PERCEIVED_EXERTION.setId("validation");
                    showAlert = true;
                } else if (Integer.parseInt(rateOfPerceivedExertionInput) < MIN_RPE) {
                    alert.setContentText(String.format("%s- %s kan niet lager zijn dan %d.\n",
                            alert.getContentText(), label, MIN_RPE));
                    RATE_OF_PERCEIVED_EXERTION.setId("validation");
                    showAlert = true;
                } else {
                    RATE_OF_PERCEIVED_EXERTION.setId("");
                }
            } catch (NumberFormatException ignored) {}

            // Validation for the notes.
            if (notesInput != null && notesInput.length() > MAX_NOTES_LENGTH) {
                alert.setContentText(String.format("%s- %s is te lang.\n",
                        alert.getContentText(), view.getNotesLabel().getText().replace(":", "")));
                NOTES.setId("validation");
                showAlert = true;
            } else if (notesInput != null && notesInput.isBlank()) {
                notesInput = null;
            } else {
                NOTES.setId("");
            }

            if (showAlert) {
                alert.show();
            } else {
                Exercise model;
                Exercise selectedItem = LIST_VIEW.getSelectionModel().getSelectedItem();

                if (selectedItem != null) { // If an item is selected.
                    selectedItem.setName(nameInput);
                    selectedItem.setReps(Integer.parseInt(repsInput));
                    selectedItem.setSets(Integer.parseInt(setsInput));
                    selectedItem.setWeight(Double.parseDouble(weightInput));
                    selectedItem.setRateOfPerceivedExertion(Integer.parseInt(rateOfPerceivedExertionInput));
                    selectedItem.setNotes(notesInput);

                    model = selectedItem;
                } else {
                    model = new Exercise(this.workoutModel, nameInput, Integer.parseInt(setsInput), Integer.parseInt(repsInput),
                            Double.parseDouble(weightInput), notesInput, Integer.parseInt(rateOfPerceivedExertionInput));

                    exerciseDAO.addOrUpdate(model);
                }

                confirmationAlert(OK_BUTTON, model.toString());
                clearInputFields();

                return true;
            }
        }

        return false;
    }

    private boolean validateIntDoubleInputFields(Alert alert, String inputFieldText, TextField inputField,
                                                Label label, boolean showAlert, boolean isDouble) {
        if (inputFieldText.isBlank()) {
            alert.setContentText(String.format("%s- %s is leeg.\n",
                    alert.getContentText(), label.getText().replace(":", "")));
            inputField.setId("validation");
            showAlert = true;
        } else {
            try {
                if (isDouble) {
                    Double.parseDouble(inputFieldText);
                } else {
                    Integer.parseInt(inputFieldText);
                }

                inputField.setId("");
            } catch (NumberFormatException e) {
                inputField.setId("validation");

                String parsedLabelText = label.getText().replace(":", "");
                if (parsedLabelText.equals("RPE")) {
                    alert.setContentText(String.format("%s- %s is geen getal en/of geen heel getal.\n",
                            alert.getContentText(), parsedLabelText));
                } else {
                    alert.setContentText(String.format("%s- %s is geen getal.\n",
                            alert.getContentText(), parsedLabelText));
                }
                showAlert = true;
            }
        }

        return showAlert;
    }

    private void clearInputFields() {
        NAME.clear();
        SETS.clear();
        REPS.clear();
        WEIGHT.clear();
        RATE_OF_PERCEIVED_EXERTION.clear();
        NOTES.clear();
        view.getSaveButton().setId("save-opacity");
    }

    private void resetBorderColor() {
        NAME.setId("");
        SETS.setId("");
        REPS.setId("");
        WEIGHT.setId("");
        RATE_OF_PERCEIVED_EXERTION.setId("");
        NOTES.setId("");
    }

    private void resetListView() {
        LIST_VIEW.getItems().clear();
        LIST_VIEW.getItems().addAll(exerciseDAO.getAllFor(this.workoutModel));
    }

    private void displayExercise(Exercise selectedExercise) {
        NAME.setText(selectedExercise.getName());
        SETS.setText(String.valueOf(selectedExercise.getSets()));
        REPS.setText(String.valueOf(selectedExercise.getReps()));
        WEIGHT.setText(String.valueOf(selectedExercise.getWeight()));
        RATE_OF_PERCEIVED_EXERTION.setText(String.valueOf(selectedExercise.getRateOfPerceivedExertion()));
        NOTES.setText(selectedExercise.getNotes());
    }

    private void handleDeleteButton() {
        Exercise selectedItem = LIST_VIEW.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    String.format("Weet je zeker dat je de volgende workout wilt verwijderen?\n\n%s",
                            selectedItem), NO_BUTTON, YES_BUTTON);
            alert.setHeaderText("Workout Verwijderen");
            alert.setTitle("Delete");

            Optional<ButtonType> clickedButton =  alert.showAndWait();
            if (clickedButton.get().getText().equals(YES_BUTTON.getText())) {
                exerciseDAO.remove(selectedItem);
                DELETE_BUTTON.setId("delete-opacity");
                resetListView();
                clearInputFields();
                resetBorderColor();
            }
        }
    }

    private void handleNewButton() {
        clearInputFields();
        resetBorderColor();
        LIST_VIEW.getSelectionModel().clearSelection();
        SAVE_BUTTON.setId("save");
        DELETE_BUTTON.setId("delete-opacity");
    }

    private void handleSwitchButton() {
        switchController(new WorkoutController());
    }

    private void sort(boolean descend, boolean sortByName) {
        if (sortByName) {
            NameComparator comparator = new NameComparator(descend);
            exerciseDAO.getAll().sort(comparator);

            if (comparator.isSortDescending()) {
                Collections.reverse(exerciseDAO.getAll());
            }
        } else {
            VolumeComparator comparator = new VolumeComparator(descend);
            exerciseDAO.getAll().sort(comparator);


            if (comparator.isSortDescending()) {
                Collections.reverse(exerciseDAO.getAll());
            }
        }

        resetListView();
    }

    @Override
    public View getView() {
        return view;
    }
}
