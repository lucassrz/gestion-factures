package fr.lsarazin.gestionfacture;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    protected void onCreateDevisClick() {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("create-devis.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 700, 370);
                Stage stage = new Stage();
                stage.setTitle("Créer un devis");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    @FXML
    protected void onCreateFactureClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("create-facture.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 370);
            Stage stage = new Stage();
            stage.setTitle("Créer une facture");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}