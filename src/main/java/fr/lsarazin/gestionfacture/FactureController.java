package fr.lsarazin.gestionfacture;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FactureController {
    @FXML
    private Button cancelButton;

    @FXML
    private TextField entreprise;

    @FXML
    private TextField adresse;

    @FXML
    private DatePicker date;

    @FXML
    private TextField paiement;

    @FXML
    private TextArea infos;

    @FXML
    private TextField description;

    @FXML
    private TextField quantite;

    @FXML
    private TextField prix;

    @FXML
    protected void onReturnButtonClick() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void createInvoice() {
        Map<String, String> data = new HashMap<>();
        data.put("entreprise", entreprise.getText());
        data.put("adresse", adresse.getText());
        data.put("date", date.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        data.put("paiement", paiement.getText());
        data.put("infos", infos.getText());
        data.put("description", description.getText());
        data.put("quantite", quantite.getText());
        data.put("prix", prix.getText());

        PdfHelper pdf = new PdfHelper(data);
        pdf.create();
    }
}
