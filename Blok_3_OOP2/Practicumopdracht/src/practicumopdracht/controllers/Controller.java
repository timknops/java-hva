package practicumopdracht.controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import practicumopdracht.views.View;

public abstract class Controller {

    public abstract View getView();

    protected boolean validateName(Alert alert, boolean showAlert, String nameInput, TextField nameTextField) {
        final int MAX_NAME_LENGTH = 80;

        if (nameInput.length() > MAX_NAME_LENGTH) {
            alert.setContentText(alert.getContentText() + "- De naam is te lang.\n");
            showAlert = true;
            nameTextField.setId("validation");
        } else if (nameInput.isBlank()) {
            alert.setContentText(alert.getContentText() + "- De naam is leeg.\n");
            showAlert = true;
            nameTextField.setId("validation");
        } else {
            nameTextField.setId("");
        }

        return showAlert;
    }

    protected void confirmationAlert(ButtonType OK_BUTTON, String model) {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION,
                "De volgende gegevens zijn opgeslagen:\n", OK_BUTTON);
        confirmationAlert.setHeaderText("Success!");
        confirmationAlert.setTitle("Bevestiging");
        confirmationAlert.setContentText(confirmationAlert.getContentText() + model);

        confirmationAlert.showAndWait();
    }
}
