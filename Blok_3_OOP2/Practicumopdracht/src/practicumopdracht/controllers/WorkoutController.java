package practicumopdracht.controllers;

import javafx.scene.control.*;
import javafx.scene.control.TextField;
import practicumopdracht.MainApplication;
import practicumopdracht.comparators.DateComparator;
import practicumopdracht.data.ExerciseDAO;
import practicumopdracht.data.WorkoutDAO;
import practicumopdracht.models.Exercise;
import practicumopdracht.models.Workout;
import practicumopdracht.views.View;
import practicumopdracht.views.WorkoutView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static practicumopdracht.MainApplication.switchController;

public class WorkoutController extends Controller {

    private WorkoutView view = new WorkoutView();
    private ExerciseDAO exerciseDAO = MainApplication.getExerciseDAO();
    private WorkoutDAO workoutDAO = MainApplication.getWorkoutDAO();

    // Getting all input fields
    private final TextField NAME = view.getNameTextField();
    private final DatePicker DATE = view.getDatePicker();
    private final CheckBox CHECKBOX = view.getCheckBox();
    private final ListView<Workout> LIST_VIEW = view.getListView();

    // Getting all buttons.
    private final Button SAVE_BUTTON = view.getSaveButton();
    private final Button SWITCH_BUTTON = view.getSwitchButton();
    private final Button DELETE_BUTTON = view.getDeleteButton();
    private final ButtonType YES_BUTTON = view.getYesButton();
    private final ButtonType NO_BUTTON = view.getNoButton();
    private final ButtonType OK_BUTTON = view.getOkButton();

    public WorkoutController() {
        view.getNewButton().setOnAction(actionEvent -> handleNewButton());
        SAVE_BUTTON.setOnAction(actionEvent -> {
            if (handleSaveButton()) {
                resetListView();
            }
        });

        DELETE_BUTTON.setOnAction(actionEvent -> handleDeleteButton());
        SWITCH_BUTTON.setOnAction(actionEvent -> handleSwitchButton());

        // Adding all items to ListView.
        LIST_VIEW.getItems().addAll(workoutDAO.getAll());

        // Adds a ChangeListener to the ListView, when a workout is selected, the button opacity is removed.
        LIST_VIEW.getSelectionModel().selectedItemProperty().addListener((observableValue, oldSelectedWorkout,
                                                                          newSelectedWorkout) -> {
            if (newSelectedWorkout != null) {
                SWITCH_BUTTON.setId("");
                SAVE_BUTTON.setId("save");
                DELETE_BUTTON.setId("delete");

                resetBorderColor();
                displayWorkout(newSelectedWorkout);
            }
        });

        view.getMenuItemLoad().setOnAction(actionEvent -> {
            if (warningAlert("Weet je zeker dat je alle workouts wilt inladen?", "Workouts Inladen", "Laden")) {
                workoutDAO.getAll().clear();
                exerciseDAO.getAll().clear();

                if (workoutDAO.load() && exerciseDAO.load()) {
                    workoutDAO.getAll().sort(new DateComparator(false));

                    resetListView();
                    okAlert("Alle workouts zijn ingeladen.");
                }
            }
        });

        view.getMenuItemSave().setOnAction(actionEvent -> {
            if (warningAlert("Weet je zeker dat je alle workouts wilt opslaan?", "Workouts Opslaan", "Opslaan")) {
                if (workoutDAO.save() && exerciseDAO.save()) {
                    okAlert("Alle workouts zijn opgeslagen");
                }
            }
        });

        view.getMenuItemClose().setOnAction(actionEvent -> {
            if (warningAlert("Wil je dat de workouts nog eenmalig worden opgeslagen?",
                    "Programma Afsluiten", "Afsluiten")) {
                workoutDAO.save();
                exerciseDAO.save();
            }

            System.exit(0);
        });

        view.getMenuItemDateAscending().setOnAction(actionEvent -> {
            sort(false);
            resetListView();
        });

        view.getMenuItemDateDescending().setOnAction(actionEvent -> {
            sort(true);
            resetListView();
        });
    }

    public boolean handleSaveButton() {
        if (LIST_VIEW.getSelectionModel().getSelectedItem() != null || SAVE_BUTTON.getId().equals("save")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // Making the alert.
            Alert alert = new Alert(Alert.AlertType.WARNING, "De volgende fouten zijn gevonden:\n", OK_BUTTON);
            alert.setHeaderText("Er is iets mis gegaan...");
            alert.setTitle("Foutmelding");
            boolean showAlert = false;

            // Getting the values of the input fields.
            boolean checkBoxInput = CHECKBOX.isSelected();
            String nameInput = NAME.getText().trim();
            String datePickerInput = "";

            // Datepicker validation.
            if (DATE.getValue() == null) {
                alert.setContentText(alert.getContentText() + "- De datum is leeg.\n");
                showAlert = true;
                DATE.setId("validation");
            } else {
                datePickerInput = DATE.getValue().format(dtf);
                DATE.setId("");
            }

            // Name input field validation.
            showAlert = validateName(alert, showAlert, nameInput, NAME);

            if (showAlert) {
                alert.showAndWait();
            } else {
                Workout model;
                Workout selectedItem = LIST_VIEW.getSelectionModel().getSelectedItem();

                if (selectedItem != null) { // If an item is selected.
                    selectedItem.setName(nameInput);
                    selectedItem.setDate(LocalDate.parse(datePickerInput, dtf));
                    selectedItem.setCompleted(checkBoxInput);

                    model = selectedItem;
                } else {
                    model = new Workout(nameInput, LocalDate.parse(datePickerInput, dtf), checkBoxInput);
                    workoutDAO.addOrUpdate(model);
                }

                confirmationAlert(OK_BUTTON, model.toString());
                clearInputFields();

                return true;
            }
        }

        return false;
    }

    private void clearInputFields() {
        NAME.clear();
        DATE.setValue(null);
        CHECKBOX.setSelected(false);
        SWITCH_BUTTON.setId("opacity");
        SAVE_BUTTON.setId("save-opacity");
    }

    private void resetBorderColor() {
        NAME.setId("");
        DATE.setId("");
    }

    private void resetListView() {
        LIST_VIEW.getItems().clear();
        LIST_VIEW.getItems().addAll(workoutDAO.getAll());
    }

    private void displayWorkout(Workout selectedWorkout) {
        NAME.setText(selectedWorkout.getName());
        DATE.setValue(selectedWorkout.getDate());
        CHECKBOX.setSelected(selectedWorkout.isCompleted());
    }

    private void handleDeleteButton() {
        Workout selectedItem = LIST_VIEW.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    String.format("Weet je zeker dat je de volgende workout wilt verwijderen?\n\n%s",
                    selectedItem), NO_BUTTON, YES_BUTTON);
            alert.setHeaderText("Workout Verwijderen");
            alert.setTitle("Delete");

            Optional<ButtonType> clickedButton = alert.showAndWait();
            if (clickedButton.get().getText().equals(YES_BUTTON.getText())) {
                List<Exercise> exercisesFromWorkout = exerciseDAO.getAllFor(selectedItem);
                for (Exercise exercise : exercisesFromWorkout) {
                    MainApplication.getExerciseDAO().remove(exercise);
                }

                workoutDAO.remove(selectedItem);
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
        if (LIST_VIEW.getSelectionModel().getSelectedItem() != null) {
            switchController(new ExerciseController(LIST_VIEW.getSelectionModel().getSelectedItem()));
        }
    }

    private boolean warningAlert(String descriptionText, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.WARNING, descriptionText, view.getNoButton(), YES_BUTTON);
        alert.setHeaderText(headerText);
        alert.setTitle(title);

        Optional<ButtonType> clickedButton =  alert.showAndWait();
        return clickedButton.get().getText().equals(YES_BUTTON.getText());
    }

    private void okAlert(String okText) {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION, okText, OK_BUTTON);
        confirmationAlert.setHeaderText("Success!");
        confirmationAlert.setTitle("Bevestiging");

        confirmationAlert.showAndWait();
    }

    private void sort(boolean descend) {
        DateComparator dateComparator = new DateComparator(descend);
        workoutDAO.getAll().sort(dateComparator);
        dateComparator.reverseIfDescending();
        resetListView();
    }

    @Override
    public View getView() {
        return view;
    }
}
