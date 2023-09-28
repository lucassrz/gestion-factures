package fr.lsarazin.gestionfacture;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DevisController {
    @FXML
    private Button cancelButton;

    @FXML
    protected void onReturnButtonClick() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
